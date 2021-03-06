/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author chrisvv
 */
@Entity
public class Tarifa implements Serializable,Comparable<Tarifa> {

    public Tarifa() {
        detalles=new TreeSet<>();
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codigo;
    @Column(columnDefinition = "decimal(3,2) default 1.00")
    private BigDecimal porcentajeAlPVP;
    private Boolean tarifaDefecto;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<TarifaDetalle>detalles;
    @NotNull
    @ManyToOne
    private Entidad entidad;

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPorcentajeAlPVP() {
        return porcentajeAlPVP;
    }

    public void setPorcentajeAlPVP(BigDecimal porcentajeAlPVP) {
        this.porcentajeAlPVP = porcentajeAlPVP;
    }

    public Boolean getTarifaDefecto() {
        return tarifaDefecto;
    }

    public void setTarifaDefecto(Boolean tarifaDefecto) {
        this.tarifaDefecto = tarifaDefecto;
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
        if (!(object instanceof Tarifa)) {
            return false;
        }
        Tarifa other = (Tarifa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vipsoft.erp.abinadi.dominio.Tarifa[ id=" + id + " ]";
    }

    public void anadirBien(BienEconomico b, BigDecimal valor) {
        TarifaDetalle td=new TarifaDetalle();
        td.setBien(b);
        td.setTarifa(this);
        td.setValor(valor);
        detalles.add(td);        
    }

    @Override
    public int compareTo(Tarifa o) {
        int retorno=entidad.compareTo(o.entidad);
        if(retorno==0){
            retorno=codigo.compareTo(o.codigo);
        }
        return retorno;
    }
    
}
