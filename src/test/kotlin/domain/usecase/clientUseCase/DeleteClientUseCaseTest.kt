package domain.usecase.clientUseCase

import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.EmployeeRepository
import org.example.domain.usecase.clientUseCase.DeleteClientUseCase
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class DeleteClientUseCaseTest {
    private lateinit var employeeRepository: EmployeeRepository
    private lateinit var deleteClientUseCase: DeleteClientUseCase

    @BeforeEach
    fun setUp() {
        employeeRepository = mockk(relaxed = true)
        deleteClientUseCase = DeleteClientUseCase(employeeRepository)
    }

    @Test
    fun `delete client should deleted successfully`() {
        //given
        val id = 1
        //when
        deleteClientUseCase(id)
        //then
        verify { employeeRepository.deleteClient(id) }
    }
}