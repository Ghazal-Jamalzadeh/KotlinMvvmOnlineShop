package com.jmzd.ghazal.kotlinmvvmonlineshop.model

data class DataModel_Order(
  //  val authority: Any,  -> نیاز نداریم
 //   val code_pardakht: String, -> نیاز نداریم
    val id: String,
    val idaddress: String,
    val iduser: String,
    val price: String,
    val status: String
)
// برای ساخت این کلاس از kotlin data class file from json استفاده می کنیم. ولی فقط کپی کردن یکی ااز object ها کافی است. کل آرایه را کپی نمی کنیم. دو تا از فیلدها را هم نیاز نداریم پاک می کنیم.
//http://localhost/shop/list_order.php?user=7
//[
//    {
//        "id": "4",
//        "iduser": "7",
//        "idaddress": "5",
//        "price": "528000",
//        "status": "0",
//        "code_pardakht": "31631",
//        "authority": null
//    },
//    {
//        "id": "5",
//        "iduser": "7",
//        "idaddress": "6",
//        "price": "577000",
//        "status": "0",
//        "code_pardakht": "9339",
//        "authority": null
//    },
//    {
//        "id": "6",
//        "iduser": "7",
//        "idaddress": "6",
//        "price": "687000",
//        "status": "0",
//        "code_pardakht": "85092",
//        "authority": null
//    },
//    {
//        "id": "7",
//        "iduser": "7",
//        "idaddress": "6",
//        "price": "776000",
//        "status": "0",
//        "code_pardakht": "79632",
//        "authority": null
//    },
//    {
//        "id": "8",
//        "iduser": "7",
//        "idaddress": "5",
//        "price": "865000",
//        "status": "0",
//        "code_pardakht": "41929",
//        "authority": null
//    }
//]