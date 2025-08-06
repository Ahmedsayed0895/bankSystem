package domain.usecase.authUseCase

import io.mockk.mockk
import io.mockk.verify
import org.example.domain.repository.AuthRepository
import org.example.domain.usecase.authUseCase.LoginUseCase
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LoginUseCaseTest {
    private lateinit var loginUseCase: LoginUseCase
    private lateinit var authRepository: AuthRepository

    @BeforeEach
    fun setUp() {
        authRepository = mockk(relaxed = true)
        loginUseCase = LoginUseCase(authRepository)
    }

    @Test
    fun `login use case successfully`() {
        //given
        val username = "Ahmed"
        val password = "123"
        //when
        loginUseCase(username, password)
        //then
        verify { authRepository.login(username, password) }
    }
}