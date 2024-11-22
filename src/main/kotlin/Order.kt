package mo.staff


class Order(val id: Id, val product: Product) {
    var packingSlip: PackingSlip? = null
        get() = field

    fun pay() {
        this.packingSlip = PackingSlip(PackingSlipType.SHIPMENT)


    }

}