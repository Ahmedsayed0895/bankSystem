package org.example.data.datasource.memory

import org.example.domain.exceptions.NotFoundException
import org.example.entity.Client


class ClientDataSource {
    val clientsList: MutableList<Client> = mutableListOf()

    fun addClient( client: Client){
        clientsList.add(client)
    }
    fun deleteClient(id: Int){
        clientsList.removeIf { it.id == id }
    }
    fun getClient(id: Int): Client{
        return clientsList.find { it.id == id }?:throw NotFoundException("no found client with id: $id")
    }
    fun updateClient(client: Client){
        clientsList.indexOfFirst { it.id == client.id }
            .takeIf { it != -1 }
            ?.let {clientsList[it] = client}
            ?:throw NotFoundException("no found client with id: $client")
    }
    fun getAllClients():List<Client>{
        return clientsList.toList()
    }
}