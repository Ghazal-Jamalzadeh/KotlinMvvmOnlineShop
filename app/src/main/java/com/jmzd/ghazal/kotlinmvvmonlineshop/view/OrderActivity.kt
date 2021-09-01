package com.jmzd.ghazal.kotlinmvvmonlineshop.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmzd.ghazal.kotlinmvvmonlineshop.R
import com.jmzd.ghazal.kotlinmvvmonlineshop.adapter.PayAdapter
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ActivityMainBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ActivityOrderBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.App
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.Facktory
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.Repository
import com.jmzd.ghazal.kotlinmvvmonlineshop.utils.ClickItems
import com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel.ViewModel_Order

class OrderActivity : AppCompatActivity() {
    lateinit var binding : ActivityOrderBinding
    var link : String?=null
    var code : String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val address = intent.getStringExtra("address").toString()
        val user = Repository.SharedPreferences.getSharedUser(this)

        val viewmodel = ViewModelProvider(this, Facktory(App())).get(ViewModel_Order::class.java)

        viewmodel.addOrder(user,address)

        viewmodel.mutable.observe(this, Observer {
            binding.TvPriceAll.text=it.price + "تومان"
            code=it.code.toString()
        })
        viewmodel.mutablecart.observe(this, Observer { itviewmodel->  // list<DataModel_Pay>
            binding.recyclerviewShop.also {
                val Rgarray:IntArray=IntArray(itviewmodel.size)
                it.layoutManager = LinearLayoutManager(this)
                val adapter = PayAdapter(this,Rgarray,itviewmodel,object: ClickItems {
                    override fun Click(id: String) {
                        link=id
                    }

                })
                it.adapter = adapter
            }

        })

        binding.RelPrice.setOnClickListener {
            if(link.isNullOrEmpty()){
                Toast.makeText(applicationContext,"خطای ارتباط با درگاه پرداخت",Toast.LENGTH_LONG).show()
            }else
            {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.also {
                    it.data= Uri.parse(link+code)
                    startActivity(it)
                }
            }
        }
    }
}
