package domain.usecase.employeeUseCase

import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.AdminRepository
import org.example.domain.usecase.employeeUseCase.EditEmployeeInfoUseCase
import org.example.entity.Employee
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class EditEmployeeInfoUseCaseTest {
    private lateinit var adminRepository: AdminRepository
    private lateinit var editEmployeeInfoUseCase: EditEmployeeInfoUseCase

    @BeforeEach
    fun setUp() {
        adminRepository = mockk(relaxed = true)
        editEmployeeInfoUseCase = EditEmployeeInfoUseCase(adminRepository)
    }

    @Test
    fun `should edit employee info`() {

        //given
        val id = 1
        val employee = Employee(id, "ahmed", "123", 0.0)

        //when
        editEmployeeInfoUseCase(employee)

        //then
        verify { adminRepository.editEmployeeInfo(employee) }
    }

}