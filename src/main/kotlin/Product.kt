package mo.staff

data class Product(val id: Id, val type: ProductType) {
}

enum class ProductType {
    PHYSICAL,
}