package com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_AddOrder
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Pay
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.Api
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.Repository
import io.reactivex.disposables.CompositeDisposable

class ViewModel_Order : ViewModel() {
    val mutable = MutableLiveData<DataModel_AddOrder>()
    val mutablecart = MutableLiveData<List<DataModel_Pay>>()
    val Com = CompositeDisposable()

    fun addOrder(user:String,address:String){
        Repository.CustomResponse.request(Api.invoke().addOrder(user,address),Com){
            mutable.value=it
        }

        Repository.CustomResponse.request(Api.invoke().getPay(),Com){
            mutablecart.value=it
        }

    }



}