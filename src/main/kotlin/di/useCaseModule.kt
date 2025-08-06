package org.example.di

import org.example.domain.usecase.authUseCase.LoginUseCase
import org.example.domain.usecase.clientUseCase.*
import org.example.domain.usecase.employeeUseCase.*
import org.example.domain.usecase.transactionsUsecas.CheckBalanceUseCase
import org.example.domain.usecase.transactionsUsecas.DepositUseCase
import org.example.domain.usecase.transactionsUsecas.TransferMoneyUseCase
import org.example.domain.usecase.transactionsUsecas.WithDrawUseCase
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
    singleOf(::LoginUseCase)
}

