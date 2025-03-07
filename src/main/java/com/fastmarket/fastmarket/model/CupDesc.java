package com.fastmarket.fastmarket.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cup_desc")
@SequenceGenerator(name = "seq_cup_desc", sequenceName = "seq_cup_desc", allocationSize = 1, initialValue = 1)
public class CupDesc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cup_desc")
    private Long id;
    private String cod_desc;
    private BigDecimal valor_real_total;
    private BigDecimal valor_porcent_desconto;

    @Temporal(TemporalType.DATE)
    private Date data_validade_cupom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod_desc() {
        return cod_desc;
    }

    public void setCod_desc(String cod_desc) {
        this.cod_desc = cod_desc;
    }

    public BigDecimal getValor_real_total() {
        return valor_real_total;
    }

    public void setValor_real_total(BigDecimal valor_real_total) {
        this.valor_real_total = valor_real_total;
    }

    public BigDecimal getValor_porcent_desconto() {
        return valor_porcent_desconto;
    }

    public void setValor_porcent_desconto(BigDecimal valor_porcent_desconto) {
        this.valor_porcent_desconto = valor_porcent_desconto;
    }

    public Date getData_validade_cupom() {
        return data_validade_cupom;
    }

    public void setData_validade_cupom(Date data_validade_cupom) {
        this.data_validade_cupom = data_validade_cupom;
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
        CupDesc other = (CupDesc) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
