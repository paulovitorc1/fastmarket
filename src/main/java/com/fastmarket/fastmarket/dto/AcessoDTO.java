package com.fastmarket.fastmarket.dto;

import com.fastmarket.fastmarket.model.Acesso;

public class AcessoDTO {

    private Long id;
    private String descricao;

    public AcessoDTO() {
    }

    public AcessoDTO(Acesso acesso) {
        this.id = acesso.getId();
        this.descricao = acesso.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
