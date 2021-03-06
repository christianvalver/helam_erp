/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.contabilidad;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author chrisvv
 */
@Entity
public class TransaccionDetalle implements Serializable,Comparable<TransaccionDetalle> {
    @ManyToOne
    private Transaccion transaccion;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Long id;
    @ManyToOne
    private CuentaContable cuentaContable;
    @Enumerated(EnumType.ORDINAL)
    private TipoTransaccionDetalle tipo;
    @Column(columnDefinition = "decimal(20,2) default 0")
    private BigDecimal monto;
    private Integer particionador;

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
        if (!(object instanceof TransaccionDetalle)) {
            return false;
        }
        TransaccionDetalle other = (TransaccionDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vipsoft.erp.abinadi.contabilidad.TransaccionDetalle[ id=" + id + " ]";
    }

    @Override
    public int compareTo(TransaccionDetalle o) {
        int retorno=cuentaContable.compareTo(o.cuentaContable);
        if(retorno==0)
        {
            retorno=monto.compareTo(o.monto);
            if(retorno==0){
                retorno=tipo.compareTo(o.tipo);
            }
        }
        return retorno;
    }
    
}
