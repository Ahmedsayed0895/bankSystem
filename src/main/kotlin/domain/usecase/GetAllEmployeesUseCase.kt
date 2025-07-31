package org.example.domain.usecase

import org.example.domain.repository.AdminRepository

class GetAllEmployeesUseCase(private val adminRepository: AdminRepository) {
    fun invoke() = adminRepository.getAllEmployees()
}