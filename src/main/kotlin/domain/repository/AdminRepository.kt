package org.example.domain.repository

import org.example.entity.Employee

interface AdminRepository {
    fun addNewEmployee(employee: Employee)
    fun getEmployeeById(id: Int): Employee
    fun getAllEmployees(): List<Employee>
    fun editEmployeeInfo(employee: Employee)
    fun deleteEmployee(id: Int)
}