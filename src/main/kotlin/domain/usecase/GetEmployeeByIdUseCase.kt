package org.example.domain.usecase

import org.example.domain.repository.AdminRepository
import org.example.domain.repository.EmployeeRepository

class GetEmployeeByIdUseCase(private val adminRepository: AdminRepository) {
    operator fun invoke (id:Int) = adminRepository.getEmployeeById(id)
}