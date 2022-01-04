package com.example.crypto.home

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.crypto.network.Retrofit

class CryptoHomeViewModel(context: Context) : ViewModel() {
    private val cryptoRepository = Retrofit.createRepository(context = context)
}
