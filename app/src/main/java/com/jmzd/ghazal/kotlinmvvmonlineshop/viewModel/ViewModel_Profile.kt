package com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Order
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Profile
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Api
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Repositry
import io.reactivex.disposables.CompositeDisposable

class ViewModel_Profile : ViewModel() {

    val mutable = MutableLiveData<List<DataModel_Profile>>()
    val mutableDataOrder = MutableLiveData<List<DataModel_Order>>()
    val Com = CompositeDisposable()
    fun getUser(id:String){
        Repositry.CustomResponse.request(Api.invoke().getUserInfo(id),Com){
            mutable.value=it
        }

        Repositry.CustomResponse.request(Api.invoke().getListOrder(id),Com){
            mutableDataOrder.value=it
        }
    }

    override fun onCleared() {
        Com.clear()
        super.onCleared()
    }


}