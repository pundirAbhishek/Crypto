package com.example.crypto.data.repository

import com.example.crypto.data.model.Crypto

interface CryptoRepository {
    suspend fun getPageCrypto(page: Int, pageSize: Int) : List<Crypto>
}