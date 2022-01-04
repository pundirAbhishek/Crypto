package com.example.crypto.home

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CryptoHomeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CryptoHomeViewModel::class.java)) {
            return CryptoHomeViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}