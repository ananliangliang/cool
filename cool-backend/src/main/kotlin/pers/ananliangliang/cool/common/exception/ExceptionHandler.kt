package pers.ananliangliang.cool.common.exception

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody


@ControllerAdvice
class ExceptionHandler {

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(CoolException::class)
    @ResponseBody
    fun coolExceptionHandler(e: CoolException): ProblemDetail {
        logger.error(e) { e.message }
        return ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR).apply {
            title = "【${e.tag}】${e.message}"
            detail = title
        }
    }
}