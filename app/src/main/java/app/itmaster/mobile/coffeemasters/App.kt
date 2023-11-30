package app.itmaster.mobile.coffeemasters

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.itmaster.mobile.coffeemasters.data.Offer
import app.itmaster.mobile.coffeemasters.pages.OffersPage

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun App() {
    var currentPage = remember { mutableStateOf("menu") }
    Scaffold(
        topBar = { TopAppBar(title = {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()) {
                Text("Coffee Master")
            }
        }) },
        content = {
            Box(modifier = Modifier.padding(bottom = BottomBarUI.marginBottom)) {
                OffersPage()
            }
        },
        bottomBar = {
            NavBar(currentPage.value, onRouteChange = {
                currentPage.value = it
            })
        }
    )
}