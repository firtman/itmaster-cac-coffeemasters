package app.itmaster.mobile.coffeemasters.pages

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import app.itmaster.mobile.coffeemasters.data.DataManager

@Composable
fun OrderPage(dataManager: DataManager) {
    LazyColumn {
        items(dataManager.cart) {
            Text("${it.quantity}x ${it.product.name}")
        }
    }
}