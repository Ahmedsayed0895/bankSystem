package org.example.domain.usecase.transactionsUsecas

import org.example.domain.repository.ClientRepository

class CheckBalanceUseCase(val clientRepository: ClientRepository) {
    operator fun invoke(id:Int)= clientRepository.checkBalance(id = id)
}