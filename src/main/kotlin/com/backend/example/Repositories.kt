package com.backend.example

import org.springframework.beans.factory.annotation.Autowired


val user: User = User(
    1,
    "John",
    "Doe",
    "john@mail.com"
)


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
