package org.example.presentation

import org.example.domain.exceptions.InvalidIdException
import org.example.domain.usecase.*
import org.example.entity.Employee
import org.example.presentation.util.ConsoleStyle.errorMsg
import org.example.presentation.util.ConsoleStyle.info
import org.example.presentation.util.ConsoleStyle.label
import org.example.presentation.util.ConsoleStyle.success
import org.example.presentation.util.ConsoleStyle.title

class AdminUi(
    private val addNewEmployeeUseCase: AddNewEmployeeUseCase,
    private val getEmployeeByIdUseCase: GetEmployeeByIdUseCase,
    private val getAllEmployeesUseCase: GetAllEmployeesUseCase,
    private val editEmployeeInfoUseCase: EditEmployeeInfoUseCase,
    private val deleteEmployeeUseCase: DeleteEmployeeUseCase,
) {
    fun startSystem() {
        try {
            welcomeMsg()
            startMenu()
        }catch (e:Exception){
            println(errorMsg(e.message?:"something went wrong"))
        }

    }

    private fun welcomeMsg() {
        println(title("\n👋 Welcome back, Admin!"))
        println(info("How can I assist you today?"))
    }

    private fun startMenu() {
        selectMenu()

        while (true) {
            when (readLine()?.toIntOrNull()) {
                1 -> addNewEmployee()
                2 -> editEmployeeInfo()
                3 -> getEmployeeInfo()
                4 -> getAllEmployees()
                5 -> deleteEmployee()
                0 -> {
                    println(success("👋 Goodbye!"))
                    break
                }
                else -> println(errorMsg("❌ Unknown option"))
            }
        }
    }


    private fun selectMenu() {
        val choicesMsg = """
            ------------------------------------------
                ${label("📋 MENU OPTIONS:")}
                1️⃣  Add new employee
                2️⃣  Edit employee info
                3️⃣  Get employee by ID
                4️⃣  List all employees
                5️⃣  Delete employee
                0️⃣  Exit
            """.trimIndent()
        println(choicesMsg)
    }

    private fun addNewEmployee() {
        println(title("\n🆕 Add New Employee"))
        val id = promptInt("Enter ID:")
        val name = prompt("Enter name:")
        val password = prompt("Enter password:")
        val salary = promptDouble("Enter salary:")
        addNewEmployeeUseCase(Employee(id, name, password, salary))
        println(success("✅ Employee $id - $name added successfully"))
        selectMenu()
        return
    }

    private fun editEmployeeInfo() {
        println(title("\n✏️ Edit Employee Info"))
        val id = promptInt("Enter ID:")
        val name = prompt("Enter name:")
        val password = prompt("Enter password:")
        val salary = promptDouble("Enter salary:")
        editEmployeeInfoUseCase(Employee(id, name, password, salary))
        println(success("✅ Employee $id - $name updated successfully"))
        selectMenu()
        return
    }

    private fun getEmployeeInfo() {
        println(title("\n🔍 Get Employee Info"))
        val id = promptInt("Enter ID:")
        val employee = getEmployeeByIdUseCase(id)

        println(
            info(
                """
            ┌─────────────────────────────┐
            │ ID       : ${employee.id}
            │ Name     : ${employee.name}
            │ Password : ${employee.password}
            │ Salary   : ${"%.2f".format(employee.salary)} EGP
            └─────────────────────────────┘
        """.trimIndent()
            )
        )
        selectMenu()
        return
    }

    private fun getAllEmployees() {
        println(title("\n📚 All Employees List:"))
        val employees = getAllEmployeesUseCase()
        if (employees.isEmpty()) {
            println(errorMsg("⚠️ No employees found."))
        } else {
            employees.forEachIndexed { index, employee ->
                println(
                    info(
                        """
                    🔹 Employee #${index + 1}
                    ┌────────────────────┐
                    │ ID       : ${employee.id}
                    │ Name     : ${employee.name}
                    │ Password : ${employee.password}
                    │ Salary   : ${"%.2f".format(employee.salary)} EGP
                    └────────────────────┘
                """.trimIndent()
                    )
                )
            }
        }
        selectMenu()
        return
    }

    private fun deleteEmployee() {
        println(title("\n🗑️ Delete Employee"))
        val id = promptInt("Enter ID:")
        deleteEmployeeUseCase(id)
        println(success("✅ Employee $id deleted successfully"))
        selectMenu()
        return
    }


    private fun prompt(message: String): String {
        print(label("🔸 $message "))
        return readln()
    }

    private fun promptInt(message: String): Int {
        print(label("🔸 $message "))
        return readln().toIntOrNull() ?: throw InvalidIdException(errorMsg("❌ Invalid number"))
    }

    private fun promptDouble(message: String): Double {
        print(label("🔸 $message "))
        return readln().toDoubleOrNull() ?: throw InvalidIdException(errorMsg("❌ Invalid number"))
    }
}
