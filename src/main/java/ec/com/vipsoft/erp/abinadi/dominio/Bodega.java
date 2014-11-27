/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.dominio;

import ec.com.vipsoft.erp.abinadi.contabilidad.CuentaContable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author chrisvv
 */
@Entity
public class Bodega implements Serializable {

    public Bodega() {
        super();
        kardexes=new ArrayList<>();
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean xdefault;
    private boolean estricto;
    @NotNull
    @ManyToOne
    protected Entidad entidad;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)    
    private List<Kardex>kardexes;
    @NotNull
    @OneToOne
    protected CuentaContable cuentaContable;
    
    private String codigo;
    private String descripcion;

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public boolean isXdefault() {
        return xdefault;
    }

    public void setXdefault(boolean xdefault) {
        this.xdefault = xdefault;
    }

    public boolean isEstricto() {
        return estricto;
    }

    public void setEstricto(boolean estricto) {
        this.estricto = estricto;
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
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vipsoft.erp.abinadi.dominio.Bodega[ id=" + id + " ]";
    }

    public void crearKardex(Producto producto) {
        Kardex kardex=new Kardex();
      //  kardex.setBodega(this);
        kardex.setProducto(producto);
        kardex.setNivelMaximo(BigDecimal.ZERO);
        kardex.setNivelMinimo(BigDecimal.ZERO);
        kardex.setExistencia(BigDecimal.ZERO);
        kardex.setValoracion(BigDecimal.ZERO);
        kardexes.add(kardex);
        
    }

    public List<Kardex> getKardexes() {
        return kardexes;
    }

    public void setKardexes(List<Kardex> kardexes) {
        this.kardexes = kardexes;
    }

    public CuentaContable getCuentaContable() {
        return cuentaContable;
    }

    public void setCuentaContable(CuentaContable cuentaContable) {
        this.cuentaContable = cuentaContable;
    }
    
}
