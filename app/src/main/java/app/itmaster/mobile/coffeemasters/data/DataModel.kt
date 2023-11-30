package app.itmaster.mobile.coffeemasters.data

import com.google.gson.annotations.SerializedName

data class Product(
    var id: Int,
    var name: String,
    var price: Double,
    var description: String,
    var image: String
)

data class Category(
    var name: String,
    //@SerializedName("products")
    var products: List<Product>
)

data class Offer(
    var id: Int,
    var title: String,
    var description: String
)

