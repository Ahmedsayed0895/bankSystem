package org.example.domain.usecase.clientUseCase

import org.example.domain.repository.EmployeeRepository
import org.example.entity.Client

class GetClientByIdUseCase(val employeeRepository: EmployeeRepository) {
    operator fun invoke(id: Int): Client = employeeRepository.getClientById(id)
}