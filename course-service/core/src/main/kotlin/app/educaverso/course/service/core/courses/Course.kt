package app.educaverso.course.service.core.courses

import app.educaverso.commons.domain.entities.AggregateRoot
import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.course.service.core.courses.value.objects.CourseName

class Course(
    id: CourseId,
    var name: CourseName,
    var published: Boolean
) : AggregateRoot<CourseId>(id)