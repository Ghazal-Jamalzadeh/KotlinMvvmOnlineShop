package com.jmzd.ghazal.kotlinmvvmonlineshop.repository

import com.jmzd.ghazal.kotlinmvvmonlineshop.model.*
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("index.php")
    fun getList(): Single<List<DataModel_PostItem>> // چون آرایه است چیزی که برمیگردئ لیست می خواهیم. اگر فقط یک object{}  بود لازم نبود لیست باشد و فقط یک<DataModel_PostItem> کافی بود.

    @FormUrlEncoded
    @POST("slider.php") //http://localhost/shop/slider.php?id=2
    fun getDetails(@Field("id")id:String):Single<DataModel_Details>

    @FormUrlEncoded
    @POST("login.php")
    fun getLogin(@Field("mobile")mobile:String,@Field("pass")pass:String):Single<DataModel_Status>

    @FormUrlEncoded
    @POST("reg.php")
    fun getReg(@Field("name")name:String,@Field("mobile")mobile:String,@Field("email")email:String,@Field("pass")pass:String):Single<DataModel_Status>

    @FormUrlEncoded
    @POST("User_info.php")
    fun getUserInfo(@Field("user_id")user_id:String):Single<List<DataModel_Profile>>

    @FormUrlEncoded
    @POST("list_order.php")
    fun getListOrder(@Field("user")id:String):Single<List<DataModel_Order>> // تاریخچه سفارشات کاربر

    @FormUrlEncoded
    @POST("Get_pricecart.php")
    fun getPriceCount(@Field("user")id:String):Single<List<DataModel_Price>> // مجموع قیمت سبد خرید کاربر

    @FormUrlEncoded
    @POST("Get_record_cart.php")
    fun getCart(@Field("user")id:String):Single<List<DataModel_Cart>> // سبد خرید کاربر را بر می گرداند

    @FormUrlEncoded
    @POST("Addcart.php")
    fun addCart(@Field("product")idproduct:String,@Field("count")count:String,@Field("user")user:String,@Field("check")check:String):Single<DataModel_AddCart> // اضافه کردن آیتم به سبد خرید یا کم کردن

    @FormUrlEncoded
    @POST("Get_address.php")
    fun getAddress(@Field("user")id:String):Single<List<DataModel_Address>>


    companion object{ // در مثال java mvvm این قسمت را در webService پیاده سازی کردیم. این روش بهتری است و در آن از invoke استفاده شده است.
        operator fun invoke():Api{
            return Retrofit.Builder()
                .baseUrl("http://192.168.1.104/shop/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)
        }
    }

}

//Kotlin's invoke operator
//An interesting feature of the Kotlin language is the ability to define an "invoke operator". When you specify an invoke operator on a class, it can be called on any instances of the class without a method name!
//This trick seems especially useful for classes that really only have one method to be used.
// more -> http://joshskeen.com/kotlins-invoke-operator/
//By using this, you can "call" your object as if it's a function.




// example :
//    @GET("login.php")
//    fun Getlogin(): Single<String>