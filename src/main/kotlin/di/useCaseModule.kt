package org.example.di

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
import org.example.domain.usecase.LoginUseCase
import org.example.domain.usecase.TransferMoneyUseCase
import org.example.domain.usecase.WithDrawUseCase
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

