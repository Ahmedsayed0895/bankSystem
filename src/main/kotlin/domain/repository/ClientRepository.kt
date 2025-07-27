package org.example.domain.repository

interface ClientRepository {
    fun deposit(id: Int, amount: Double): Boolean
    fun withdraw(id: Int, amount: Double): Boolean
    fun checkBalance(id : Int):Double
    fun transferMoney(id: Int, amount: Double): Boolean
}
