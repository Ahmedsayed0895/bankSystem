package org.example.domain.usecase

import org.example.domain.repository.EmployeeRepository
import org.example.entity.Client

class EditClientInfoUseCase(val employeeRepository: EmployeeRepository) {
    operator fun invoke(client: Client) = employeeRepository.editClientInfo(client)
}