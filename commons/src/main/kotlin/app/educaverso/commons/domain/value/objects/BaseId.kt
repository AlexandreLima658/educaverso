package app.educaverso.commons.domain.value.objects

abstract class BaseId<T>(val value: T) {

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BaseId<*>) return false
        return value == other.value
    }
}
