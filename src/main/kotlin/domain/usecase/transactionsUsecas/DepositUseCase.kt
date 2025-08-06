package org.example.domain.usecase.transactionsUsecas

import org.example.domain.repository.ClientRepository

class DepositUseCase(val clientRepository: ClientRepository) {
    operator fun invoke(id:Int, amount: Double) = clientRepository.deposit(id = id, amount = amount)
}