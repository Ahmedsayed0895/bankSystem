package org.example.data

import org.example.domain.repository.ClientRepository

class ClientRepositoryImpl(): ClientRepository {
    override fun deposit(id: Int, amount: Double): Boolean {
        TODO("Not yet implemented")
    }

    override fun withdraw(id: Int, amount: Double): Boolean {
        TODO("Not yet implemented")
    }

    override fun checkBalance(id: Int): Double {
        TODO("Not yet implemented")
    }

    override fun transferMoney(id: Int, amount: Double): Boolean {
        TODO("Not yet implemented")
    }
}