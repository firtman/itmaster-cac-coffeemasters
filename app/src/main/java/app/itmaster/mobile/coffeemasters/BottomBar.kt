package app.itmaster.mobile.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.itmaster.mobile.coffeemasters.ui.theme.Alternative1
import app.itmaster.mobile.coffeemasters.ui.theme.Alternative2
import app.itmaster.mobile.coffeemasters.ui.theme.Primary

data class NavPage(var route: String, var title: String, var icon: ImageVector)

object Pages {
    val menuPage = NavPage("menu", "Menu", Icons.Outlined.Menu)
    val all = listOf(
        menuPage,
        NavPage("offers", "Offers", Icons.Outlined.Star),
        NavPage("order", "My Order", Icons.Outlined.ShoppingCart),
        NavPage("info", "Info", Icons.Outlined.Info),
    )
}


@Composable
fun NavBar(selectedRoute: String = Pages.all[0].route,
           onRouteChange: (String)->Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(4.dp)
    ) {
        for (page in Pages.all) {
            NavBarItem(page,
                page.route==selectedRoute,
                modifier = Modifier
                    .clickable {
                        println("Clickeaste en ${page.route}")
                        onRouteChange(page.route)
                    }
            )
        }

    }
}

@Composable
fun NavBarItem(page: NavPage, selected: Boolean = false,
               modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(8.dp)
    ) {

        val color = if (selected)
            Alternative2
            else MaterialTheme.colorScheme.onPrimary

        Image(page.icon,
            colorFilter = ColorFilter.tint(color),
            contentDescription = page.title,
            modifier = Modifier
                .padding(8.dp)
                .size(24.dp)
        )
        Text(page.title,
            fontSize = 12.sp,
            color = color)
    }
}




