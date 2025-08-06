package domain.usecase.clientUseCase

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.EmployeeRepository
import org.example.domain.usecase.clientUseCase.GetClientByIdUseCase
import org.example.entity.Client
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

class GetClientByIdUseCaseTest {
    private lateinit var getClientByIdUseCase: GetClientByIdUseCase
    private lateinit var employeeRepository: EmployeeRepository

    @BeforeEach
    fun setUp() {
        employeeRepository = mockk(relaxed = true)
        getClientByIdUseCase = GetClientByIdUseCase(employeeRepository)
    }

    @Test
    fun `get client successfully`() {
        //give
        val id = 1
        val client = Client(
            id, "client",
            password = "pass",
            balance = 0.0
        )
        every { employeeRepository.getClientById(id) } returns client
        //when
        val result = getClientByIdUseCase(id)
        //then
        verify { employeeRepository.getClientById(id) }
        assertEquals(result, client)
    }

}