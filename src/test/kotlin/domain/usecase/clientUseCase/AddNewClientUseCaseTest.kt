package domain.usecase.clientUseCase

import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.EmployeeRepository
import org.example.domain.usecase.clientUseCase.AddNewClientUseCase
import org.example.entity.Client
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class AddNewClientUseCaseTest {
    private lateinit var addNewClientUseCase: AddNewClientUseCase
    private lateinit var employeeRepository: EmployeeRepository

    @BeforeEach
    fun setUp() {
        employeeRepository = mockk(relaxed = true)
        addNewClientUseCase = AddNewClientUseCase(employeeRepository)
    }

    @Test
    fun `add new client successfully`() {
        //given
        val client = Client(
            id = 1,
            name = "name",
            password = "password",
            balance = 0.0,
        )

        //when
        addNewClientUseCase(client)

        //then
        verify { employeeRepository.addNewClient(client) }
    }

}