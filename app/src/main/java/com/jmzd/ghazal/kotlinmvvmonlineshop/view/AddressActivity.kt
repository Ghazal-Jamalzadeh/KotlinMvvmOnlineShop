package com.jmzd.ghazal.kotlinmvvmonlineshop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmzd.ghazal.kotlinmvvmonlineshop.R
import com.jmzd.ghazal.kotlinmvvmonlineshop.adapter.AddressAdapter
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ActivityAddressBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ActivityMainBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ItemsAddressBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.App
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.Facktory
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.Repository
import com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel.ViewModel_Address

class AddressActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddressBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = Repository.SharedPreferences.getSharedUser(this)

        val viewmodel = ViewModelProvider(this, Facktory(App())).get(ViewModel_Address::class.java)
        viewmodel.getList(user)

        viewmodel.mutable.observe(this, Observer {itviewmodel->
            binding.recyclerviewAddress.also {
                it.layoutManager = LinearLayoutManager(this)
                val adapter = AddressAdapter(itviewmodel,object: AddressAdapter.Clickaddress{
                    override fun addressid(id: String) {

                    }
                })
                it.adapter = adapter
            }
        })
    }

}

