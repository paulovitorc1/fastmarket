package com.fastmarket.fastmarket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastmarket.fastmarket.model.Acesso;
import com.fastmarket.fastmarket.services.AcessoService;

@RestController
@RequestMapping(value = "/acesso")
public class AcessoController {

    @Autowired
    private AcessoService acessoService;

    @ResponseBody
    @PostMapping("/salvar")
    public ResponseEntity<Acesso> criarAcesso(@RequestBody Acesso acesso) {
        Acesso acessoSalvo = acessoService.criar_acesso(acesso);
        return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/listar")
    public ResponseEntity<List<Acesso>> listarAcessos() {
        List<Acesso> listaAcessos = acessoService.listar_acessos();
        return ResponseEntity.ok(listaAcessos);
    }

    @ResponseBody
    @GetMapping("/listar-por-id/{id}")
    public Acesso listarAcessoPorId(@PathVariable Long id) {
        return acessoService.listar_acesso_por_id(id);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteAcessoPorId(@PathVariable Long id) {
        String mensagem = acessoService.deletar_acesso(id);
        return ResponseEntity.ok(mensagem);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Void> atualizarAcesso(@PathVariable Long id, @RequestBody Acesso acesso) {
        acessoService.editar_acesso(acesso, id);
        return ResponseEntity.noContent().build();
    }
}
