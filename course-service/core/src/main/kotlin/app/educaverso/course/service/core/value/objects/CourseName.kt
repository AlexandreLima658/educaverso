package app.educaverso.course.service.core.value.objects

data class CourseName(val value: String) {

    init {
       require(value.isNotEmpty()) { "Course name cannot be empty" }
    }

}