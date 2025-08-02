package org.example.di

import org.example.data.repository.AdminRepositoryImpl
import org.example.data.repository.AuthRepositoryImpl
import org.example.data.repository.ClientRepositoryImpl
import org.example.data.repository.EmployeeRepositoryImpl
import org.example.domain.repository.AdminRepository
import org.example.domain.repository.AuthRepository
import org.example.domain.repository.ClientRepository
import org.example.domain.repository.EmployeeRepository
import org.koin.dsl.module


val repositoryModule = module {
    single<AdminRepository>{AdminRepositoryImpl(get())}
    single<ClientRepository>{ ClientRepositoryImpl(get())}
    single<EmployeeRepository>{ EmployeeRepositoryImpl(get()) }
    single<AuthRepository>{ AuthRepositoryImpl(get(),get (), get()) }
}
