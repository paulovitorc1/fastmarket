package com.fastmarket.fastmarket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fastmarket.fastmarket.model.Acesso;
import com.fastmarket.fastmarket.services.AcessoService;

@Controller
@RequestMapping
public class AcessoController {

    @Autowired
    private AcessoService acessoService;

    @PostMapping("/salvar-acesso")
    public Acesso criarAcesso(@RequestBody Acesso acesso) {
        return acessoService.criarAcesso(acesso);
    }

}
