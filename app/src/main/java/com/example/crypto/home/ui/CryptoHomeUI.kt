package com.example.crypto.home.ui

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.crypto.home.ui.components.CryptoCard

@Composable
fun CryptoHomeUI() {
    LazyRow{
        items(5){ lazyItemScope ->
            CryptoCard()
        }
    }
}


@Preview
@Composable
fun CryptoHomeUIPreview() {
    CryptoHomeUI()
}
