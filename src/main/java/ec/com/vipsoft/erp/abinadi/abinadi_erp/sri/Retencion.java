/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.abinadi_erp.sri;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author chrisvv
 */
@Entity
public class Retencion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String autorizacionSRI;
    protected String numeracionSRI;
    @Temporal(TemporalType.DATE)
    protected Date fechaEmision;
    @Column(columnDefinition = "decimal(18,2)")
    protected BigDecimal totalRetenido;
    @ManyToOne
    protected Factura factura;
    public String getAutorizacionSRI() {
        return autorizacionSRI;
    }

    public void setAutorizacionSRI(String autorizacionSRI) {
        this.autorizacionSRI = autorizacionSRI;
    }

    public String getNumeracionSRI() {
        return numeracionSRI;
    }

    public void setNumeracionSRI(String numeracionSRI) {
        this.numeracionSRI = numeracionSRI;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public BigDecimal getTotalRetenido() {
        return totalRetenido;
    }

    public void setTotalRetenido(BigDecimal totalRetenido) {
        this.totalRetenido = totalRetenido;
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
        if (!(object instanceof Retencion)) {
            return false;
        }
        Retencion other = (Retencion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vipsoft.erp.abinadi.abinadi_erp.sri.Retencion[ id=" + id + " ]";
    }
    
}
