package com.jmzd.ghazal.kotlinmvvmonlineshop.repositry

import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_PostItem
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface Api {

    @GET("index.php")
    fun Getlist(): Single<List<DataModel_PostItem>> // چون آرایه است چیزی که برمیگردئ لیست می خواهیم. اگر فقط یک object{}  بود لازم نبود لیست باشد و فقط یک<DataModel_PostItem> کافی بود.

    // example :
//    @GET("login.php")
//    fun Getlogin(): Single<String>

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