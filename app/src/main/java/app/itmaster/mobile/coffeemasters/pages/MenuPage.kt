package app.itmaster.mobile.coffeemasters.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.itmaster.mobile.coffeemasters.data.DataManager

@Composable
fun MenuPage(dataManager: DataManager) {
    Text(if (dataManager.menu.size > 0) dataManager.menu[0].name else "⏳",
        modifier = Modifier.padding(70.dp))
}