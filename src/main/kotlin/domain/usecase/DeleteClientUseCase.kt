package org.example.domain.usecase

import org.example.domain.repository.EmployeeRepository

class DeleteClientUseCase(val employeeRepository: EmployeeRepository) {
    fun invoke(id:Int) = employeeRepository.deleteClient(id)
}