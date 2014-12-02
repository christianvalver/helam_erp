/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.contabilidad;

import ec.com.vipsoft.erp.abinadi.dominio.Entidad;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author chrisvv
 */
@Entity
@DiscriminatorColumn(name = "tipo",length = 2,discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("p")
public class PlantillaDeTransaccion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @ManyToOne
    protected Entidad entidad;
    @Column(columnDefinition = "decimal(20,2)")
    protected BigDecimal monto;
    protected String glosa;
    @OneToMany(mappedBy = "transaccion",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    protected Set<TransaccionDetalle> detalles;
    protected Integer particionador;

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    
    public Integer getParticionador() {
        return particionador;
    }

    public void setParticionador(Integer particionador) {
        this.particionador = particionador;
    }
    
    public Set<TransaccionDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<TransaccionDetalle> detalles) {
        this.detalles = detalles;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getGlosa() {
        return glosa;
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
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    

    public void anadirCredito(CuentaContable c1, BigDecimal monto) {
        TransaccionDetalle detalle=new TransaccionDetalle();
        detalle.setCuentaContable(c1);
        detalle.setTipo(TipoTransaccionDetalle.credito);
        detalle.setMonto(monto);
        detalles.add(detalle);
    }

    public void anadirDebito(CuentaContable c2, BigDecimal monto) {
        TransaccionDetalle detalle=new TransaccionDetalle();
        detalle.setCuentaContable(c2);
        detalle.setTipo(TipoTransaccionDetalle.debito);
        detalle.setMonto(monto);
        detalles.add(detalle);
    }

    public PlantillaDeTransaccion() {
        detalles=new TreeSet<>();
    }
    
    
}
