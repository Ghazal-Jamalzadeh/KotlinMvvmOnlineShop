package com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_Details
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.Api
import com.jmzd.ghazal.kotlinmvvmonlineshop.repository.Repository
import io.reactivex.disposables.CompositeDisposable

class ViewModel_Details : ViewModel() {

    val mutable = MutableLiveData<DataModel_Details>()
    val Com = CompositeDisposable()
    fun Getlist(id:String){
        Repository.CustomResponse.request(Api.invoke().getDetails(id),Com){
            mutable.value=it
        }
    }

    override fun onCleared() {
        Com.clear()
        super.onCleared()
    }


}