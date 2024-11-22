package mo.staff


class Order(val id: Id, val product: Product) {
    val packingSlips: MutableList<PackingSlip> = mutableListOf()

    fun pay() {
        this.packingSlips.add(PackingSlip(PackingSlipType.SHIPMENT))
        if (product.type == ProductType.BOOK) {
            this.packingSlips.add(PackingSlip(PackingSlipType.ROYALTY))
        }
    }

}