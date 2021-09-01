package com.jmzd.ghazal.kotlinmvvmonlineshop.model

data class DataModel_Pay(
    val id: String,
    val image: String,
    val link: String,
    val title: String
)


//http://localhost/shop/pay.php
//[
//    {
//        "id": "1",
//        "title": "درگاه زرین پال ",
//        "image": "https:\/\/www.zarinpal.com\/lab\/wp-content\/uploads\/sites\/2\/2016\/05\/icon-128x128.png",
//        "link": "https:\/\/www.zarinpal.com\/"
//    },
//    {
//        "id": "2",
//        "title": "درگاه سامان کیش ",
//        "image": "https:\/\/www.sep.ir\/Images\/logo-fa.png",
//        "link": "https:\/\/pay.ir\/"
//    }
//]