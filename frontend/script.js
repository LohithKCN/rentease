const BASE_URL = "http://localhost:8080/api";

let currentProductId = null;
let uploadedImageUrl = "";
let allProducts = [];



function registerUser(){

const user = {
name: document.getElementById("name").value,
email: document.getElementById("email").value,
password: document.getElementById("password").value,
city: document.getElementById("city").value,
role: "USER"
};

fetch(BASE_URL + "/users/register",{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify(user)
})
.then(res=>res.json())
.then(data=>{
alert("Registration Successful");
window.location.href="login.html";
})
.catch(err=>console.log(err));

}



function loginUser(){

const user = {
email: document.getElementById("email").value,
password: document.getElementById("password").value
};

fetch(BASE_URL + "/users/login",{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify(user)
})
.then(res=>res.json())
.then(data=>{
alert("Login Successful!");
window.location.href="products.html";
})
.catch(err=>console.log(err));

}



function uploadImage(){

const file = document.getElementById("imageFile").files[0];

if(!file){
alert("Please select an image first");
return;
}

let formData = new FormData();
formData.append("file",file);

fetch(BASE_URL + "/upload",{
method:"POST",
body:formData
})
.then(res=>res.text())
.then(url=>{
uploadedImageUrl=url;
alert("Image uploaded successfully!");
})
.catch(err=>console.error(err));

}



function addProduct(){

if(uploadedImageUrl===""){
alert("Please upload image first!");
return;
}

const product = {
name: document.getElementById("name").value,
category: document.getElementById("category").value,
monthlyRent: Number(document.getElementById("rent").value),
securityDeposit: Number(document.getElementById("deposit").value),
stockQuantity: Number(document.getElementById("stock").value),
description: document.getElementById("description").value,
city: document.getElementById("city").value,
available:true,
imageUrl: uploadedImageUrl
};

fetch(BASE_URL + "/products/add",{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify(product)
})
.then(res=>res.json())
.then(data=>{
alert("Product added successfully!");
})
.catch(err=>{
console.error(err);
alert("Failed to add product");
});

}



function loadProducts(){

fetch(BASE_URL + "/products/all")
.then(res=>res.json())
.then(products=>{
allProducts = products;
displayProducts(products);
});

}


function displayProducts(products){

let html="";

products.forEach(p=>{

const imageUrl = p.imageUrl.startsWith("http")
? p.imageUrl
: "http://localhost:8080/"+p.imageUrl;

html+=`
<div class="product-card">

<img src="${imageUrl}" width="200"
onclick="openProduct(\`${imageUrl}\`,\`${p.name}\`,\`${p.category}\`,\`${p.monthlyRent}\`,\`${p.city}\`)">

<h3>${p.name}</h3>

<p>Category: ${p.category}</p>
<p>Rent: ₹${p.monthlyRent}</p>
<p>City: ${p.city}</p>

<label>Start Date</label>
<input type="date" id="start-${p.id}">

<label>End Date</label>
<input type="date" id="end-${p.id}">

<label>Quantity</label>
<input type="number" id="qty-${p.id}" min="1" value="1">

<br><br>

<button onclick="rentProduct(${p.id},${p.monthlyRent})">Rent Now</button>

<button onclick="openChat(${p.id})">Chat</button>

</div>
`;

});

document.getElementById("productList").innerHTML = html;

}



function filterProducts(category){

if(category==="all"){
displayProducts(allProducts);
}else{

const filtered = allProducts.filter(p=>p.category===category);
displayProducts(filtered);

}

}



function searchProducts(keyword){

keyword = keyword.toLowerCase();

const filtered = allProducts.filter(p =>
p.name.toLowerCase().includes(keyword)
);

displayProducts(filtered);

}



function rentProduct(productId, rentPrice){

let userId = 1;

const startDate =
document.getElementById("start-" + productId).value;

const endDate =
document.getElementById("end-" + productId).value;

const quantity =
document.getElementById("qty-" + productId).value;

if(!startDate || !endDate){
alert("Please select rental dates");
return;
}

const totalAmount = rentPrice * quantity;

const rental = {

user: { id: userId },
product: { id: productId },
startDate: startDate,
endDate: endDate,
totalAmount: totalAmount

};

fetch(BASE_URL + "/rentals/rent", {

method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify(rental)

})
.then(res=>res.json())
.then(data=>{
alert("Product rented successfully!");
})
.catch(err=>{
console.log(err);
alert("Rent failed");
});

}


function openChat(productId){

currentProductId = productId;
window.location.href = "chat.html?productId="+productId;

}

function sendMessage(){

const urlParams = new URLSearchParams(window.location.search);
const productId = urlParams.get("productId");

const message = {
senderId:1,
receiverId:2,
productId:productId,
content:document.getElementById("messageText").value
};

fetch(BASE_URL + "/messages/send",{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify(message)
})
.then(res=>res.json())
.then(data=>{
alert("Message sent!");
});

}



function openProduct(image,name,category,rent,city){

document.getElementById("popupImage").src=image;
document.getElementById("popupName").innerText=name;
document.getElementById("popupCategory").innerText="Category: "+category;
document.getElementById("popupRent").innerText="Rent: ₹"+rent;
document.getElementById("popupCity").innerText="City: "+city;

document.getElementById("productPopup").style.display="flex";

}

function closePopup(){
document.getElementById("productPopup").style.display="none";
}



function loadRentals(){

fetch(BASE_URL + "/rentals/all")
.then(res=>res.json())
.then(rentals=>{

let html="";

rentals.forEach(r=>{

html+=`
<div style="border:1px solid #ccc;padding:10px;margin:10px">

<h3>Product ID: ${r.product.id}</h3>
<p>Status: ${r.status}</p>
<p>Start Date: ${r.startDate}</p>
<p>End Date: ${r.endDate}</p>

</div>
`;

});

document.getElementById("rentalList").innerHTML=html;

});

}
function loadDashboard(){

document.getElementById("dashboardData").innerHTML =
"Select an option above to view data";

}

function loadUsers(){

fetch(BASE_URL + "/users/all")
.then(res=>res.json())
.then(users=>{

let html = "<h3>Registered Users</h3>";

users.forEach(u=>{

html += `
<div style="border:1px solid gray;padding:10px;margin:10px">

<p><b>Name:</b> ${u.name}</p>
<p><b>Email:</b> ${u.email}</p>
<p><b>City:</b> ${u.city}</p>

</div>
`;

});

document.getElementById("dashboardData").innerHTML = html;

});

}

function loadAdminProducts(){

fetch(BASE_URL + "/products/all")
.then(res=>res.json())
.then(products=>{

let html = "<h3>All Products</h3>";

products.forEach(p=>{

html += `
<div style="border:1px solid #ccc;padding:10px;margin:10px">

<h3>${p.name}</h3>

<p>Category: ${p.category}</p>
<p>Rent: ₹${p.monthlyRent}</p>
<p>Stock: ${p.stockQuantity}</p>

</div>
`;

});

document.getElementById("dashboardData").innerHTML = html;

});

}

function loadAdminRentals(){

fetch(BASE_URL + "/rentals/all")
.then(res=>res.json())
.then(rentals=>{

let html = "<h3>All Rentals</h3>";

rentals.forEach(r=>{

html += `
<div style="border:1px solid #ddd;padding:10px;margin:10px">

<p><b>Product:</b> ${r.product.name}</p>
<p><b>User:</b> ${r.user.name}</p>
<p><b>Start:</b> ${r.startDate}</p>
<p><b>End:</b> ${r.endDate}</p>

</div>
`;

});

document.getElementById("dashboardData").innerHTML = html;

});

}