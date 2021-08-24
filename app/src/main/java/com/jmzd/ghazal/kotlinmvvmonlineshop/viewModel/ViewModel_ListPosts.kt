package com.jmzd.ghazal.kotlinmvvmonlineshop.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jmzd.ghazal.kotlinmvvmonlineshop.model.DataModel_PostItem
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Api
import com.jmzd.ghazal.kotlinmvvmonlineshop.repositry.Repositry
import io.reactivex.disposables.CompositeDisposable

class ViewModel_ListPosts : ViewModel() {
    val mutable = MutableLiveData<List<DataModel_PostItem>>()
    val Com = CompositeDisposable()
    fun Getlist() { // طبیعتا باید یک api به آن پاس بدهیم که از طریق invoke ببه متد دیگر هم دسترسی داریم. یک CompositeDisposable و یک متد که به این شکل نوشته می شود و همان طور که مشاده می شود هر چیزی را پاس بدیم داده از همان نوع را بر می گرداند چون T  بود. مثلا اگر GetLogin را به عنوان api پاس میادادیم به این متد خروجی تبدیل به String میشد. این بسیار کار ما را راحت کرده و نیازی نیست که برای خروجی های متفاوت متدهای گوناگون بنویسیم و تمام کار ما با همین یک متد راه می افند با هر نوع داده ای.
        Repositry.CustomResponse.request(Api.invoke().Getlist(), Com) {
            mutable.value = it
        }
    }

    override fun onCleared() {
        Com.clear() // اگر این را نداشته باشیم ریکوئست به صورت مرتب به سمت سرور فرستاده می شود.
        super.onCleared()
    }
}
