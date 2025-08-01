package org.example.presentation

import org.example.domain.exceptions.InvalidIdException
import org.example.domain.usecase.AddNewEmployeeUseCase
import org.example.domain.usecase.DeleteEmployeeUseCase
import org.example.domain.usecase.EditEmployeeInfoUseCase
import org.example.domain.usecase.GetAllEmployeesUseCase
import org.example.domain.usecase.GetEmployeeByIdUseCase
import org.example.entity.Employee

class AdminUi(
    private val addNewEmployeeUseCase: AddNewEmployeeUseCase,
    private val getEmployeeByIdUseCase: GetEmployeeByIdUseCase,
    private val getAllEmployeesUseCase: GetAllEmployeesUseCase,
    private val editEmployeeInfoUseCase: EditEmployeeInfoUseCase,
    private val deleteEmployeeUseCase: DeleteEmployeeUseCase,
) {
    fun startSystem(){
        println("welcome, please enter your id ")
        val id = readln().toIntOrNull()?: throw InvalidIdException("please valid id")
        welcomeMsg()
        startMenu(id)

    }
    private fun welcomeMsg() {
        println("Welcome back,")
        println("how can i help you?: ")
    }

    private fun startMenu(id: Int) {
        val choicesMsg: String = """
            1- Add new employee
            2- Edit employee Info
            3- Get employee by id
            4- Check your balance
        """.trimIndent()
        println(choicesMsg)
        val selector = readLine()?.toIntOrNull()
        when (selector) {
            1 -> addNewEmployee()
            2 -> editEmployeeInfo()
            3 -> getEmployeeInfo()
            4 -> getAllEmployees()
            5-> deleteEmployee()
            else -> println("Unknown option")
        }
    }
    private fun addNewEmployee() {
        println("Add new employee")
        println("employee id:")
        val id: Int = readln().toIntOrNull()?:throw InvalidIdException("please valid id")
        println("employee name:")
        val name: String = readln()
        println("employee password:")
        val password: String = readln()
        println("employee salary:")
        val salary : Double = readln().toDoubleOrNull()?:throw InvalidIdException("please valid salary")
        addNewEmployeeUseCase(Employee(
            id = id,
            name = name,
            password = password,
            salary = salary
        ))
    }

    private fun editEmployeeInfo() {
        println("Edit new employee")
        println("employee id:")
        val id: Int = readln().toIntOrNull()?:throw InvalidIdException("please valid id")
        println("employee name:")
        val name: String = readln()
        println("employee password:")
        val password: String = readln()
        println("employee salary:")
        val salary: Double = readln().toDoubleOrNull()?:throw InvalidIdException("please valid salary")
        editEmployeeInfoUseCase(Employee(
            id = id,
            name = name,
            password = password,
            salary = salary
        ))
    }

    private fun getEmployeeInfo(){
        println("Get employee info")
        println("employee id:")
        val id: Int = readln().toIntOrNull()?:throw InvalidIdException("please valid id")
        val employee = getEmployeeByIdUseCase(id)
        println("""
            --------------------------------------
            employee id: ${employee.id}
            employee name: ${employee.name}
            employee password: ${employee.password}
            employee salary: ${employee.salary}
            --------------------------------------
            
        """.trimIndent())
    }

    private fun getAllEmployees(){
        println("Get all employees")
        getAllEmployeesUseCase().forEachIndexed { index,employee ->
            println("""
                ------------------${index+1}--------------------
                id: ${employee.id}
                name: ${employee.name}
                password: ${employee.password}
                salary: ${employee.salary}
                ---------------------------------------
            """.trimIndent())
        }
    }
    private fun deleteEmployee() {
        println("Delete employee")
        println("employee id:")
        val id: Int = readln().toIntOrNull()?:throw InvalidIdException("please valid id")
        deleteEmployeeUseCase(id)
    }
}