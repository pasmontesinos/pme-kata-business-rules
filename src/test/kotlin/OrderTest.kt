import mo.staff.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OrderTest {

    @Test
    fun `payment for a physical product should generate a packing slip for shipping`() {
        val order = Order(Id.random(), Product(Id.random(), ProductType.PHYSICAL))

        order.pay()

        assertEquals(PackingSlip(PackingSlipType.SHIPMENT), order.packingSlip)
    }
}


