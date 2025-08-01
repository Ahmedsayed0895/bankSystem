package org.example.domain.usecase

import org.example.domain.repository.ClientRepository

class WithDrawUseCase(val clientRepository: ClientRepository) {
    operator fun invoke(id:Int, amount: Double) = clientRepository.withdraw(id = id, amount = amount)
}