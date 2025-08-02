package org.example.data.repository

import org.example.data.datasource.memory.AdminDataSource
import org.example.data.datasource.memory.ClientDataSource
import org.example.data.datasource.memory.EmployeeDataSource
import org.example.domain.exceptions.NotFoundException
import org.example.domain.repository.AuthRepository
import org.example.entity.Auth
import org.example.entity.Role

class AuthRepositoryImpl(
    private val adminDataSource: AdminDataSource,
    private val employeeDataSource: EmployeeDataSource,
    private val clientDataSource: ClientDataSource

): AuthRepository {
    override fun login(username: String, password: String): Auth {
        adminDataSource.getAllAdmins().find { it.name == username && it.password == password }?.let {
            return Auth(
                username = username,
                password = password,
                role = Role.ADMIN
            )
        }
        employeeDataSource.getAllEmployees().find { it.name == username && it.password == password }?.let {
            return Auth(
                username = username,
                password = password,
                role = Role.EMPLOYEE
            )
        }
        clientDataSource.getAllClients().find { it.name == username && it.password == password }?.let {
            return Auth(
                username = username,
                password = password,
                role = Role.CLIENT
            )
        }
        throw NotFoundException("Username or password not found")

    }
}