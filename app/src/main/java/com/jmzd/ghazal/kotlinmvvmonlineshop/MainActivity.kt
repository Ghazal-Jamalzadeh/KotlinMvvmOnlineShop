package com.jmzd.ghazal.kotlinmvvmonlineshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.App
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Facktory
import com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel.ViewModel_ListPosts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //برای پیاده سازی viewModel Providers  روش قبلی که در java mvvm پیاده سازی کردیم منسوخ شده. برای استفاده از این روش جدید کارهای زیر را انجام میدهیم و کلاس هاس زیر را می سازیم. که اصولی است. در دوره دیجی کالا همین مفهوم به یک روش دیگر پیاده سازی شده که هر دو درست و اصولی هستند و منطق یکسانی  دارند.
        //factory -> app -> manifest
        //نکته ۲ : کتابخانه android x life cycle برای استفاده از viewModel است.
        //نکته ۳ : در پیاده سازی mvvm نباید بین اکتیویتی و فرگمنت تفاوتی قائل شویم.
        val viewmodel: ViewModel_ListPosts = ViewModelProvider(this, Facktory(App())).get(ViewModel_ListPosts::class.java)
        viewmodel.Getlist()
        viewmodel.mutable.observe(this, Observer {
            Log.d("MainActivity: " , it.toString() )
           // Setup_Recyclerview(it)
        })
    }


}

//Duplicate class android.support.v4.app.INotificationSideChannel found in modules classes?
//https://stackoverflow.com/questions/55909804/duplicate-class-android-support-v4-app-inotificationsidechannel-found-in-modules/56815162