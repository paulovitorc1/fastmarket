package com.fastmarket.fastmarket.services;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Acesso criarAcesso(Acesso acesso) {
        return acessoRepository.save(acesso);

    }

}
