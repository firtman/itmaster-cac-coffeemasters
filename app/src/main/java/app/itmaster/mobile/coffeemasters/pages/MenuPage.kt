package app.itmaster.mobile.coffeemasters.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.itmaster.mobile.coffeemasters.data.DataManager
import app.itmaster.mobile.coffeemasters.data.Product
import app.itmaster.mobile.coffeemasters.ui.theme.Alternative1
import coil.compose.AsyncImage

fun Double.toDecimalString() = "%.2f".format(this)

@Composable
fun MenuPage(dataManager: DataManager) {
    Box {
        if (dataManager.menu.size > 0) {
            // Tengo menú

            LazyColumn {
                items(dataManager.menu) { category ->
                    Text(category.name,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(10.dp, 20.dp, 10.dp, 10.dp))
                    category.products.forEach {
                        ProductItem(it) {
                            // Cuando un producto se agregue
                            println("Se agrega el producto ${it.name}")
                            dataManager.cartAdd(it)
                        }
                    }
                }
            }
        } else {
            // No tenemos menú disponible
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.secondary,

            )
        }

    }

}

@Composable
fun ProductItem(product: Product, onAdd: (Product)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        AsyncImage(
            model = product.imageUrl,
            contentDescription = "Image for ${product.name}",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(product.name, fontWeight = FontWeight.Bold)
                Text("$${product.price.toDecimalString()} ea")
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Alternative1,
                    contentColor = Color.White
                ),
                onClick = {
                    onAdd(product)
                },
            ) {
                Text("Add")
            }
        }
    }
}