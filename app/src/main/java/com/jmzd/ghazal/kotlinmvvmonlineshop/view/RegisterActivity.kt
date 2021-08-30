package com.jmzd.ghazal.kotlinmvvmonlineshop.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jmzd.ghazal.kotlinmvvmonlineshop.R
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ActivityRegisterBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.App
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.Facktory
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.Repository
import com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel.ViewModel_Register

class RegisterActivity : AppCompatActivity() {
    lateinit var bind: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_register)

        val viewmodel = ViewModelProvider(this, Facktory(App())).get(ViewModel_Register::class.java)
        bind.viewmodel=viewmodel
        viewmodel.mutable.observe(this, Observer {
            Log.d("test", it.status)
            if(it.status.equals("ok")){

                Repository.SharedPreferences.setSharedUser(this,it.user_id)

                val intent= Intent(applicationContext, ProfileActivity::class.java)
                startActivity(intent)

            }
            else
            {
Log.d("test" , "register error")
            }
        })
        bind.BtnReg.setOnClickListener {
            val intent= Intent(applicationContext,
                LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
