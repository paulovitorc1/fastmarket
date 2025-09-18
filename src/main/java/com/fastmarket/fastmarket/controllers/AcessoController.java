package com.fastmarket.fastmarket.controllers;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

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

import com.fastmarket.fastmarket.dto.AcessoDTO;
import com.fastmarket.fastmarket.services.AcessoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/acesso")
@Tag(name = "Acesso")
public class AcessoController implements AcessoControllerDocs {

    @Autowired
    private AcessoService acessoService;

    @ResponseBody
    @PostMapping("")
    public ResponseEntity<AcessoDTO> salvar(@RequestBody AcessoDTO acesso) {
        AcessoDTO acessoSalvo = acessoService.salvar(acesso);
        return new ResponseEntity<AcessoDTO>(acessoSalvo, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("")
    public ResponseEntity<List<AcessoDTO>> listar() {
        List<AcessoDTO> listaAcessos = acessoService.listar();
        return ResponseEntity.ok(listaAcessos);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public AcessoDTO listarAcessoPorId(@PathVariable Long id) {
        return acessoService.listar_por_id(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAcessoPorId(@PathVariable Long id) {
        String mensagem = acessoService.deletar_acesso(id);
        return ResponseEntity.ok(mensagem);
    }


    @PutMapping("/{id}")
    public ResponseEntity<AcessoDTO> atualizarAcesso(@PathVariable Long id, @RequestBody AcessoDTO dto) {
        return ResponseEntity.ok(acessoService.atualizar(id, dto));
    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            switch (statusCode) {
                case 400:
                    return "400";
                case 404:
                    return "404";
                case 403:
                    return "403";
                case 500:
                    return "500";
                default:
                    return "error";
            }
        }
        return "error";
    }
}
