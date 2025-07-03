package com.fastmarket.fastmarket.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fastmarket.fastmarket.model.Acesso;
import com.fastmarket.fastmarket.repositories.AcessoRepository;

@Service
public class AcessoService {

    @Autowired
    private AcessoRepository acessoRepository;

    /*
     * public List<Acesso> obterTodosAcessos() {
     * return acessoRepository.findAll();
     * }
     * 
     * public Optional<Acesso> obterAcessoPorId(Long id) {
     * Optional<Acesso> acesso = Optional.ofNullable(acessoRepository.findById(id)
     * .orElseThrow(() -> new
     * ResourceNotFoundException("Recurso não encontrado.")));
     * return acesso;
     * }
     */
    public List<Acesso> listarAcessos() {
        return acessoRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Acesso criarAcesso(Acesso acesso) {
        return acessoRepository.save(acesso);
    }

    public Optional<Acesso> listarAcessoPorId(Long id) {
        Optional<Acesso> acessoPorId = acessoRepository.findById(id);
        return acessoPorId;
    }

    public String deletarAcesso(Long id) {
        if (!acessoRepository.existsById(id)) {
            throw new EntityNotFoundException("Acesso com ID " + id + " não encontrado.");
        }
        acessoRepository.deleteById(id);
        return "Acesso com ID " + id + " deletado com sucesso.";

    }


    /* Ajustar acesso */
    public Acesso editarAcesso(Acesso acesso, Long id) {

        Acesso acessoAEditar = acessoRepository.findById(id).orElse(null);

        acessoAEditar.setDescricao(acesso.getDescricao());

        acessoRepository.save(acessoAEditar);

        return acessoAEditar;

    }

}
