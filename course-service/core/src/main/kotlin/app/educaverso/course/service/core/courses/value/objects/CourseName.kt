package app.educaverso.course.service.core.courses.value.objects

class CourseName(val value: String) {
    init {
        require(value.isNotEmpty()) { "Course name cannot be empty" }
    }
}