package org.example.presentation

import org.example.domain.exceptions.InvalidAmountException
import org.example.domain.exceptions.InvalidIdException
import org.example.domain.usecase.*
import org.example.presentation.util.ConsoleStyle.errorMsg
import org.example.presentation.util.ConsoleStyle.info
import org.example.presentation.util.ConsoleStyle.label
import org.example.presentation.util.ConsoleStyle.success
import org.example.presentation.util.ConsoleStyle.title

class ClientUi(
    private val depositUseCase: DepositUseCase,
    private val withDrawUseCase: WithDrawUseCase,
    private val transferMoneyUseCase: TransferMoneyUseCase,
    private val checkBalanceUseCase: CheckBalanceUseCase,
) {

    fun startSystem() {
        try {
            println(title("💳 Welcome, Client! Please enter your ID:"))
            val id = readLine()?.toIntOrNull() ?: throw InvalidIdException(errorMsg("❌ Please enter a valid ID."))
            welcomeMsg()
            startMenu(id)
        } catch (e: Exception) {
            println(errorMsg("❗ ${e.message}"))
        }
    }

    private fun welcomeMsg() {
        println(title("\n👋 Hello again!"))
        println(info("How can I assist you today?"))
    }

    private fun startMenu(id: Int) {
        while (true) {
            selectMenu()

            when (readLine()?.toIntOrNull()) {
                1 -> deposit(id)
                2 -> withDraw(id)
                3 -> transferMoney(id)
                4 -> checkBalance(id)
                0 -> {
                    println(success("👋 See you soon!"))
                    return
                }
                else -> println(errorMsg("❌ Unknown option. Try again."))
            }
        }
    }

    private fun selectMenu() {
        println(
            """
                ----------------------------------------------
                    ${label("📋 MENU OPTIONS:")}
                    1️⃣  Deposit
                    2️⃣  Withdraw
                    3️⃣  Transfer Money
                    4️⃣  Check Balance
                    0️⃣  Exit
                ----------------------------------------------
                """.trimIndent()
        )
    }

    private fun deposit(id: Int) {
        println(title("\n💰 Deposit"))
        val amount = promptDouble("Enter amount to deposit:")
        depositUseCase(id = id, amount = amount)
        println(success("✅ Deposited $amount EGP successfully."))
        return
    }

    private fun withDraw(id: Int) {
        println(title("\n🏧 Withdraw"))
        val amount = promptDouble("Enter amount to withdraw:")
        withDrawUseCase(id = id, amount = amount)
        println(success("✅ Withdrawn $amount EGP successfully."))
        return
    }

    private fun transferMoney(id: Int) {
        println(title("\n🔄 Transfer Money"))
        val amount = promptDouble("Enter amount to transfer:")
        val receiverId = promptInt("Enter Receiver ID:")
        transferMoneyUseCase(id = id, amount = amount, receiverId = receiverId)
        println(success("✅ Transferred $amount EGP to ID $receiverId successfully."))
        return
    }

    private fun checkBalance(id: Int) {
        println(title("\n📊 Check Balance"))
        val balance = checkBalanceUseCase(id)
        println(info("💵 Your current balance is: ${"%.2f".format(balance)} EGP"))
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
        return readln().toDoubleOrNull() ?: throw InvalidAmountException(errorMsg("❌ Invalid amount"))
    }
}
