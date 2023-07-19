package pers.ananliangliang.cool.todo.repository

import org.springframework.data.jpa.repository.JpaRepository
import pers.ananliangliang.cool.todo.domain.Task

interface TaskRepository : JpaRepository<Task, Long> {
    fun getByIsDoneFalse(): List<Task>
}