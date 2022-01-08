package com.example.crypto.detail

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
import com.example.crypto.detail.ui.theme.CryptoTheme
import com.example.crypto.home.CryptoHomeViewModel
import com.example.crypto.home.CryptoHomeViewModelFactory

class DetailActivity : ComponentActivity() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoTheme {
                val viewModelFactory = DetailViewModelFactory(context = LocalContext.current)
                viewModel = ViewModelProvider(this, viewModelFactory)
                    .get(DetailViewModel::class.java)
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting3("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    CryptoTheme {
        Greeting3("Android")
    }
}