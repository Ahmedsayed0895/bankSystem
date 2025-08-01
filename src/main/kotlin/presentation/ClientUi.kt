package org.example.presentation

import org.example.domain.exceptions.InvalidAmountException
import org.example.domain.exceptions.InvalidIdException
import org.example.domain.usecase.CheckBalanceUseCase
import org.example.domain.usecase.DepositUseCase
import org.example.domain.usecase.TransferMoneyUseCase
import org.example.domain.usecase.WithDrawUseCase

class ClientUi(
    private val depositUseCase: DepositUseCase,
    private val withDrawUseCase: WithDrawUseCase,
    private val transferMoneyUseCase: TransferMoneyUseCase,
    private val checkBalanceUseCase: CheckBalanceUseCase,
) {
    fun startSystem() {
        try {
            println("welcome, please enter your id ")
            val id = readLine()?.toIntOrNull() ?: throw InvalidIdException("please valid id")
            welcomeMsg()
            startMenu(id)
        }catch (e:Exception){
            println(e.message)
        }

    }

    private fun welcomeMsg() {
        println("Welcome back,")
        println("how can i help you?: ")
    }

    private fun startMenu(id: Int) {
        val choicesMsg: String = """
            1- Deposit
            2- Withdraw
            3- Transfer Money
            4- Check your balance
        """.trimIndent()
        println(choicesMsg)
        val selector = readLine()?.toIntOrNull()
        when (selector) {
            1 -> deposit(id)
            2 -> withDraw(id)
            3 -> transferMoney(id)
            4 -> checkBalance(id)
            else -> println("Unknown option")
        }
    }

    private fun deposit(id: Int) {
        println("Deposit")
        println("please enter your amount")
        val amount = readLine()?.toDoubleOrNull() ?: throw InvalidAmountException("please valid amount")
        depositUseCase(id = id, amount = amount)

    }

    private fun withDraw(id: Int) {
        println("WithDraw")
        println("please enter your amount")
        val amount = readLine()?.toDoubleOrNull() ?: throw InvalidAmountException("please valid amount")
        withDrawUseCase(id = id, amount = amount)
    }

    private fun transferMoney(id: Int) {
        println("Transfer Money")
        println("please enter your amount")
        val amount = readLine()?.toDoubleOrNull() ?: throw InvalidAmountException("please valid amount")
        println("please enter Receiver id")
        val receiverId = readLine()?.toIntOrNull() ?: throw InvalidIdException("please valid id")
        transferMoneyUseCase(id = id, amount = amount, receiverId = receiverId)
    }

    private fun checkBalance(id: Int) {
        println("Check balance")
        println("your current balance: $checkBalanceUseCase EGP")
    }


}