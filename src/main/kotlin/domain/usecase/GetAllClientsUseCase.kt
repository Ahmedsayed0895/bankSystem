package org.example.domain.usecase

import org.example.domain.repository.EmployeeRepository

class GetAllClientsUseCase(val employeeRepository: EmployeeRepository) {
    fun invoke() = employeeRepository.getAllClients()
}