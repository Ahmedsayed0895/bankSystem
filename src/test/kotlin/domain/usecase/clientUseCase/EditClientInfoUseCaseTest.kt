package domain.usecase.clientUseCase

import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.EmployeeRepository
import org.example.domain.usecase.clientUseCase.EditClientInfoUseCase
import org.example.entity.Client
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class EditClientInfoUseCaseTest {
    private lateinit var employeeRepository: EmployeeRepository
    private lateinit var editClientInfoUseCase: EditClientInfoUseCase

    @BeforeEach
    fun setUp() {
        employeeRepository = mockk(relaxed = true)
        editClientInfoUseCase = EditClientInfoUseCase(employeeRepository)
    }

    @Test
    fun `edit client info should edit client successfully`() {
        //given
        val client = Client(1, "ahmed", "123", 0.0)
        //when
        editClientInfoUseCase(client)
        //then
        verify { employeeRepository.editClientInfo(client) }
    }
}