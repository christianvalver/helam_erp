/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author chrisvv
 */
@Entity
public class TarifaDetalle implements Serializable,Comparable<TarifaDetalle> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    private BienEconomico bien;
    @NotNull
    @ManyToOne
    private Tarifa tarifa;
    @Column(columnDefinition = "decimal(20,2) default 0")
    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaDetalle)) {
            return false;
        }
        TarifaDetalle other = (TarifaDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vipsoft.erp.abinadi.dominio.TarfiaDetalle[ id=" + id + " ]";
    }

    @Override
    public int compareTo(TarifaDetalle o) {
        int retorno=tarifa.compareTo(o.tarifa);
        if(retorno==0){
            retorno=bien.compareTo(o.bien);
        }
        return retorno;
    }

    public BienEconomico getBien() {
        return bien;
    }

    public void setBien(BienEconomico bien) {
        this.bien = bien;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    
    
}
