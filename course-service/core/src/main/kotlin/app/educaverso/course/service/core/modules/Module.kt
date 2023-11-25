package app.educaverso.course.service.core.modules

import app.educaverso.commons.domain.value.objects.CourseId
import app.educaverso.commons.domain.value.objects.ModuleId
import app.educaverso.course.service.core.modules.fields.ModuleName

class Module(
    id: ModuleId = ModuleId.generate(),
    courseId: CourseId,
    var name: ModuleName,
    var activated: Boolean
)