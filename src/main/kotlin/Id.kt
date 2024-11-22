package mo.staff

import java.util.*

data class Id(val value: UUID){
    companion object {
        fun random() = Id(UUID.randomUUID())
    }
}