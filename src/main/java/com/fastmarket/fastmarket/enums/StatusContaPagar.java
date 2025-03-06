package com.fastmarket.fastmarket.enums;

public enum StatusContaPagar {

    COBRANCA("Pagar"),
    VENCIDA("Vencida"),
    ABERA("Aberta"),
    QUITADA("Quitada"),
    RENEGOCIADA("Renegociada");

    private String descricao;

    private StatusContaPagar(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

}
