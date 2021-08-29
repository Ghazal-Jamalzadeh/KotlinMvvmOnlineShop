package com.jmzd.ghazal.kotlinmvvmonlineshop.model

data class DataModel_Cart(
    val count: String,
    val date: String,
    val des: String,
    val id: String,
    val idproduct: String,
    val iduser: String,
    val imageurl: String,
    val price: String,
    val title: String,
    val view: String
)
// فقط با استفاده از یکی از objectها ساختیم این کلاس را
//http://localhost/shop/get_record_cart.php?user=9
//[
//    {
//        "id": "10",
//        "title": "ریمل جدید ",
//        "imageurl": "https:\/\/noorsanbeauty.com\/images\/product\/essence440886.jpg",
//        "date": "2021 jun ",
//        "view": "1000",
//        "des": "ریمل عالی و با کیفیت ",
//        "price": "50",
//        "iduser": "9",
//        "idproduct": "6",
//        "count": "10"
//    },
//    {
//        "id": "11",
//        "title": "ریمل ۲ ",
//        "imageurl": "https:\/\/noorsanbeauty.com\/images\/product\/essence440886.jpg",
//        "date": "2020",
//        "view": "20",
//        "des": "بی کیفیت ",
//        "price": "10",
//        "iduser": "9",
//        "idproduct": "7",
//        "count": "1"
//    }
//]