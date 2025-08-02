package org.example.di

import org.example.data.datasource.memory.AdminDataSource
import org.example.data.datasource.memory.ClientDataSource
import org.example.data.datasource.memory.EmployeeDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val memoryDataSourceModule = module {
    singleOf(::AdminDataSource)
    singleOf(::ClientDataSource)
    singleOf(::EmployeeDataSource)
}