package domain.usecase.employeeUseCase

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.AdminRepository
import org.example.domain.usecase.employeeUseCase.GetAllEmployeesUseCase
import org.example.entity.Employee
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class GetAllEmployeesUseCaseTest {
    private lateinit var getAllEmployeesUseCase: GetAllEmployeesUseCase
    private lateinit var adminRepository: AdminRepository

    @BeforeEach
    fun setUp() {
        adminRepository = mockk(relaxed = true)
        getAllEmployeesUseCase = GetAllEmployeesUseCase(adminRepository)
    }

    @Test
    fun `should return all employees`() {
        //given
        val employees = listOf(
            Employee(1, "employeeName1", "employeepassword1", 0.0),
            Employee(2, "employeeName2", "employeepassword2", 0.0),
        )
        every { adminRepository.getAllEmployees() } returns employees

        //when
        val result = getAllEmployeesUseCase()

        //then
        assertEquals(employees, result)
        verify { adminRepository.getAllEmployees() }
    }
}