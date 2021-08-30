package com.jmzd.ghazal.kotlinmvvmonlineshop.model

data class DataModel_Address(
    val address: String,
    val city: String,
    val code: String,
    val id: String,
    val iduser: String,
    val meli: String,
    val phone: String,
    val tell: String
)

//http://localhost/shop/get_address.php?user=7
//فقط با استفاده از یکی از آبجکت ها نمونه را ساختیم
//[
//{
//    "id": "5",
//    "iduser": "7",
//    "city": "رشت",
//    "meli": "1235",
//    "code": "987",
//    "address": "خیابان مطهری",
//    "phone": "0911",
//    "tell": "021"
//},
//{
//    "id": "6",
//    "iduser": "7",
//    "city": "iran",
//    "meli": "09876",
//    "code": "54321",
//    "address": "shahin shahr",
//    "phone": "0987",
//    "tell": "0912"
//},
//{
//    "id": "7",
//    "iduser": "7",
//    "city": "tabriz",
//    "meli": "878",
//    "code": "oooo",
//    "address": "khiabane ....",
//    "phone": "0918",
//    "tell": "987"
//}
//]