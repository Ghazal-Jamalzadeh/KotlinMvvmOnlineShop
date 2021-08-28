package com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Profile
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Api
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Repositry
import io.reactivex.disposables.CompositeDisposable

class ViewModel_Profile : ViewModel() {

    val mutable = MutableLiveData<List<DataModel_Profile>>()
    //val mutableData_order = MutableLiveData<List<Data_order>>()
    val Com = CompositeDisposable()
    fun getUser(id:String){
        Repositry.CustomResponse.request(Api.invoke().getUserInfo(id),Com){
            mutable.value=it
        }

//        Repositry.Customresponse.Requst(Api.invoke().Getlistorder(id),Com){
//            mutableData_order.value=it
//        }
    }

    override fun onCleared() {
        Com.clear()
        super.onCleared()
    }


}