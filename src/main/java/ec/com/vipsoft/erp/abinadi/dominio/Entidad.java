/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

/**
 *
 * @author chrisvv
 */
@Entity
public class Entidad implements Serializable,Comparable<Entidad> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "[0-9]{13,13}")
    @Column(unique = true)
    private String ruc;
    private String razonSocial;
    private String nombreComercial;
    private Integer cierreKardex;
    protected Long secuenciaTransaccion;

    public Long getSecuenciaTransaccion() {
        return secuenciaTransaccion;
    }

    public void setSecuenciaTransaccion(Long secuenciaTransaccion) {
        this.secuenciaTransaccion = secuenciaTransaccion;
    }
    
    
    public Integer getCierreKardex() {
        return cierreKardex;
    }

    public void setCierreKardex(Integer cierreKardex) {
        this.cierreKardex = cierreKardex;
    }
    

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
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
        if (!(object instanceof Entidad)) {
            return false;
        }
        Entidad other = (Entidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vipsoft.erp.abinadi.dominio.Entidad[ id=" + id + " ]";
    }

    @Override
    public int compareTo(Entidad o) {
        return ruc.compareTo(o.ruc);
    }

    public Entidad() {
        secuenciaTransaccion=1L;
    }
    
    public String siguienteTransaccion(){
        StringBuilder sb=new StringBuilder();
        int longitud=8-secuenciaTransaccion.toString().length();
        for(int i=0;i>longitud;i++){
            sb.append("0");
        }
        secuenciaTransaccion++;
        sb.append(secuenciaTransaccion);
        return sb.toString();
    }
}
