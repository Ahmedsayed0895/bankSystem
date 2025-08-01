package org.example.di

import org.example.data.datasource.memory.AdminDataSource
import org.example.data.datasource.memory.ClientDataSource
import org.example.data.datasource.memory.EmployeeDataSource
import org.example.data.repository.AdminRepositoryImpl
import org.example.data.repository.ClientRepositoryImpl
import org.example.data.repository.EmployeeRepositoryImpl
import org.example.domain.repository.AdminRepository
import org.example.domain.repository.ClientRepository
import org.example.domain.repository.EmployeeRepository
import org.example.domain.usecase.AddNewClientUseCase
import org.example.domain.usecase.AddNewEmployeeUseCase
import org.example.domain.usecase.CheckBalanceUseCase
import org.example.domain.usecase.DeleteClientUseCase
import org.example.domain.usecase.DeleteEmployeeUseCase
import org.example.domain.usecase.DepositUseCase
import org.example.domain.usecase.EditClientInfoUseCase
import org.example.domain.usecase.EditEmployeeInfoUseCase
import org.example.domain.usecase.GetAllClientsUseCase
import org.example.domain.usecase.GetAllEmployeesUseCase
import org.example.domain.usecase.GetClientByIdUseCase
import org.example.domain.usecase.GetEmployeeByIdUseCase
import org.example.domain.usecase.TransferMoneyUseCase
import org.example.domain.usecase.WithDrawUseCase
import org.example.presentation.ClientUi
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::AddNewClientUseCase)
    singleOf(::AddNewEmployeeUseCase)
    singleOf(::CheckBalanceUseCase)
    singleOf(::DeleteClientUseCase)
    singleOf(::DeleteEmployeeUseCase)
    singleOf(::DepositUseCase)
    singleOf(::EditClientInfoUseCase)
    singleOf(::EditEmployeeInfoUseCase)
    singleOf(::GetAllClientsUseCase)
    singleOf(::GetAllEmployeesUseCase)
    singleOf(::GetClientByIdUseCase)
    singleOf(::GetEmployeeByIdUseCase)
    singleOf(::TransferMoneyUseCase)
    singleOf(::WithDrawUseCase)
}

val repositoryModule = module {
    single<AdminRepository>{AdminRepositoryImpl(get())}
    single<ClientRepository>{ ClientRepositoryImpl(get())}
    single<EmployeeRepository>{ EmployeeRepositoryImpl(get()) }
}

val memoryDataSourceModule = module {
    singleOf(::AdminDataSource)
    singleOf(::ClientDataSource)
    singleOf(::EmployeeDataSource)
}

val uiModule = module {
    singleOf(::ClientUi)
}