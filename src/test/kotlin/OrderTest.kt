import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import java.util.UUID
import org.junit.jupiter.api.Test

data class Id(val value: UUID){
    companion object {
        fun random() = Id(UUID.randomUUID())
    }
}

class OrderTest {

    @Test
    fun `payment for a physical product should generate a packing slip for shipping`() {
        val order = Order(Id.random(), Product(Id.random(), ProductType.PHYSICAL))

        order.pay()

        assertEquals(PackingSlip(PackingSlipType.SHIPMENT), order.packingSlip)
    }
}


class Order(val id: Id, val product: Product) {
    var packingSlip: PackingSlip? = null

    fun pay() {
        this.packingSlip = PackingSlip(PackingSlipType.SHIPMENT)


    }

}

data class PackingSlip(val type: PackingSlipType) {
}


data class Product(val id: Id, val type: ProductType) {
}


enum class ProductType {
    PHYSICAL,
}

enum class PackingSlipType {
    SHIPMENT,
}
