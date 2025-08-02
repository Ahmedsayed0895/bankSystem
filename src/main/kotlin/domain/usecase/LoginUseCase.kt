package org.example.domain.usecase

import org.example.domain.repository.AuthRepository
import org.example.entity.Auth

class LoginUseCase(val authRepository: AuthRepository) {
   operator fun invoke(username:String, password:String): Auth
    = authRepository.login(username = username, password = password)
}