package com.realworld.controller

import com.realworld.exception.InvalidPasswordException
import com.realworld.exception.UserNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionAdvice {

    @ExceptionHandler(UserNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handle(e: UserNotFoundException) {
        log.warn(e.message, e)
    }

    @ExceptionHandler(InvalidPasswordException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handle(e: InvalidPasswordException) {
        log.warn(e.message, e)
    }

    companion object {
        private val log = LoggerFactory.getLogger(ExceptionAdvice::class.java)
    }
}
