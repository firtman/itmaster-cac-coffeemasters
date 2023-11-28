package app.itmaster.mobile.coffeemasters.data

data class Product(
    var id: Int,
    var name: String,
    var price: Double,
    var description: String,
    var image: String
)


data class Category(
    var name: String,
    var product: List<Product>
)

data class Offer(
    var id: Int,
    var title: String,
    var description: String
)