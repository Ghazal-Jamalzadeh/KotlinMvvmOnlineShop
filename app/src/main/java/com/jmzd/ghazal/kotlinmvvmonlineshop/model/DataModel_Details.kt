package com.jmzd.ghazal.kotlinmvvmonlineshop.model

data class DataModel_Details(
    val post: List<Post>,
    val slider: List<Slider>
)

data class Post(
    val date: String,
    val des: String,
    val id: String,
    val imageurl: String,
    val price: String,
    val title: String,
    val view: String
)

data class Slider(
    val image: String
)



// خروجی یک object است حاوی دو آرایه :
//{
//    "slider": [
//        {
//            "image": "https:\/\/noorsanbeauty.com\/images\/WhatsApp%20Image%202021-02-13%20at%2022.35.12new.jpg"
//        },
//        {
//            "image": "https:\/\/noorsanbeauty.com\/images\/rozadoslidernewest.jpg"
//        },
//        {
//            "image": "https:\/\/noorsanbeauty.com\/images\/product\/Suntis-095155995789_Watermark-Text.jpg"
//        }
//    ],
//    "post": [
//        {
//            "id": "2",
//            "title": "پنکک ناتالی ",
//            "imageurl": "https:\/\/noorsanbeauty.com\/images\/product\/panNathelie1%20(3).jpg",
//            "date": "2021 jun ",
//            "view": "20",
//            "des": "پنکیک ناتالی یک پنکک ابریشمی است که احساس سبکی برای پوست شما ایجاد می کند. پنکک ناتالی از ایجاد چربی بر روی پوست جلوگیری کرده و از جوش زدن پوست شما پیشگیری می کند. حتی خانم هایی که پوست فوق العاده حساسی دارند و با داشتن پوستی خشک جوش زیر پوستی می زنند بعد از استفاده از پنکک ناتالی احساس صددرصد رضایت دارند.\r\n\r\n",
//            "price": "90000"
//        }
//    ]
//}