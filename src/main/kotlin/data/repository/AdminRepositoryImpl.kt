package org.example.data

import org.example.domain.repository.AdminRepository
import org.example.entity.Employee

class AdminRepositoryImpl(): AdminRepository {
    override fun addNewEmployee(employee: Employee): Boolean {

    }

    override fun getEmployeeById(id: Int): Employee {
        TODO("Not yet implemented")
    }

    override fun getAllEmployees(): List<Employee> {
        TODO("Not yet implemented")
    }

    override fun editEmployeeInfo(employee: Employee): Employee {
        TODO("Not yet implemented")
    }

    override fun deleteEmployee(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun displayEmployeeInfo(employee: Employee) {
        TODO("Not yet implemented")
    }
}