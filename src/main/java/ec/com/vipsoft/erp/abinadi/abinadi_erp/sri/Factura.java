/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.abinadi_erp.sri;

import ec.com.vipsoft.erp.abinadi.dominio.Entidad;
import ec.com.vipsoft.erp.abinadi.dominio.cartera.Cliente;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author chrisvv
 */
@Entity
public class Factura implements Serializable {

    public Factura() {
        notasCredito=new TreeSet<>();
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeracion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @ManyToOne
    protected Cliente cliente;
    @Column(columnDefinition = "decimal(18,2) default 0.0")
    protected BigDecimal saldo;
    @Column(columnDefinition = "decimal(18,2) default 0.0")
    protected BigDecimal subTotalIva0Factura;
    @Column(columnDefinition = "decimal(18,2) default 0.0")
    protected BigDecimal subTotalIva12Factura;
    protected String autorizacionSRI;
    @OneToMany(mappedBy = "factura")
    protected Set<NotaCredito>notasCredito;
    @OneToMany(mappedBy = "factura")
    protected Set<Retencion>retenciones;
    @NotNull
    @ManyToOne
    protected Entidad entidad;
    protected Integer particionamiento;

    public Integer getParticionamiento() {
        return particionamiento;
    }

    public void setParticionamiento(Integer particionamiento) {
        this.particionamiento = particionamiento;
    }
     

    public Set<Retencion> getRetenciones() {
        return retenciones;
    }

    public void setRetenciones(Set<Retencion> retenciones) {
        this.retenciones = retenciones;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getAutorizacionSRI() {
        return autorizacionSRI;
    }

    public void setAutorizacionSRI(String autorizacionSRI) {
        this.autorizacionSRI = autorizacionSRI;
    }

    public Set<NotaCredito> getNotasCredito() {
        return notasCredito;
    }

    public void setNotasCredito(Set<NotaCredito> notasCredito) {
        this.notasCredito = notasCredito;
    }
    
    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vipsoft.erp.abinadi.dominio.Factura[ id=" + id + " ]";
    }
    
}
