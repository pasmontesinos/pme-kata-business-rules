package mo.staff


class Order(val id: Id, val customer: Customer, val product: Product) {
    val packingSlips: MutableList<PackingSlip> = mutableListOf()

    fun pay() {
        if (product.type == ProductType.PHYSICAL) {
            this.packingSlips.add(PackingSlip(PackingSlipType.SHIPMENT))
            return
        }

        if (product.type == ProductType.BOOK) {
            this.packingSlips.add(PackingSlip(PackingSlipType.SHIPMENT))
            this.packingSlips.add(PackingSlip(PackingSlipType.ROYALTY))
            return
        }

        if (product.type == ProductType.MEMBERSHIP) {
            customer.activateMembership()
            return
        }
    }

}