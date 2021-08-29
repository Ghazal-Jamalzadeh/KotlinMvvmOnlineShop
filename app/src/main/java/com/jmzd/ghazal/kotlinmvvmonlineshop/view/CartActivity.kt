package com.jmzd.ghazal.kotlinmvvmonlineshop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jmzd.ghazal.kotlinmvvmonlineshop.R
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ActivityCartBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ActivityMainBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.App
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Facktory
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Repositry
import com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel.ViewModel_Cart

class CartActivity : AppCompatActivity() {
    lateinit var binding : ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user= Repositry.SharedPreferences.getSharedUser(this)
        val viewmodel = ViewModelProvider(this, Facktory(App())).get(ViewModel_Cart::class.java)

        getPrice(viewmodel,user)

//        Rel_price.setOnClickListener {
//            val intent=Intent(applicationContext,Activity_Address::class.java)
//            startActivity(intent)
//        }
//
//        viewmodel.mutablecart.observe(this, Observer { itcart->
//            recyclerview_shop.also {
//                it.layoutManager=LinearLayoutManager(this)
//                val adapter= Adapter_cart(this,itcart,object: Adapter_cart.Getchangeitems{
//                    override fun Getchange() {
//                        Getprice(viewmodel,user)
//                    }
//
//                },user)
//                it.adapter=adapter
//            }
//        })

    }

    fun getPrice(viewmodel:ViewModel_Cart,user:String){ // میشد viewModel را بالای کد به صورت lateinit تعریف کنیم و اینجا دسترسی داشته باشیم. . ولی به این شکل پاس دادیم. اینچور هم میشه.
        viewmodel.getPriceCart(user)
        viewmodel.mutable.observe(this, Observer {
            binding.TvPriceAll.text=it[0].price + " تومان  "
        })

    }
}
