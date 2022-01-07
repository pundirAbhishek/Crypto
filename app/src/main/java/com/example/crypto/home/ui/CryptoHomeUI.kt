package com.example.crypto.home.ui

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.crypto.home.ui.components.CryptoCard
import com.example.crypto.snapper.ExperimentalSnapperApi
import com.example.crypto.snapper.rememberSnapperFlingBehavior

@ExperimentalSnapperApi
@Composable
fun CryptoHomeUI() {
    val lazyListState = rememberLazyListState()
    LazyRow(
        state = lazyListState,
        flingBehavior = rememberSnapperFlingBehavior(lazyListState = lazyListState)
    ) {
        items(5) {
            CryptoCard()
        }
    }
}


@ExperimentalSnapperApi
@Preview
@Composable
fun CryptoHomeUIPreview() {
    CryptoHomeUI()
}
