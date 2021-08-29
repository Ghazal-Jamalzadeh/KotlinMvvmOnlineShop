package com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Cart
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Price
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Api
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Repositry
import io.reactivex.disposables.CompositeDisposable

class ViewModel_Cart : ViewModel() {
    val mutable = MutableLiveData<List<DataModel_Price>>()
    val mutablecart = MutableLiveData<List<DataModel_Cart>>()

    val Com = CompositeDisposable()

    fun getPriceCart(user:String){
        Repositry.CustomResponse.request(Api.invoke().getPriceCount(user),Com){
            mutable.value=it
        }

        Repositry.CustomResponse.request(Api.invoke().getCart(user),Com){
            mutablecart.value=it
        }

    }



}