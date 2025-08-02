package org.example.presentation

import org.example.domain.exceptions.InvalidIdException
import org.example.domain.usecase.LoginUseCase
import org.example.entity.Role
import org.example.presentation.util.ConsoleStyle.label
import org.example.presentation.util.ConsoleStyle.success

class SystemUi (
    private val adminUi: AdminUi,
    private val employeeUi: EmployeeUi,
    private val clientUi: ClientUi,
    private val loginUseCase: LoginUseCase
){
    fun start() {
        try {
            while (true) {
                println("starting system ui")
                println("enter username")
                val username = readln()
                println("enter password")
                val password = readln()
                val auth = loginUseCase(
                    username = username,
                    password = password
                )
                when (auth.role) {
                    Role.ADMIN -> adminUi.startSystem()
                    Role.EMPLOYEE -> employeeUi.startSystem()
                    Role.CLIENT -> clientUi.startSystem()
                }
            }
        }catch (e: Exception){
            println(e.message)
        }
    }
}