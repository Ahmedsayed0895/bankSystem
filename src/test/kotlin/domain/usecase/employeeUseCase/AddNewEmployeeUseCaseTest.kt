package domain.usecase.employeeUseCase

import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.AdminRepository
import org.example.domain.usecase.employeeUseCase.AddNewEmployeeUseCase
import org.example.entity.Employee
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class AddNewEmployeeUseCaseTest {
    private lateinit var adminRepository: AdminRepository
    private lateinit var addNewEmployeeUseCase: AddNewEmployeeUseCase

    @BeforeEach
    fun setUp() {
        adminRepository = mockk(relaxed = true)
        addNewEmployeeUseCase = AddNewEmployeeUseCase(adminRepository)
    }

    @Test
    fun `should add new employee successfully`() {
        //given
        val employee = Employee(1, "ahmed", "123", 0.0)
        //when
        addNewEmployeeUseCase(employee)
        //then
        verify { adminRepository.addNewEmployee(employee) }
    }

}