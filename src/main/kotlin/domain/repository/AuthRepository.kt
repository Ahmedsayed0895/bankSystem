package org.example.domain.repository

import org.example.entity.Auth

interface AuthRepository {
    fun login(username: String, password: String): Auth
}