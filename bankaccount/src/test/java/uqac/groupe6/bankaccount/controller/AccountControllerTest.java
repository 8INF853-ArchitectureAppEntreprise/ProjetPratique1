package uqac.groupe6.bankaccount.controller;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import uqac.groupe6.bankaccount.persistance.AccountJpaEntity;
import uqac.groupe6.bankaccount.persistance.AccountJpaRepository;

@SpringBootTest
public class AccountControllerTest {
	@MockBean
	private AccountJpaRepository accountJpaRepository;

	@Autowired
	private MockMvc mvc;

	@BeforeAll
	public void setUp() {
		Mockito.doNothing().when(accountJpaRepository.save(any(AccountJpaEntity.class)));
	}

	public void createNewAccount() {

	}
}
