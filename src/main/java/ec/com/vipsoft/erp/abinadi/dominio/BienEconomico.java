/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
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
@DiscriminatorColumn(name = "tipo",discriminatorType = DiscriminatorType.STRING,length = 2)
public abstract class BienEconomico implements Serializable,Comparable<BienEconomico> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(columnDefinition = "char(1) default'2'")
    protected String codigoIVA;
    protected String codigoICE;
    //@NotNull
    protected String codigo;
   //@NotNull
    protected String descripcion;
    protected String codigoAlterno;
    @NotNull
    @ManyToOne
    protected Entidad entidad;

    public String getCodigoAlterno() {
        return codigoAlterno;
    }

    public void setCodigoAlterno(String codigoAlterno) {
        this.codigoAlterno = codigoAlterno;
    }

    
    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    
    public String getCodigoIVA() {
        return codigoIVA;
    }

    public void setCodigoIVA(String codigoIVA) {
        this.codigoIVA = codigoIVA;
    }

    public String getCodigoICE() {
        return codigoICE;
    }

    public void setCodigoICE(String codigoICE) {
        this.codigoICE = codigoICE;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof BienEconomico)) {
            return false;
        }
        BienEconomico other = (BienEconomico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vipsoft.erp.abinadi.dominio.BienEconomico[ id=" + id + " ]";
    }

    @Override
    public int compareTo(BienEconomico o) {        
        int retorno=codigo.compareTo(o.codigo);        
        return retorno;
    }
    
}
