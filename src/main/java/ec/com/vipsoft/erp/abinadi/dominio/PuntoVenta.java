/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.dominio;

import ec.com.vipsoft.erp.abinadi.contabilidad.CuentaContable;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author chrisvv
 */
@Entity
public class PuntoVenta implements Serializable {

    public PuntoVenta() {
        bodegas=new TreeSet<>();
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @OneToOne
    protected Entidad entidad;
    protected Long secuenciaFacturacion;
    protected String codigoPuntoVenta;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    protected Bodega bodegaPrincipal;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    protected Set<Bodega>bodegas;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private CuentaContable cuentaContable;

    public CuentaContable getCuentaContable() {
        return cuentaContable;
    }

    public void setCuentaContable(CuentaContable cuentaContable) {
        this.cuentaContable = cuentaContable;
    }

    
    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public Long getSecuenciaFacturacion() {
        return secuenciaFacturacion;
    }

    public void setSecuenciaFacturacion(Long secuenciaFacturacion) {
        this.secuenciaFacturacion = secuenciaFacturacion;
    }

    public String getCodigoPuntoVenta() {
        return codigoPuntoVenta;
    }

    public void setCodigoPuntoVenta(String codigoPuntoVenta) {
        this.codigoPuntoVenta = codigoPuntoVenta;
    }

    public Bodega getBodegaPrincipal() {
        return bodegaPrincipal;
    }

    public void setBodegaPrincipal(Bodega bodegaPrincipal) {
        this.bodegaPrincipal = bodegaPrincipal;
    }

    public Set<Bodega> getBodegas() {
        return bodegas;
    }

    public void setBodegas(Set<Bodega> bodegas) {
        this.bodegas = bodegas;
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
        if (!(object instanceof PuntoVenta)) {
            return false;
        }
        PuntoVenta other = (PuntoVenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vipsoft.erp.abinadi.dominio.PuntoVenta[ id=" + id + " ]";
    }
    
}
