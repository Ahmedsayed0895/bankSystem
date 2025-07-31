package org.example.domain.usecase

import org.example.domain.repository.ClientRepository

class TransferMoneyUseCase(val clientRepository: ClientRepository) {
    fun invoke(id: Int, amount: Double, receiverId:Int) = clientRepository.transferMoney(id = id, amount = amount,receiverId = receiverId)
}