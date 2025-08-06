package org.example.domain.usecase.employeeUseCase

import org.example.domain.repository.AdminRepository

class GetEmployeeByIdUseCase(private val adminRepository: AdminRepository) {
    operator fun invoke (id:Int) = adminRepository.getEmployeeById(id)
}