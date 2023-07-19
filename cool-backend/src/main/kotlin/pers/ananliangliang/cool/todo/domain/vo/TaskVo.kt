package pers.ananliangliang.cool.todo.domain.vo

import org.springframework.data.annotation.LastModifiedDate
import java.time.OffsetDateTime

class TaskVo(
    var id: Long?,
    var name: String?,
    var note: String?,
    var isDone: Boolean?,
    var createdDate: OffsetDateTime?,
    var lastModifiedDate: OffsetDateTime?,
) {
}