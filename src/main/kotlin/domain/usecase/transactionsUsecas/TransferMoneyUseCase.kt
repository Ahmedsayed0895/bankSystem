package org.example.domain.usecase.transactionsUsecas

import org.example.domain.repository.ClientRepository

class TransferMoneyUseCase(val clientRepository: ClientRepository) {
    operator fun invoke(id: Int, amount: Double, receiverId:Int) = clientRepository.transferMoney(id = id, amount = amount,receiverId = receiverId)
}