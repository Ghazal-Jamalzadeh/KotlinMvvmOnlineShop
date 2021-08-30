package com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Address
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.Api
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.Repository
import io.reactivex.disposables.CompositeDisposable

class ViewModel_Address  : ViewModel() {
    val mutable = MutableLiveData<List<DataModel_Address>>()
    val Com = CompositeDisposable()
    fun getList( user:String){
        Repository.CustomResponse.request(Api.invoke().getAddress(user),Com){
            mutable.value=it
        }
    }

    override fun onCleared() {
        Com.clear()
        super.onCleared()
    }

}