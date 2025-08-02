package org.example.di

import org.example.presentation.AdminUi
import org.example.presentation.ClientUi
import org.example.presentation.EmployeeUi
import org.example.presentation.SystemUi
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import kotlin.math.sin


val uiModule = module {
    singleOf(::SystemUi)
    singleOf(::AdminUi)
    singleOf(::EmployeeUi)
    singleOf(::ClientUi)
}