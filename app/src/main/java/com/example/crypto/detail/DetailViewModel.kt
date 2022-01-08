package com.example.crypto.detail

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.crypto.network.Retrofit


class DetailViewModel(context: Context) : ViewModel() {
    private val cryptoRepository = Retrofit.createRepository(context = context)
}