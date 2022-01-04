package com.example.crypto.data.repository

import com.example.crypto.data.api.CryptoApi
import com.example.crypto.data.api.CryptoApiMapper
import com.example.crypto.data.model.Crypto

// TODO : Implement Dependency Injection

class CryptoRepositoryImpl(
    private val cryptoApi: CryptoApi,
    private val cryptoApiMapper: CryptoApiMapper
) : CryptoRepository {

    override suspend fun getPageCrypto(page: Int, pageSize: Int): List<Crypto> {
        val apiResponse = cryptoApi.getAllCrypto(page = page, pageSize = pageSize)

        return if (apiResponse.isSuccessful && !apiResponse.body().isNullOrEmpty()) {
            val cryptoApiResponseList = apiResponse.body()
            val cryptoList = cryptoApiResponseList?.map { cryptoApiResponse ->
                cryptoApiMapper.map(cryptoApiResponse)
            }
            cryptoList ?: emptyList()
        } else {
            emptyList()
        }
    }
}