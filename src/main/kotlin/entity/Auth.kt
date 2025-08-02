package org.example.entity

data class Auth(
    val username: String,
    val password: String,
    val role: Role
)

enum class Role {
    ADMIN,
    EMPLOYEE,
    CLIENT,
}