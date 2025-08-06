package org.example.data.repository

import org.example.data.datasource.memory.EmployeeDataSource
import org.example.domain.repository.AdminRepository
import org.example.entity.Employee

class AdminRepositoryImpl(
    private val employeeDataSource: EmployeeDataSource
): AdminRepository {
    override fun addNewEmployee(employee: Employee) {
        employeeDataSource.addEmployee(employee)
    }

    override fun getEmployeeById(id: Int): Employee {
       return employeeDataSource.getEmployee(id)
    }

    override fun getAllEmployees(): List<Employee> {
        return employeeDataSource.getAllEmployees()
    }

    override fun editEmployeeInfo(employee: Employee) {
        employeeDataSource.updateEmployee(employee)
    }

    override fun deleteEmployee(id: Int) {
        employeeDataSource.deleteEmployee(id)
    }

}