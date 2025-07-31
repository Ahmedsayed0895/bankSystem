package org.example.data.datasource.memory

import org.example.domain.exceptions.NotFoundException
import org.example.entity.Employee

class EmployeeDataSource {
    val employeesList: MutableList<Employee> = mutableListOf()

    fun addEmployee(employee: Employee){
        employeesList.add(employee)
    }
    fun deleteEmployee(id:Int){
        employeesList.removeIf { it.id == id }
    }
    fun updateEmployee(employee: Employee){
        employeesList.indexOfFirst { it.id == employee.id }
            .takeIf { it != -1 }
            ?.let { employeesList[it] = employee }
            ?: throw NotFoundException("no found employee with id: $employee.id")
    }
    fun getEmployee(id:Int):Employee{
        return employeesList.find { it.id == id }?:throw NotFoundException("no found employee with id: $id")
    }
    fun getAllEmployees(): List<Employee>{
        return employeesList.toList()
    }

}
