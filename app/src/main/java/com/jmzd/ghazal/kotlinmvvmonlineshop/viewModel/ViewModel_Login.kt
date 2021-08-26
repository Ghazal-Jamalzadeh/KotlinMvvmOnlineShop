package com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Status
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Api
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Repositry
import io.reactivex.disposables.CompositeDisposable

class ViewModel_Login : ViewModel() {

    var mobile :String?=null
    var pass :String?=null
    val mutable = MutableLiveData<DataModel_Status>()
    val Com = CompositeDisposable()
    fun getLogin(view: View){ // از طریق دیتا بایندینگ یک ویو میگیریم
        Repositry.CustomResponse.request(Api.invoke().getLogin(mobile!!,pass!!),Com){
            mutable.value=it
        }
    }

    override fun onCleared() {
        Com.clear()
        super.onCleared()
    }


}