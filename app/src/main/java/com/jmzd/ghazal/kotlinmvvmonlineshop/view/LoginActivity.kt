package com.jmzd.ghazal.kotlinmvvmonlineshop.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jmzd.ghazal.kotlinmvvmonlineshop.R
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ActivityLoginBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.App
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Facktory
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Repositry
import com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel.ViewModel_Login

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val bind : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        val viewmodel = ViewModelProvider(this, Facktory(App())).get(ViewModel_Login::class.java)
        bind.viewmodel=viewmodel
        viewmodel.mutable.observe(this, Observer {
            Log.d("test", it.status) //test: error // test: ok

            if(it.status.equals("ok")){
//                Repositry.Sharedprofermance.SetSharduser(this,it.user_id)

                val intent= Intent(applicationContext, ProfileActivity::class.java)
                startActivity(intent)

            }
            else
            {

            }
        })
//        Btn_reg.setOnClickListener {
//            val intent=Intent(applicationContext,
//                Regsiter::class.java)
//            startActivity(intent)
//        }
    }


}
