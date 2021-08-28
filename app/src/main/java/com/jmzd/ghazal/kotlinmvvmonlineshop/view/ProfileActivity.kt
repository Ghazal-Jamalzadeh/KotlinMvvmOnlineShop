package com.jmzd.ghazal.kotlinmvvmonlineshop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmzd.ghazal.kotlinmvvmonlineshop.R
import com.jmzd.ghazal.kotlinmvvmonlineshop.adapter.UserOrderHistoryAdapter
import com.jmzd.ghazal.kotlinmvvmonlineshop.databinding.ActivityProfileBinding
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Profile
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.App
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Facktory
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Repositry
import com.jmzd.ghazal.kotlinmvvmonlineshop.utils.ClickItems
import com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel.ViewModel_Profile
// به جای فرستادن دو تا ریکوئست می توانستیم مثل بخش اسلایدر یک php بنوسیم که در یک ریکوئست همه اطلاعات مورد نیاز ما را بفرستد.
class ProfileActivity : AppCompatActivity() , ClickItems{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val bind : ActivityProfileBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile)

        val viewmodel = ViewModelProvider(this, Facktory(App())).get(ViewModel_Profile::class.java)

        val userId= Repositry.SharedPreferences.getSharedUser(this)


        viewmodel.getUser(userId)

        viewmodel.mutable.observe(this, Observer {
            val profile= DataModel_Profile(it[0].name,it[0].mobile,it[0].email)
            bind.data=profile
        })

        viewmodel.mutableDataOrder.observe(this, Observer { itorder -> // پیش فرض  it: list<DataModel_order> // احتمالا صرفا اسم را تغییر دادیم چونکه بلاک also هم it دارد
            bind.recyclerview.also {
                it.layoutManager= LinearLayoutManager(this)
                val adapter= UserOrderHistoryAdapter(itorder,this)
                it.adapter=adapter
            }
        })
    }

    override fun Click(id: String) {
        // تعریف عملیات دلخواه هنگام کلیک شدن روی ریسایکلر ویو
    }
}