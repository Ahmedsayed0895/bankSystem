package org.example.domain.usecase

import org.example.domain.repository.EmployeeRepository
import org.example.entity.Client

class AddNewClientUseCase(private val employeeRepository: EmployeeRepository) {
    fun invoke(client: Client) = employeeRepository.addNewClient(client)
}