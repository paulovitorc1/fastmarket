package com.fastmarket.fastmarket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fastmarket.fastmarket.model.Acesso;
import com.fastmarket.fastmarket.repositories.AcessoRepository;

@SpringBootTest(classes = FastmarketApplication.class)
public class FastmarketApplicationTests {

	@Autowired
	private AcessoRepository acessoRepository;

	@Test
	public void testeCadastrarAcesso() {

		Acesso acesso = new Acesso();

		acesso.setDescricao("ROLE_ADMIN");

		acessoRepository.save(acesso);

	}


}
