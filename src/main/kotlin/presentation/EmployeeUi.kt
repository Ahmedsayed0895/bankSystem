package org.example.presentation

import org.example.domain.exceptions.InvalidIdException
import org.example.domain.usecase.clientUseCase.*
import org.example.entity.Client
import org.example.presentation.util.ConsoleStyle

class EmployeeUi(
    private val addNewClientUseCase: AddNewClientUseCase,
    private val getClientByIdUseCase: GetClientByIdUseCase,
    private val getAllClientUseCase: GetAllClientsUseCase,
    private val editClientInfoUseCase: EditClientInfoUseCase,
    private val deleteClientUseCase: DeleteClientUseCase,
) {
    fun startSystem() {
        try {
            welcomeMsg()
            startMenu()
        } catch (e: Exception) {
            println(ConsoleStyle.errorMsg(e.message ?: "something went wrong"))
        }

    }

    private fun welcomeMsg() {
        println(ConsoleStyle.title("\n👋 Welcome back, Employee!"))
        println(ConsoleStyle.info("How can I assist you today?"))
    }

    private fun startMenu() {
        selectMenu()

        while (true) {
            when (readLine()?.toIntOrNull()) {
                1 -> addNewClient()
                2 -> editClientInfo()
                3 -> getClientInfo()
                4 -> getAllClients()
                5 -> deleteClient()
                0 -> {
                    println(ConsoleStyle.success("👋 Goodbye!"))
                    break
                }

                else -> println(ConsoleStyle.errorMsg("❌ Unknown option"))
            }
        }
    }


    private fun selectMenu() {
        val choicesMsg = """
            ------------------------------------------
                ${ConsoleStyle.label("📋 MENU OPTIONS:")}
                1️⃣  Add new client
                2️⃣  Edit client info
                3️⃣  Get client by ID
                4️⃣  List all client
                5️⃣  Delete client
                0️⃣  Exit
            """.trimIndent()
        println(choicesMsg)
    }

    private fun addNewClient() {
        println(ConsoleStyle.title("\n🆕 Add New Client"))
        val id = promptInt("Enter ID:")
        val name = prompt("Enter name:")
        val password = prompt("Enter password:")
        val balance = promptDouble("Enter balance:")
        addNewClientUseCase(Client(id, name, password, balance))
        println(ConsoleStyle.success("✅ Employee $id - $name added successfully"))
        selectMenu()
        return
    }

    private fun editClientInfo() {
        println(ConsoleStyle.title("\n✏️ Edit Client Info"))
        val id = promptInt("Enter ID:")
        val name = prompt("Enter name:")
        val password = prompt("Enter password:")
        val balance = promptDouble("Enter balance:")
        editClientInfoUseCase(Client(id, name, password, balance))
        println(ConsoleStyle.success("✅ Client $id - $name updated successfully"))
        selectMenu()
        return
    }

    private fun getClientInfo() {
        println(ConsoleStyle.title("\n🔍 Get Employee Info"))
        val id = promptInt("Enter ID:")
        val client = getClientByIdUseCase(id)

        println(
            ConsoleStyle.info(
                """
            ┌─────────────────────────────┐
            │ ID       : ${client.id}
            │ Name     : ${client.name}
            │ Password : ${client.password}
            │ balance   : ${"%.2f".format(client.balance)} EGP
            └─────────────────────────────┘
        """.trimIndent()
            )
        )
        selectMenu()
        return
    }

    private fun getAllClients() {
        println(ConsoleStyle.title("\n📚 All Clients List:"))
        val clients = getAllClientUseCase()
        if (clients.isEmpty()) {
            println(ConsoleStyle.errorMsg("⚠️ No Clients found."))
        } else {
            clients.forEachIndexed { index, client ->
                println(
                    ConsoleStyle.info(
                        """
                    🔹 Employee #${index + 1}
                    ┌────────────────────┐
                    │ ID       : ${client.id}
                    │ Name     : ${client.name}
                    │ Password : ${client.password}
                    │ balance   : ${"%.2f".format(client.balance)} EGP
                    └────────────────────┘
                """.trimIndent()
                    )
                )
            }
        }
        selectMenu()
        return
    }

    private fun deleteClient() {
        println(ConsoleStyle.title("\n🗑️ Delete Client"))
        val id = promptInt("Enter ID:")
        deleteClientUseCase(id)
        println(ConsoleStyle.success("✅ Client $id deleted successfully"))
        selectMenu()
        return
    }


    private fun prompt(message: String): String {
        print(ConsoleStyle.label("🔸 $message "))
        return readln()
    }

    private fun promptInt(message: String): Int {
        print(ConsoleStyle.label("🔸 $message "))
        return readln().toIntOrNull() ?: throw InvalidIdException(ConsoleStyle.errorMsg("❌ Invalid number"))
    }

    private fun promptDouble(message: String): Double {
        print(ConsoleStyle.label("🔸 $message "))
        return readln().toDoubleOrNull() ?: throw InvalidIdException(ConsoleStyle.errorMsg("❌ Invalid number"))
    }
}