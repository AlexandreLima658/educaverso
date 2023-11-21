package app.educaverso.course.service.core.modules.value.objects

class ModuleName(val value: String) {
    init {
        require(value.isNotEmpty()) { "Module name cannot be empty" }
    }
}