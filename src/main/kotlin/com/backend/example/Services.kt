package com.backend.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.Throws

interface UserService {

    /**
     * Find all Users
     * @return a list of Users
     */
    fun findAll(): List<User>?

    /**
     * Find User by id
     * @return a User
     */
    fun findById(id: Long) : User?

    /**
     * Save and flush a User entity in the database
     * @param User
     * @return the User created
     */
    fun create(user : User) : User?
}


@Service
class AbstractUserService(
    @Autowired
    val userRepository: UserRepository
) : UserService {
    override fun findAll(): List<User>? {
        return userRepository.findAll()
    }

    @Throws(NoSuchElementException::class)
    override fun findById(id: Long): User? {
        return userRepository.findById(id).orElse(null)
            ?: throw NoSuchElementException(String.format("The user with the id: %s not found", id))
    }

    override fun create(user: User): User? {
        return userRepository.save((user))
    }
}
