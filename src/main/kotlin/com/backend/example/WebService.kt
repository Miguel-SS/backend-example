package com.backend.example

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import kotlin.jvm.Throws

@RestController
@RequestMapping("\${url.users}")
class UserController(private val userService: UserService) {
    /**
     * WS to find all elements of type User
     * @return a list of elements of type User
     */
    @GetMapping
    @ResponseBody
    fun findAll() = userService.findAll()

    /**
     * WS to find one User by the id
     * @return the User found
     */
    @Throws(NoSuchElementException::class)
    @GetMapping("{id}")
    @ResponseBody
    fun findById(@PathVariable id: Long) = userService.findById(id)

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseBody
    fun create(@RequestBody user: User): User? {
        return userService.create(user)
    }
}