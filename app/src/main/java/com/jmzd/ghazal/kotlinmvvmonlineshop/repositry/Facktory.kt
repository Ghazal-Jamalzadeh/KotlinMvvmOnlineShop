package com.jmzd.ghazal.kotlinmvvmonlineshop.repositry

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Facktory(app: Application)  : ViewModelProvider.AndroidViewModelFactory(app){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return super.create(modelClass)
    }
}