package app.educaverso.course.service.core.modules

import app.educaverso.commons.domain.value.objects.ModuleId
import app.educaverso.course.service.core.modules.value.objects.ModuleName

class Module(
    id: ModuleId = ModuleId.generate(),
    var name: ModuleName,
    var activated: Boolean
)