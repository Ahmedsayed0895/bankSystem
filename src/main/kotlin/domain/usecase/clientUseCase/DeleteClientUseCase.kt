package org.example.domain.usecase.clientUseCase

import org.example.domain.repository.EmployeeRepository

class DeleteClientUseCase(val employeeRepository: EmployeeRepository) {
    operator fun invoke(id:Int) = employeeRepository.deleteClient(id)
}