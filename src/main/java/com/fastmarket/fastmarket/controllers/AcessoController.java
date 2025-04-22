package com.fastmarket.fastmarket.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastmarket.fastmarket.model.Acesso;
import com.fastmarket.fastmarket.services.AcessoService;

@Controller
@RequestMapping
public class AcessoController {

    @Autowired
    private AcessoService acessoService;

    @ResponseBody
    @PostMapping("**/salvar-acesso")
    public ResponseEntity<Acesso> criarAcesso(@RequestBody Acesso acesso) {
        Acesso acessoSalvo = acessoService.criarAcesso(acesso);
        return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("**/listar-acessos")
    public ResponseEntity<List<Acesso>> listarAcessos() {
        List<Acesso> listaAcessos = acessoService.listarAcessos();
        return ResponseEntity.ok(listaAcessos);
    }

    @ResponseBody
    @GetMapping("**/listar-acesso-por-id/{id}")
    public ResponseEntity<Optional<Acesso>> listarAcessoPorId(@PathVariable Long id) {
        Optional<Acesso> acessoPorId = acessoService.listarAcessoPorId(id);
        return ResponseEntity.ok(acessoPorId);
    }

    @DeleteMapping("**/deletar-acesso-por-id/{id}")
    public ResponseEntity<String> deleteAcessoPorId(@PathVariable Long id) {
        String mensagem = acessoService.deletarAcesso(id);
        return ResponseEntity.ok(mensagem);
    }

    @PutMapping("**/editar-acesso/{id}")
    public ResponseEntity<Void> atualizarAcesso(@PathVariable Long id, @RequestBody Acesso acesso) {
        acessoService.editarAcesso(acesso, id);
        return ResponseEntity.noContent().build();
    }
}
