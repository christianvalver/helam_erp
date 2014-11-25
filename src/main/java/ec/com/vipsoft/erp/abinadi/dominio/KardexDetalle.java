/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author chrisvv
 */
@Entity
@DiscriminatorColumn(name = "tipo",length = 1,discriminatorType = DiscriminatorType.CHAR)
public abstract class KardexDetalle implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @NotNull
    @ManyToOne
    protected Kardex kardex;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal cantidad;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal valorUnitario;
    @Column(columnDefinition = "decimal(18,2) default 0")
    protected BigDecimal valorTotal;
    protected Integer cierreKardex;
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
        if (!(object instanceof KardexDetalle)) {
            return false;
        }
        KardexDetalle other = (KardexDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vipsoft.erp.abinadi.dominio.KardexDetalle[ id=" + id + " ]";
    }
    
}
