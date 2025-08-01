package org.example.domain.usecase

import org.example.domain.repository.AdminRepository
import org.example.entity.Employee

class AddNewEmployeeUseCase(private val adminRepository: AdminRepository) {
    operator fun invoke(employee: Employee) = adminRepository.addNewEmployee(employee)
}