package app.itmaster.mobile.coffeemasters

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.itmaster.mobile.coffeemasters.data.API
import app.itmaster.mobile.coffeemasters.data.Category
import app.itmaster.mobile.coffeemasters.data.DataManager
import app.itmaster.mobile.coffeemasters.data.Offer
import app.itmaster.mobile.coffeemasters.pages.InfoPage
import app.itmaster.mobile.coffeemasters.pages.MenuPage
import app.itmaster.mobile.coffeemasters.pages.OffersPage
import app.itmaster.mobile.coffeemasters.pages.OrderPage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(dataManager: DataManager) {
    var currentPage = remember { mutableStateOf("menu") }

    Scaffold(
        topBar = {
               TopAppBar(
                        title = {
                            Box(contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxWidth()) {
                                Image(painter = painterResource(id = R.drawable.logo),
                                    contentDescription = "Coffee Masters")
                                }
                        },
                   colors = TopAppBarDefaults.smallTopAppBarColors(
                       containerColor = MaterialTheme.colorScheme.primary
                   )
               )},
        content = {
            Box(modifier = Modifier.padding(bottom = BottomBarUI.marginBottom,
                top = 80.dp)) {
                when (currentPage.value) {
                    "menu" -> MenuPage(dataManager)
                    "offers" -> OffersPage()
                    "order" -> OrderPage(dataManager)
                    "info" -> InfoPage()
                }
            }
        },
        bottomBar = {
            NavBar(currentPage.value, onRouteChange = {
                currentPage.value = it
            })
        }
    )
}