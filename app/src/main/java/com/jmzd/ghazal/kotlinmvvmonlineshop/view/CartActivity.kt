package com.jmzd.ghazal.kotlinmvvmonlineshop.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmzd.ghazal.kotlinmvvmonlineshop.adapter.CartAdapter
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ActivityCartBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.App
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.Facktory
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.Repository
import com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel.ViewModel_Cart

class CartActivity : AppCompatActivity() {
    lateinit var binding: ActivityCartBinding
    var bChange : Boolean = false
    var cartEmpty : Boolean= false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = Repository.SharedPreferences.getSharedUser(this)
        val viewmodel = ViewModelProvider(this, Facktory(App())).get(ViewModel_Cart::class.java)

        getPrice(viewmodel, user)

        binding.RelPrice.setOnClickListener {
            if(cartEmpty==false){
                val intent=Intent(applicationContext,AddressActivity::class.java)
                startActivity(intent)
            }
            else{
                finish()
                val intent=Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
            }
        }

        viewmodel.mutablecart.observe(this, Observer { itcart -> // Default: it: List<DataModel_Cart>
                binding.recyclerviewShop.also {
                    it.layoutManager = LinearLayoutManager(this)
                    val arraylistCart=ArrayList(itcart)
                    val adapter = CartAdapter(this, arraylistCart , object : CartAdapter.GetChangeItems {
                        override fun getChange(p:Int) {
                            if(p==1){
                                bChange=true
                            }
                            getPrice(viewmodel,user)// بعد از حذف یا اضافه شدن یک آیتم قیمت  کل مجددا بارگذاری می شود.
                        }
                    }, user)
                    it.adapter = adapter
                }
            })

    }

    fun getPrice(viewmodel: ViewModel_Cart, user: String) { // میشد viewModel را بالای کد به صورت lateinit تعریف کنیم و اینجا دسترسی داشته باشیم. . ولی به این شکل پاس دادیم. اینچور هم میشه.
        viewmodel.getPriceCart(user)
        viewmodel.mutable.observe(this, Observer {

            if(it[0].price.isNullOrEmpty()|| it[0].price==null ) {
                binding.rel.visibility = View.GONE
                binding.tvChange.text = "محصولی موجود نیست-افزودن محصول"
                cartEmpty = true
            }else{
                binding.TvPriceAll.text = it[0].price + " تومان  "
            }
        })
        if(bChange==true){
//            binding.rel.visibility= View.GONE
//            binding.tvChange.text="محصولی موجود نیست-افزودن محصول"
        }

    }
}
