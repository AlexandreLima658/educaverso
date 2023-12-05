package app.educaverso.course.service.core.courses

import app.educaverso.commons.domain.entities.AggregateRoot
import app.educaverso.commons.domain.values.CourseId
import app.educaverso.course.service.core.courses.fields.CourseName

class Course(
    id: CourseId = CourseId.generate(),
    var name: CourseName,
    var published: Boolean
) : AggregateRoot<CourseId>(id)