package mo.staff


class Order(val id: Id, val customer: Customer, val product: Product) {
    private val packingSlips: MutableList<PackingSlip> = mutableListOf()

    fun getPackingSlips(): List<PackingSlip> = packingSlips.toList()

    fun pay() {
        val productPayProcessor = when (product.type) {
            ProductType.PHYSICAL -> PhysicalProductTypePayProcessor()
            ProductType.BOOK -> BookProductTypePayProcessor()
            ProductType.MEMBERSHIP -> MembershipProductTypePayProcessor()
        }
        productPayProcessor.process(this)
    }

    internal fun addPackingSlip(packingSlipType: PackingSlipType) {
        packingSlips.add(PackingSlip(packingSlipType))
    }

    internal fun activateCustomerMembership() {
        customer.activateMembership()
    }
}

interface ProductTypePayProcessor {
    fun process(order: Order)
}

class PhysicalProductTypePayProcessor : ProductTypePayProcessor {
    override fun process(order: Order) {
        order.addPackingSlip(PackingSlipType.SHIPMENT)
    }
}

class BookProductTypePayProcessor : ProductTypePayProcessor {
    override fun process(order: Order) {
        order.addPackingSlip(PackingSlipType.SHIPMENT)
        order.addPackingSlip(PackingSlipType.ROYALTY)
    }
}

class MembershipProductTypePayProcessor : ProductTypePayProcessor {
    override fun process(order: Order) {
        order.activateCustomerMembership()
    }
}
