package com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Status
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Api
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Repositry
import io.reactivex.disposables.CompositeDisposable

class ViewModel_Register : ViewModel() {

    var mobile :String?=null
    var name :String?=null
    var email :String?=null
    var pass :String?=null
    val mutable = MutableLiveData<DataModel_Status>()
    val Com = CompositeDisposable()
    fun getReg(view: View){
        Repositry.CustomResponse.request(Api.invoke().getReg(name!!,mobile!!,email!!,pass!!),Com){
            mutable.value=it
        }
    }

    override fun onCleared() {
        Com.clear()
        super.onCleared()
    }


}