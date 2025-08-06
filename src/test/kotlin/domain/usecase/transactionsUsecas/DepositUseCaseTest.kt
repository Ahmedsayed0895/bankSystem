package domain.usecase.transactionsUsecas

import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.ClientRepository
import org.example.domain.usecase.transactionsUsecas.DepositUseCase
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class DepositUseCaseTest {
    private lateinit var depositUseCase: DepositUseCase
    private lateinit var clientRepository: ClientRepository

    @BeforeEach
    fun setUp() {
        clientRepository = mockk(relaxed = true)
        depositUseCase = DepositUseCase(clientRepository)
    }

    @Test
    fun `should deposit amount successfully`() {
        //given
        val id = 1
        val amount = 1000.0

        //when
        depositUseCase(id, amount)

        //then
        verify { clientRepository.deposit(id, amount) }
    }

}