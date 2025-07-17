package com.fastmarket.fastmarket.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastmarket.fastmarket.dto.AcessoDTO;
import com.fastmarket.fastmarket.model.Acesso;
import com.fastmarket.fastmarket.repositories.AcessoRepository;

@Service
public class AcessoService {

    @Autowired
    private AcessoRepository acesso_repository;

    public List<AcessoDTO> listar() {
        List<Acesso> acessos = acesso_repository.findAll();
        return acessos.stream()
                .sorted(Comparator.comparing(Acesso::getId))
                .map(AcessoDTO::new)
                .collect((Collectors.toList()));
    }

    public AcessoDTO salvar(AcessoDTO dto) {
        Acesso acesso = new Acesso();
        acesso.setDescricao(dto.getDescricao());
        acesso = acesso_repository.save(acesso);
        return new AcessoDTO(acesso);
    }

    public AcessoDTO listar_por_id(Long id) {
        Acesso acesso = acesso_repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Acesso com ID " + id + " não encontrado."));
        return new AcessoDTO(acesso);
    }

    public String deletar_acesso(Long id) {
        if (!acesso_repository.existsById(id)) {
            throw new EntityNotFoundException("Acesso com ID " + id + " não encontrado.");
        }
        acesso_repository.deleteById(id);
        return "Acesso com ID " + id + " deletado com sucesso.";
    }

    public AcessoDTO atualizar(Long id, AcessoDTO dto) {
        Acesso acesso = acesso_repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Acesso com ID " + id + " não encontrado."));
        acesso.setDescricao(dto.getDescricao());
        Acesso atualizado = acesso_repository.save(acesso);
        return new AcessoDTO(atualizado);
    }

}
