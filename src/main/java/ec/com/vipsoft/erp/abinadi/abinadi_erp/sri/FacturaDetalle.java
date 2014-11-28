/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.abinadi_erp.sri;

import ec.com.vipsoft.erp.abinadi.dominio.BienEconomico;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author chrisvv
 */
@Entity
public class FacturaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private BienEconomico bienEconomico;
    @Column(columnDefinition = "decimal(18,2) default 1")
    private BigDecimal cantidad;
    @Column(columnDefinition = "decimal(18,2) default 0")
    private BigDecimal precioUnitario;
    @Column(columnDefinition = "decimal(18,2) default 0")
    private BigDecimal descuento;
    @Column(columnDefinition = "decimal(18,2) default 0")
    private BigDecimal precioTotal;
    private Integer particionamineto;

    public BienEconomico getBienEconomico() {
        return bienEconomico;
    }

    public void setBienEconomico(BienEconomico bienEconomico) {
        this.bienEconomico = bienEconomico;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Integer getParticionamineto() {
        return particionamineto;
    }

    public void setParticionamineto(Integer particionamineto) {
        this.particionamineto = particionamineto;
    }
    
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
        if (!(object instanceof FacturaDetalle)) {
            return false;
        }
        FacturaDetalle other = (FacturaDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vipsoft.erp.abinadi.abinadi_erp.sri.FacturaDetalle[ id=" + id + " ]";
    }
    
}
