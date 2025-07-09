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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/acesso")
public class AcessoController {

    @Autowired
    private AcessoService acessoService;

    @Operation(summary = "Cadastrar um novo acesso", description = "Cria e retorna um novo objeto de acesso com base nos dados enviados no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Acesso cadastrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro de validação no cadastro do acesso."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor. Tente novamente mais tarde.")

    })
    @ResponseBody
    @PostMapping("")
    public ResponseEntity<Acesso> criarAcesso(@RequestBody Acesso acesso) {
        Acesso acessoSalvo = acessoService.criar_acesso(acesso);
        return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
    }

    @Operation(summary = "Listar todos os acessos", description = "Retorna uma lista com todos os acessos cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de acessos retornada com sucesso."),
            @ApiResponse(responseCode = "500", description = "Erro interno ao listar os acessos.")
    })
    @ResponseBody
    @GetMapping("")
    public ResponseEntity<List<Acesso>> listarAcessos() {
        List<Acesso> listaAcessos = acessoService.listar_acessos();
        return ResponseEntity.ok(listaAcessos);
    }

    @Operation(summary = "Buscar acesso por ID", description = "Retorna os dados de um acesso específico com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Acesso encontrado."),
            @ApiResponse(responseCode = "404", description = "Acesso não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar o acesso.")
    })
    @ResponseBody
    @GetMapping("/{id}")
    public Acesso listarAcessoPorId(@PathVariable Long id) {
        return acessoService.listar_acesso_por_id(id);
    }

    @Operation(summary = "Excluir um acesso por ID", description = "Remove o acesso do sistema com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Acesso excluído com sucesso."),
            @ApiResponse(responseCode = "404", description = "Acesso não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro ao tentar excluir o acesso.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAcessoPorId(@PathVariable Long id) {
        String mensagem = acessoService.deletar_acesso(id);
        return ResponseEntity.ok(mensagem);
    }

    @Operation(summary = "Atualizar um acesso", description = "Atualiza os dados de um acesso existente com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Acesso atualizado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro nos dados fornecidos para atualização."),
            @ApiResponse(responseCode = "404", description = "Acesso não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno ao atualizar o acesso.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarAcesso(@PathVariable Long id, @RequestBody Acesso acesso) {
        acessoService.editar_acesso(acesso, id);
        return ResponseEntity.noContent().build();
    }
}
