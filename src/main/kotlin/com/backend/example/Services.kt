package com.backend.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

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


}


@Service
class AbstractUserService(
    val userRepository: UserRepository = AbstractUserRepository()
) : UserService {
    override fun findAll(): List<User>? {
        return userRepository.findAll()
    }

    override fun findById(id: Long): User? {
        return userRepository.findById(id)
    }
}
