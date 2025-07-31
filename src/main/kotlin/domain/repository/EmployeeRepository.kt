package org.example.domain.repository

import org.example.entity.Client

interface EmployeeRepository {
    fun addNewClient(client: Client)
    fun getClientById(id: Int): Client
    fun getAllClients(): List<Client>
    fun editClientInfo(client: Client)
    fun deleteClient(id: Int)
}