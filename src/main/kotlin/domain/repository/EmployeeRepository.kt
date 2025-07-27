package org.example.domain.repository

import org.example.entity.Client

interface EmployeeRepository {
    fun addNewClient(client: Client): Boolean
    fun getClientById(id: Int): Client
    fun getAllClients(): List<Client>
    fun editClientInfo(client: Client): Client
    fun deleteClient(id: Int): Boolean
    fun displayClientInfo(client: Client)
}