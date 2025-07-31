package org.example.data.datasource.memory

import org.example.domain.exceptions.NotFoundException
import org.example.entity.Admin


class AdminDataSource {

    val adminsList= mutableListOf(
        Admin(
            id = 1,
            name= "Ahmed",
            password= "123",
            salary= 100_000.0,)
    )
    fun addAdmin(admin: Admin){
        adminsList.add(admin)
    }
    fun getAdmin(id:Int):Admin{
        return adminsList.find { it.id == id }?:throw NotFoundException("not found admin with id $id")
    }
    fun getAllAdmins():List<Admin>{
        return adminsList.toList()
    }
    fun deleteAdmin(id: Int){
        adminsList.removeIf { it.id == id }
    }

    fun updateAdmin(admin: Admin){
        adminsList.indexOfFirst { it.id == admin.id }
            .takeIf { it != -1 }
            ?.let { adminsList[it] = admin}
            ?:throw NotFoundException("not found admin with id ${admin.id}")

    }

}