package org.example.domain.usecase.clientUseCase

import org.example.domain.repository.EmployeeRepository
import org.example.entity.Client

class AddNewClientUseCase(private val employeeRepository: EmployeeRepository) {
    operator fun invoke(client: Client) = employeeRepository.addNewClient(client)
}