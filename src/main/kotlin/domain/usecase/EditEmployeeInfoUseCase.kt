package org.example.domain.usecase

import org.example.domain.repository.AdminRepository
import org.example.entity.Employee

class EditEmployeeInfoUseCase(private val adminRepository: AdminRepository) {
    fun invoke(employee: Employee) = adminRepository.editEmployeeInfo(employee)
}