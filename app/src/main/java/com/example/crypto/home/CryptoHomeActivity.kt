package com.example.crypto.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.crypto.home.ui.components.CryptoCard
import com.example.crypto.home.ui.theme.CryptoTheme

class CryptoHomeActivity : ComponentActivity() {

    private lateinit var viewModel: CryptoHomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoTheme {
                val viewModelFactory = CryptoHomeViewModelFactory(context = LocalContext.current)
                viewModel = ViewModelProvider(this, viewModelFactory)
                    .get(CryptoHomeViewModel::class.java)

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    Greeting2("Android")
                    CryptoCard()
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    CryptoTheme {
        Greeting2("Android")
    }
}