package org.example.domain.usecase

import org.example.domain.repository.AdminRepository


class DeleteEmployeeUseCase(private val adminRepository: AdminRepository) {
    fun invoke(id : Int) = adminRepository.deleteEmployee(id)
}