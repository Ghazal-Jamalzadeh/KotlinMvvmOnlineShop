package com.jmzd.ghazal.kotlinmvvmonlineshop.model

data class DataModel_AddCart(
    val count: Int,
    val price: List<Price>,
    val price_post: String,
    val status: String
)

data class Price( // این در یک فایل جدا ایجاد می شود که خودمان میاریمش اینجا
    val price: String
)

////localhost/shop/addcart.php?check="add"&user=7&product=3&count=1
//
//// {
////     "status": "ok",
////     "count": 3,
////     "price": [
////         {
////             "price": "945000" // قیمت کل سبد
////         }
////     ],
////     "price_post": "120000" // قیمت مجموع همان محصول
//// }