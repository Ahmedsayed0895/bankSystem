package org.example.data.repository

import org.example.data.datasource.memory.ClientDataSource
import org.example.domain.exceptions.NotFoundException
import org.example.domain.repository.EmployeeRepository
import org.example.entity.Client

class EmployeeRepositoryImpl(
    private val clientDataSource: ClientDataSource
): EmployeeRepository {
    override fun addNewClient(client: Client) {
        clientDataSource.addClient(client)
    }

    override fun getClientById(id: Int): Client {
        return clientDataSource.getClient(id)
    }

    override fun getAllClients(): List<Client> {
        return clientDataSource.getAllClients()
    }

    override fun editClientInfo(client: Client) {
        clientDataSource.updateClient(client)
    }

    override fun deleteClient(id: Int) {
        clientDataSource.deleteClient(id)
    }

}