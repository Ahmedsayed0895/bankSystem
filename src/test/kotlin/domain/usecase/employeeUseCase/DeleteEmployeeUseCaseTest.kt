package domain.usecase.employeeUseCase

import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.AdminRepository
import org.example.domain.usecase.employeeUseCase.DeleteEmployeeUseCase
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class DeleteEmployeeUseCaseTest {
    private lateinit var deleteEmployeeUseCase: DeleteEmployeeUseCase
    private lateinit var adminRepository: AdminRepository

    @BeforeEach
    fun setUp() {
        adminRepository = mockk(relaxed = true)
        deleteEmployeeUseCase = DeleteEmployeeUseCase(adminRepository)
    }

    @Test
    fun `should delete employee by id`() {
        //given
        val id = 1
        //when
        deleteEmployeeUseCase(id)
        //then
        verify { adminRepository.deleteEmployee(id) }
    }
}