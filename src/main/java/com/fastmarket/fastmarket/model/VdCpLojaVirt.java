package com.fastmarket.fastmarket.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vd_cp_loja_virt")
@SequenceGenerator(name = "seq_vd_cp_loja_virt", sequenceName = "seq_vd_cp_loja_virt", allocationSize = 1, initialValue = 1)
public class VdCpLojaVirt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "seq_vd_cp_loja_virt", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @ManyToOne(targetEntity = Endereco.class)
    @JoinColumn(name = "endereco_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_fk"))
    private Endereco endereco;

    private Endereco endereco_entrega;

    private Endereco endereco_cobranca;

    private BigDecimal valor_total;

    private BigDecimal valor_desconto;

    @ManyToOne(targetEntity = FormaPagamento.class)
    @JoinColumn(name = "forma_pagamento_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "forma_pagamento_fk"))
    private FormaPagamento forma_pagamento;

    @OneToOne
    @JoinColumn(name = "nota_fiscal_venda_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "nota_fiscal_venda_fk"))
    private NotaFiscalVenda nota_fiscal_venda;

    @ManyToOne(targetEntity = CupDesc.class)
    @JoinColumn(name = "cup_desc_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "cup_desc_fk"))
    private CupDesc cup_desc;

    private BigDecimal valor_frete;

    private Integer dias_entrega;

    private Date data_venda;

    private Date data_entrega;

    @ManyToOne
    @JoinColumn(name = "status_rastreio_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "status_rastreio_fk"))
    private StatusRastreio status_rastreio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco_entrega() {
        return endereco_entrega;
    }

    public void setEndereco_entrega(Endereco endereco_entrega) {
        this.endereco_entrega = endereco_entrega;
    }

    public Endereco getEndereco_cobranca() {
        return endereco_cobranca;
    }

    public void setEndereco_cobranca(Endereco endereco_cobranca) {
        this.endereco_cobranca = endereco_cobranca;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }

    public BigDecimal getValor_desconto() {
        return valor_desconto;
    }

    public void setValor_desconto(BigDecimal valor_desconto) {
        this.valor_desconto = valor_desconto;
    }

    public FormaPagamento getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(FormaPagamento forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public NotaFiscalVenda getNota_fiscal_venda() {
        return nota_fiscal_venda;
    }

    public void setNota_fiscal_venda(NotaFiscalVenda nota_fiscal_venda) {
        this.nota_fiscal_venda = nota_fiscal_venda;
    }

    public CupDesc getCup_desc() {
        return cup_desc;
    }

    public void setCup_desc(CupDesc cup_desc) {
        this.cup_desc = cup_desc;
    }

    public BigDecimal getValor_frete() {
        return valor_frete;
    }

    public void setValor_frete(BigDecimal valor_frete) {
        this.valor_frete = valor_frete;
    }

    public Integer getDias_entrega() {
        return dias_entrega;
    }

    public void setDias_entrega(Integer dias_entrega) {
        this.dias_entrega = dias_entrega;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    public StatusRastreio getStatus_rastreio() {
        return status_rastreio;
    }

    public void setStatus_rastreio(StatusRastreio status_rastreio) {
        this.status_rastreio = status_rastreio;
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
        VdCpLojaVirt other = (VdCpLojaVirt) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
