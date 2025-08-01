package org.example

import org.example.di.memoryDataSourceModule
import org.example.di.repositoryModule
import org.example.di.uiModule
import org.example.di.useCaseModule
import org.example.presentation.ClientUi
import org.koin.core.context.GlobalContext.get
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.getKoin

fun main() {
    startKoin {
        modules(
            useCaseModule,
            repositoryModule,
            memoryDataSourceModule,
            uiModule
        )
        val clientUi: ClientUi = getKoin().get()
        clientUi.startSystem()
    }
}