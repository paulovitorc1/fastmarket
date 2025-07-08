package com.fastmarket.fastmarket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fastmarket.fastmarket.controllers.AcessoController;
import com.fastmarket.fastmarket.model.Acesso;
import com.fastmarket.fastmarket.repositories.AcessoRepository;

import junit.framework.TestCase;

@SpringBootTest(classes = FastmarketApplication.class)
public class FastmarketApplicationTests extends TestCase {

	@Autowired
	private AcessoRepository acessoRepository;

	@Autowired
	private AcessoController acessoController;

	@Test
	public void testeCadastrarAcesso() {

		Acesso acesso = new Acesso();

		acesso.setDescricao("ROLE_ADMIN");

		acessoController.criarAcesso(acesso);

	}



}
