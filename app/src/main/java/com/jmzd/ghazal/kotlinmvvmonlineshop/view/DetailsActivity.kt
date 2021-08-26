package com.jmzd.ghazal.kotlinmvvmonlineshop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jmzd.ghazal.kotlinmvvmonlineshop.R
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ActivityDetailsBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.Post
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.Slider
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.App
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Facktory
import com.jmzd.ghazal.kotlinmvvmonlineshop.adapter.SliderViewPagerAdapter
import com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel.ViewModel_Details

class DetailsActivity : AppCompatActivity() {
    lateinit var bind: ActivityDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

//        bind = ActivityDetailsBinding.inflate(layoutInflater)
//        setContentView(bind.root)

        val intentntpostid=intent

        bind = DataBindingUtil.setContentView(this,R.layout.activity_details)

        val viewmodel = ViewModelProvider(this, Facktory(App())).get(ViewModel_Details::class.java)
        viewmodel.Getlist(intentntpostid.getStringExtra("id").toString())
        viewmodel.mutable.observe(this, Observer {
            val post= Post(it.post[0].date,it.post[0].des,it.post[0].id
                ,it.post[0].imageurl,it.post[0].price,it.post[0].title,it.post[0].view)  // مقداردهی دیتامدل با داد ای که از api گرفتیم. شامل datamodel_details که شامل پارامترهای هر دو آرایه هست.
            bind.data=post
            bind.BtnCartadd.text=" افزودن به سبد خرید "+post.price+" تومان "
            Viewpager(it.slider)
        })
    }

    fun Viewpager(list:List<Slider>){
        val adapter = SliderViewPagerAdapter(list)
        bind.viewpagerSlider.adapter=adapter
        bind.viewpagerSlider.pageMargin=25
        bind.viewpagerSlider.setPadding(45,0,15,0)
        bind.viewpagerSlider.currentItem=1

    }
}
