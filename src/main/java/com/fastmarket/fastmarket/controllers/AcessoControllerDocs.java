package com.fastmarket.fastmarket.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fastmarket.fastmarket.dto.AcessoDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface AcessoControllerDocs {

    @Operation(summary = "Listar todos os acessos", description = "Retorna uma lista com todos os acessos cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de acessos retornada com sucesso."),
            @ApiResponse(responseCode = "500", description = "Erro interno ao listar os acessos.")
    })
    public ResponseEntity<List<AcessoDTO>> listar();

    @Operation(summary = "Buscar acesso por ID", description = "Retorna os dados de um acesso específico com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Acesso encontrado."),
            @ApiResponse(responseCode = "404", description = "Acesso não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar o acesso.")
    })
    public AcessoDTO listarAcessoPorId(@PathVariable Long id);

    @Operation(summary = "Cadastrar um novo acesso", description = "Cria e retorna um novo objeto de acesso com base nos dados enviados no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Acesso cadastrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro de validação no cadastro do acesso."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor. Tente novamente mais tarde.")

    })
    public ResponseEntity<AcessoDTO> salvar(@RequestBody AcessoDTO acesso);

    @Operation(summary = "Atualizar um acesso", description = "Atualiza os dados de um acesso existente com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Acesso atualizado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro nos dados fornecidos para atualização."),
            @ApiResponse(responseCode = "404", description = "Acesso não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno ao atualizar o acesso.")
    })
    public ResponseEntity<AcessoDTO> atualizarAcesso(@PathVariable Long id, @RequestBody AcessoDTO dto);

    @Operation(summary = "Excluir um acesso por ID", description = "Remove o acesso do sistema com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Acesso excluído com sucesso."),
            @ApiResponse(responseCode = "404", description = "Acesso não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro ao tentar excluir o acesso.")
    })
    public ResponseEntity<String> deleteAcessoPorId(@PathVariable Long id);

}
