package org.example.domain.usecase.employeeUseCase

import org.example.domain.repository.AdminRepository


class DeleteEmployeeUseCase(private val adminRepository: AdminRepository) {
    operator fun invoke(id : Int) = adminRepository.deleteEmployee(id)
}