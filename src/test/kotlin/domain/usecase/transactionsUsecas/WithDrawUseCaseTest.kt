package domain.usecase.transactionsUsecas

import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.ClientRepository
import org.example.domain.usecase.transactionsUsecas.WithDrawUseCase
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class WithDrawUseCaseTest {
    private lateinit var withDrawUseCase: WithDrawUseCase
    private lateinit var clientRepository: ClientRepository

    @BeforeEach
    fun setUp() {
        clientRepository = mockk(relaxed = true)
        withDrawUseCase = WithDrawUseCase(clientRepository)
    }

    @Test
    fun `verify that withdraw executes successfully`() {
        //given
        val id = 1
        val amount = 1000.0

        //when
        withDrawUseCase(id, amount)

        //then
        verify { clientRepository.withdraw(id, amount) }
    }

}