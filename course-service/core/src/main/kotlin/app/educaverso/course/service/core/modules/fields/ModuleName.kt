package app.educaverso.course.service.core.modules.fields

class ModuleName(val value: String) {
    init {
        require(value.isNotEmpty()) { "Module name cannot be empty" }
        require(value.length <= 100) { "Module name cannot be longer than 100 characters" }
    }
}