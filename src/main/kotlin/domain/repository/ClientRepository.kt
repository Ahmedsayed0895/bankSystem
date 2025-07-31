package org.example.domain.repository

interface ClientRepository {
    fun deposit(id: Int, amount: Double)
    fun withdraw(id: Int, amount: Double)
    fun checkBalance(id : Int):Double
    fun transferMoney(id: Int, amount: Double, receiverId:Int)
}
