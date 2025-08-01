package org.example.domain.usecase

import org.example.domain.repository.EmployeeRepository

class GetClientByIdUseCase(val employeeRepository: EmployeeRepository) {
    operator fun invoke(id : Int) = employeeRepository.getClientById(id)
}