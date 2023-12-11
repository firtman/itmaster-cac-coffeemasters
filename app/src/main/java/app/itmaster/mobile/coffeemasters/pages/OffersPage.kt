package app.itmaster.mobile.coffeemasters.pages

import android.widget.ListView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.itmaster.mobile.coffeemasters.R
import app.itmaster.mobile.coffeemasters.data.Offer
import app.itmaster.mobile.coffeemasters.data.currentOffers
import app.itmaster.mobile.coffeemasters.ui.theme.Alternative2
import app.itmaster.mobile.coffeemasters.ui.theme.CoffeeMastersTheme


@Preview(showBackground = true)
@Composable
fun OffersPage() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        for (offer in currentOffers) {
            OfferView(offer)
        }
    }
}

@Composable
fun OfferView(offer: Offer) {
    Box(modifier =
    Modifier
        .padding(16.dp)
        .background(MaterialTheme.colorScheme.surface)
        .clip(RoundedCornerShape(4.dp))
    ) {
        Image(painter = painterResource(id = R.drawable.background_pattern),
            contentDescription = "Background pattern",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.matchParentSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = offer.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(8.dp)

            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = offer.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,

                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(8.dp)
                )
        }
    }
}

@Preview(showBackground = true, widthDp = 380)
@Composable
private fun OfferView_Preview() {
    CoffeeMastersTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            OfferView(offer = Offer(1, "Combo Navidad", "Comprando dos cafés te llevás un budín"))
        }
    }
}