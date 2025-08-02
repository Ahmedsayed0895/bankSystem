package org.example.data.repository

import org.example.data.datasource.memory.ClientDataSource
import org.example.domain.exceptions.NotFoundException
import org.example.domain.exceptions.SmallerThanZeroException
import org.example.domain.exceptions.WithDrawException
import org.example.domain.repository.ClientRepository

class ClientRepositoryImpl(
    private val clientDataSource: ClientDataSource
) : ClientRepository {
    override fun deposit(id: Int, amount: Double) {
        if (amount < 0.0) throw SmallerThanZeroException("Amount must be more than 0")
        val client = clientDataSource.getClient(id)
        val updatedClient = client.copy(balance = client.balance + amount)
        clientDataSource.updateClient(updatedClient)
    }

    override fun withdraw(id: Int, amount: Double) {
        if (amount < 0.0) throw SmallerThanZeroException("Amount must be more than 0")
        val client = clientDataSource.getClient(id)
        if (client.balance < amount) throw WithDrawException("your balance is less than amount")
        val updatedClient = client.copy(balance = client.balance - amount)
        clientDataSource.updateClient(updatedClient)
    }

    override fun checkBalance(id: Int): Double {
        return clientDataSource.getClient(id).balance
    }

    override fun transferMoney(id: Int, amount: Double, receiverId: Int) {
        clientDataSource.getAllClients().find { it.id == id }?:throw NotFoundException("no found client with id: $id")
        clientDataSource.getAllClients().find { it.id == receiverId }?:throw NotFoundException("no found client with id: $receiverId")
        withdraw(id = id, amount = amount)
        deposit(id = receiverId, amount = amount)
    }

}
