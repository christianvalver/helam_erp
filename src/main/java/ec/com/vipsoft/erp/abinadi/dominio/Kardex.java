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
public class Kardex implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull   
    @ManyToOne
    protected Producto producto;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal existencia;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal valoracion;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal nivelMinimo;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal nivelMaximo;
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public BigDecimal getExistencia() {
        return existencia;
    }

    public void setExistencia(BigDecimal existencia) {
        this.existencia = existencia;
    }

    public BigDecimal getValoracion() {
        return valoracion;
    }

    public void setValoracion(BigDecimal valoracion) {
        this.valoracion = valoracion;
    }

    public BigDecimal getNivelMinimo() {
        return nivelMinimo;
    }

    public void setNivelMinimo(BigDecimal nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }

    public BigDecimal getNivelMaximo() {
        return nivelMaximo;
    }

    public void setNivelMaximo(BigDecimal nivelMaximo) {
        this.nivelMaximo = nivelMaximo;
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
        if (!(object instanceof Kardex)) {
            return false;
        }
        Kardex other = (Kardex) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vipsoft.erp.abinadi.dominio.Kardex[ id=" + id + " ]";
    }
    
}
