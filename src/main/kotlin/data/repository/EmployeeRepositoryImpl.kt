package org.example.data

import org.example.domain.repository.EmployeeRepository
import org.example.entity.Client

class EmployeeRepositoryImpl(): EmployeeRepository {
    override fun addNewClient(client: Client): Boolean {
        TODO("Not yet implemented")
    }

    override fun getClientById(id: Int): Client {
        TODO("Not yet implemented")
    }

    override fun getAllClients(): List<Client> {
        TODO("Not yet implemented")
    }

    override fun editClientInfo(client: Client): Client {
        TODO("Not yet implemented")
    }

    override fun deleteClient(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun displayClientInfo(client: Client) {
        TODO("Not yet implemented")
    }
}