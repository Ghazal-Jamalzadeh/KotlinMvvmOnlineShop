package com.jmzd.ghazal.kotlinmvvmonlineshop.model

data class DataModel_AddOrder(
    val code: Int,
    val order: String,
    val price: String,
    val status: String
)
//http://localhost/shop/add_order.php?user=9&address=6
//{
//    "status": "ok",
//    "price": "60",
//    "code": 36749,
//    "order": "15"
//}