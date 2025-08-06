package domain.usecase.clientUseCase

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.EmployeeRepository
import org.example.domain.usecase.clientUseCase.GetAllClientsUseCase
import org.example.entity.Client
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetAllClientsUseCaseTest {
    private lateinit var getAllClientsUseCase: GetAllClientsUseCase
    private lateinit var employeeRepository: EmployeeRepository

    @BeforeEach
    fun setUp() {
        employeeRepository = mockk(relaxed = true)
        getAllClientsUseCase = GetAllClientsUseCase(employeeRepository)
    }

    @Test
    fun `get all clients successfully`() {
        //given
        every { getAllClientsUseCase() } returns listOf(
            Client(
                id = 1,
                name = "name",
                password = "password",
                balance = 0.0
            ),
            Client(
                id = 2,
                name = "name",
                password = "password",
                balance = 0.0
            )
        )
        //when
        getAllClientsUseCase()
        //then
        verify { employeeRepository.getAllClients() }
    }


}