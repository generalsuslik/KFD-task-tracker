package kfd.tasktracker.controller

import jakarta.servlet.http.HttpServletRequest
import kfd.tasktracker.exception.exception.NotFoundException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/**")
class ErrorController {

    @GetMapping
    fun getError(request: HttpServletRequest) {
        throw NotFoundException("Not valid url: ${request.requestURL}")
    }

    @PostMapping
    fun postError(request: HttpServletRequest) {
        throw NotFoundException("Not valid url: ${request.requestURL}")
    }

    @PutMapping
    fun putError(request: HttpServletRequest) {
        throw NotFoundException("Not valid url: ${request.requestURL}")
    }

    @DeleteMapping
    fun deleteError(request: HttpServletRequest) {
        throw NotFoundException("Not valid url: ${request.requestURL}")
    }
}