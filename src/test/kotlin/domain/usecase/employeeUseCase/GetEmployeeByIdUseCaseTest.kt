package domain.usecase.employeeUseCase

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.AdminRepository
import org.example.domain.usecase.employeeUseCase.GetEmployeeByIdUseCase
import org.example.entity.Employee
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

class GetEmployeeByIdUseCaseTest {
    private lateinit var adminRepository: AdminRepository
    private lateinit var getEmployeeByIdUseCase: GetEmployeeByIdUseCase

    @BeforeEach
    fun setUp() {
        adminRepository = mockk(relaxed = true)
        getEmployeeByIdUseCase = GetEmployeeByIdUseCase(adminRepository)
    }

    @Test
    fun `get employee should return employee from successfully`() {
        //given
        val id = 1
        val employee = Employee(id, "ahmed", "123", 0.0)
        every { adminRepository.getEmployeeById(id) } returns employee

        //when
        val result = getEmployeeByIdUseCase(id)

        //then
        verify { adminRepository.getEmployeeById(id) }
        assertEquals(employee, result)

    }

}