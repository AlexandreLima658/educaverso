package app.educaverso.course.service.core.courses.fields

class CourseName(val value: String) {
    init {
        require(value.isNotEmpty()) { "Course name cannot be empty" }
        require(value.length <= 255) { "Course name cannot be longer than 255 characters" }
    }
}
