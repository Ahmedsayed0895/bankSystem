package org.example.domain.usecase.employeeUseCase

import org.example.domain.repository.AdminRepository
import org.example.entity.Employee

class GetEmployeeByIdUseCase(private val adminRepository: AdminRepository) {
    operator fun invoke(id: Int): Employee = adminRepository.getEmployeeById(id)
}