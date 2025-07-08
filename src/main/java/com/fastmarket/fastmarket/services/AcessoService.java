package com.fastmarket.fastmarket.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fastmarket.fastmarket.model.Acesso;
import com.fastmarket.fastmarket.repositories.AcessoRepository;

@Service
public class AcessoService {

    @Autowired
    private AcessoRepository acesso_repository;

    public List<Acesso> listar_acessos() {
        return acesso_repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Acesso criar_acesso(Acesso acesso) {
        return acesso_repository.save(acesso);
    }

    public Acesso listar_acesso_por_id(Long id) {
        return acesso_repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Acesso com ID " + id + " não encontrado."));
    }

    public String deletar_acesso(Long id) {
        if (!acesso_repository.existsById(id)) {
            throw new EntityNotFoundException("Acesso com ID " + id + " não encontrado.");
        }
        acesso_repository.deleteById(id);
        return "Acesso com ID " + id + " deletado com sucesso.";
    }

    public Acesso editar_acesso(Acesso acesso, Long id) {
        Acesso acesso_a_editar = acesso_repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Acesso com ID " + id + " não encontrado."));
        acesso_a_editar.setDescricao(acesso.getDescricao());
        acesso_repository.save(acesso_a_editar);
        return acesso_a_editar;
    }

}
