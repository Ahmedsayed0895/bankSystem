package org.example.domain.repository

import org.example.entity.Employee

interface AdminRepository {
    fun addNewEmployee(employee: Employee): Boolean
    fun getClientById(id: Int): Employee
    fun getAllEmployees(): List<Employee>
    fun editClientInfo(client: Employee): Employee
    fun deleteClient(id: Int): Boolean
    fun displayClientInfo(client: Employee)
}