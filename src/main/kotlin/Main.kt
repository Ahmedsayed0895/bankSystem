package org.example

import org.example.di.systemModules
import org.example.presentation.SystemUi
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.getKoin

fun main() {
    startKoin {
        modules(systemModules)
    }
    val systemUi: SystemUi = getKoin().get()
    systemUi.start()
}