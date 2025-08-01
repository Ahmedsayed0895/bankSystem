package org.example.domain.usecase

import org.example.domain.repository.EmployeeRepository
import org.example.entity.Client

class GetAllClientsUseCase(val employeeRepository: EmployeeRepository) {
    operator fun invoke():List<Client> = employeeRepository.getAllClients()
}