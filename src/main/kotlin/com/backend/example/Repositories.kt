package com.backend.example

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(@Param("email") email : String) : Optional<User>
}

/*
interface UserRepository {
    fun findAll(): List<User>?

    fun findById(id: Long): User?
}

class AbstractUserRepository(
    private val users: MutableList<User> = mutableListOf<User>()
) : UserRepository {

    init {
        users.add(
            User(
            1,
            "John",
            "Doe",
            "john@mail.com"
            )
        )

        users.add(
            User(
                2,
                "Joana",
                "Doe",
                "joana@mail.com"
            )
        )
    }
    override fun findAll(): List<User> {
        return users
    }

    override fun findById(id: Long): User? {
        return users.find { it.id == id }
    }

}
*/
