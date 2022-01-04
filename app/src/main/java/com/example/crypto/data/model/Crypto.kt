package com.example.crypto.data.model

import java.io.Serializable

data class Crypto(
    val symbol: String,
    val price: Double,
    val name: String,
    val image: String,
    val dailyChange: Double,
    val dailyChangePercentage: Double,
    val high: Double,
    val low: Double,
    val marketCap: Long,
    val volume: Double,
    val supply: Double?,
    val chartData: List<Float>
) : Serializable