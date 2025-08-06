package domain.usecase.transactionsUsecas

import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.ClientRepository
import org.example.domain.usecase.transactionsUsecas.TransferMoneyUseCase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TransferMoneyUseCaseTest {
    private lateinit var transferMoneyUseCase: TransferMoneyUseCase
    private lateinit var clientRepository: ClientRepository

    @BeforeEach
    fun setUp() {
        clientRepository = mockk(relaxed = true)
        transferMoneyUseCase = TransferMoneyUseCase(clientRepository)
    }

    @Test
    fun `verify that transferMoneyUseCase executes successfully`() {
        //given
        val id = 1
        val receiverId = 2
        val amount = 1000.0

        //when
        transferMoneyUseCase(id, amount, receiverId)

        //them
        verify { clientRepository.transferMoney(id, amount, receiverId) }
    }

}