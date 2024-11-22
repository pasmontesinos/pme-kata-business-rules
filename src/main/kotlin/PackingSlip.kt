package mo.staff


data class PackingSlip(val type: PackingSlipType) {
}

enum class PackingSlipType {
    SHIPMENT,
    ROYALTY,
}