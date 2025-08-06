package org.example.presentation

import org.example.domain.usecase.authUseCase.LoginUseCase
import org.example.entity.util.Role
import org.example.presentation.util.ConsoleStyle.errorMsg
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
                label("🔐 Login to the system")
                print("👤 Username: ")
                val username = readln()
                print("🔑 Password: ")
                val password = readln()
                val auth = loginUseCase(
                    username = username,
                    password = password
                )
                println(success("✅ Logged in successfully as ${auth.role}"))

                when (auth.role) {
                    Role.ADMIN -> {

                        adminUi.startSystem()
                    }
                    Role.EMPLOYEE -> employeeUi.startSystem()
                    Role.CLIENT -> clientUi.startSystem()
                }
            }
        }catch (e: Exception){
            errorMsg(e.message ?: "❌ Unexpected error")
        }
    }
}