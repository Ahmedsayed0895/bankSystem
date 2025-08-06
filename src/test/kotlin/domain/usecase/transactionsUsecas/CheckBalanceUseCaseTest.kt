package domain.usecase.transactionsUsecas

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.ClientRepository
import org.example.domain.usecase.transactionsUsecas.CheckBalanceUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class CheckBalanceUseCaseTest {

    private lateinit var checkBalanceUseCase: CheckBalanceUseCase
    private lateinit var clientRepository: ClientRepository

    @BeforeEach
    fun setUp() {
        clientRepository = mockk(relaxed = true)
        checkBalanceUseCase = CheckBalanceUseCase(clientRepository)
    }

    @Test
    fun `should return client balance successfully`() {
        //given
        val id = 1
        val balance = 1000.0
        every { clientRepository.checkBalance(id) } returns balance
        //when
        val result = checkBalanceUseCase(id)

        //then
        assertEquals(balance, result)
        verify { clientRepository.checkBalance(id) }
    }

}