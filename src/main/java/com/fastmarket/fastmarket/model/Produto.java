package com.fastmarket.fastmarket.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1)
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String tipo_unidade;
    private String nome;

    @Column(columnDefinition = "TEXT", length = 2000)
    private String descricao;

    /* private NotaItemProduto nota_item_produto; */ // ADD GETTERS AND SETTERS

    private Boolean ativo = Boolean.TRUE;
    private Double peso;
    private Double largura;
    private Double altura;
    private Double profundidade;
    private BigDecimal valor_venda = BigDecimal.ZERO;
    private Integer qtd_estoque = 0;
    private Integer qtde_alerta_estoque = 0;
    private String link_youtube;
    private Boolean alerta_qtd_estoque = Boolean.FALSE;
    private Integer qtd_clique = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_unidade() {
        return tipo_unidade;
    }

    public void setTipo_unidade(String tipo_unidade) {
        this.tipo_unidade = tipo_unidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void setQtd_estoque(Integer qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public void setQtde_alerta_estoque(Integer qtde_alerta_estoque) {
        this.qtde_alerta_estoque = qtde_alerta_estoque;
    }

    public void setQtd_clique(Integer qtd_clique) {
        this.qtd_clique = qtd_clique;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(Double profundidade) {
        this.profundidade = profundidade;
    }

    public BigDecimal getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(BigDecimal valor_venda) {
        this.valor_venda = valor_venda;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public int getQtde_alerta_estoque() {
        return qtde_alerta_estoque;
    }

    public void setQtde_alerta_estoque(int qtde_alerta_estoque) {
        this.qtde_alerta_estoque = qtde_alerta_estoque;
    }

    public String getLink_youtube() {
        return link_youtube;
    }

    public void setLink_youtube(String link_youtube) {
        this.link_youtube = link_youtube;
    }

    public Boolean getAlerta_qtd_estoque() {
        return alerta_qtd_estoque;
    }

    public void setAlerta_qtd_estoque(Boolean alerta_qtd_estoque) {
        this.alerta_qtd_estoque = alerta_qtd_estoque;
    }

    public int getQtd_clique() {
        return qtd_clique;
    }

    public void setQtd_clique(int qtd_clique) {
        this.qtd_clique = qtd_clique;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
