package mo.staff

class Customer(val id: Id) {
    private var member: Boolean = false

    fun activateMembership() {
        this.member = true
    }

    fun isMember(): Boolean {
        return this.member
    }
}
