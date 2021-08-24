package com.jmzd.ghazal.kotlinmvvmonlineshop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmzd.ghazal.kotlinmvvmonlineshop.R
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ActivityMainBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_PostItem
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.App
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Facktory
import com.jmzd.ghazal.kotlinmvvmonlineshop.view.adapter.RecyclerViewAdapter
import com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel.ViewModel_ListPosts

class MainActivity : AppCompatActivity() {
   lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //برای پیاده سازی viewModel Providers  روش قبلی که در java mvvm پیاده سازی کردیم منسوخ شده. برای استفاده از این روش جدید کارهای زیر را انجام میدهیم و کلاس هاس زیر را می سازیم. که اصولی است. در دوره دیجی کالا همین مفهوم به یک روش دیگر پیاده سازی شده که هر دو درست و اصولی هستند و منطق یکسانی  دارند.
        //factory -> app -> manifest
        //نکته ۲ : کتابخانه android x life cycle برای استفاده از viewModel است.
        //نکته ۳ : در پیاده سازی mvvm نباید بین اکتیویتی و فرگمنت تفاوتی قائل شویم.
        val viewmodel: ViewModel_ListPosts = ViewModelProvider(this, Facktory(App())).get(ViewModel_ListPosts::class.java)
        viewmodel.Getlist()
        viewmodel.mutable.observe(this, Observer {
            Log.d("MainActivity: " , it.toString() )
            setupRecyclerview(it)
        })
    }
    fun setupRecyclerview(list:List<DataModel_PostItem>){
        //به جای اینکه هر بار recyclerView را برای فراخوانی هر متد فراخوانی کنیم از بلاک also استفاده می کنیم. و با it  به آن دسترسی خواهیم داشت.
        binding.recyclerviewShop.also {
            it.layoutManager= LinearLayoutManager(this)
            val adapter = RecyclerViewAdapter(list)//,this
            it.adapter=adapter
        }
    }

}

//Duplicate class android.support.v4.app.INotificationSideChannel found in modules classes?
//https://stackoverflow.com/questions/55909804/duplicate-class-android-support-v4-app-inotificationsidechannel-found-in-modules/56815162