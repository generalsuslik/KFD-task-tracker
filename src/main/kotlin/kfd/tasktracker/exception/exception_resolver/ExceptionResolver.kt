package kfd.tasktracker.exception.exception_resolver

import kfd.tasktracker.exception.exception.AlreadyExistsException
import kfd.tasktracker.exception.exception.NotFoundException
import kfd.tasktracker.exception.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class ExceptionResolver {

    @ExceptionHandler(AlreadyExistsException::class)
    fun handleAlreadyExistsException(ex: AlreadyExistsException): ErrorResponse =
        ErrorResponse(
            timestamp = LocalDateTime.now(),
            message = ex.message!!,
            status = HttpStatus.BAD_REQUEST.value(), // 400
        )

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException): ErrorResponse =
        ErrorResponse(
            timestamp = LocalDateTime.now(),
            message = ex.message!!,
            status = HttpStatus.NOT_FOUND.value(), // 404
        )

    @ExceptionHandler(RuntimeException::class)
    fun handleOtherException(ex: RuntimeException): ErrorResponse =
        ErrorResponse(
            timestamp = LocalDateTime.now(),
            message = "Something went wrong",
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(), // 500
        )
}