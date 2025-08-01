package org.example.domain.usecase

import org.example.domain.repository.AdminRepository
import org.example.entity.Employee

class GetAllEmployeesUseCase(private val adminRepository: AdminRepository) {
    operator fun invoke(): List<Employee> = adminRepository.getAllEmployees()
}