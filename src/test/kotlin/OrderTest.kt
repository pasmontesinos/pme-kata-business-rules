import mo.staff.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OrderTest {

    @Test
    fun `payment for a physical product should generate a packing slip for shipping`() {
        val order = Order(Id.random(), Product(Id.random(), ProductType.PHYSICAL))

        order.pay()

        val expectedPackingSlips = listOf(PackingSlip(PackingSlipType.SHIPMENT))
        assertEquals(expectedPackingSlips, order.packingSlips)
    }

    @Test
    fun `payment for a book should generate a duplicate packing slip for royalty`(){
        val order = Order(Id.random(), Product(Id.random(), ProductType.BOOK))

        order.pay()

        val expectedPackingSlips = listOf(
            PackingSlip(PackingSlipType.SHIPMENT),
            PackingSlip(PackingSlipType.ROYALTY),
        )
        assertEquals(expectedPackingSlips, order.packingSlips)
    }

}


