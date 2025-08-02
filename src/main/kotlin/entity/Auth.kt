package org.example.entity

import org.example.entity.util.Role

data class Auth(
    val username: String,
    val password: String,
    val role: Role
)
