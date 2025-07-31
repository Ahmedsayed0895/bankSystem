package org.example

import org.example.di.memoryDataSourceModule
import org.example.di.repositoryModule
import org.example.di.useCaseModule
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(
            useCaseModule,
            repositoryModule,
            memoryDataSourceModule
        )
    }
}