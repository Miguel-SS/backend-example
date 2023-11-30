package com.backend.example

import javax.persistence.*


@Entity
@Table(name="users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var name: String?,
    @Column(name = "last_name")
    var lastName: String?,
    var email: String,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }

    override fun toString(): String {
        return "User(id=$id, name=$name, lastName=$lastName, email='$email')"
    }

}


/*
data class User(
    var id: Long,
    var name: String,
    var lastName: String,
    var email: String
)
*/