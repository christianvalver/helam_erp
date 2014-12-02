/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.dominio.cartera;

import ec.com.vipsoft.erp.abinadi.abinadi_erp.sri.Contribuyente;
import ec.com.vipsoft.erp.abinadi.abinadi_erp.sri.NotaCredito;
import ec.com.vipsoft.erp.abinadi.contabilidad.CuentaContable;
import ec.com.vipsoft.erp.abinadi.dominio.Tarifa;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.ws.rs.NotAcceptableException;

/**
 *
 * @author chrisvv
 */
@Entity
@DiscriminatorValue("c")
public class Cliente extends Contribuyente implements Serializable {

    public Cliente() {
        super();
        notasCredito=new TreeSet<>();
        montoMaximoCredito=BigDecimal.ONE;
        capitalAdeudado=BigDecimal.ZERO;
        interesAdeudado=BigDecimal.ZERO;
    }
    
    @ManyToOne
    protected Tarifa tarifa;
    protected boolean credito;
    @Enumerated(EnumType.ORDINAL)
    protected CategoriaCliente categoria;
    @Column(columnDefinition = "decimal(18,2)")
    protected BigDecimal montoMaximoCredito;
    @Column(columnDefinition = "decimal(18,2)")
    protected BigDecimal capitalAdeudado;
    @Column(columnDefinition = "decimal(18,2)")
    protected BigDecimal interesAdeudado;
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    protected Set<NotaCredito>notasCredito;
    @OneToOne(cascade = CascadeType.ALL)
    protected CuentaContable cuentaXCobrar;

    public BigDecimal getCapitalAdeudado() {
        return capitalAdeudado;
    }

    public void setCapitalAdeudado(BigDecimal capitalAdeudado) {
        this.capitalAdeudado = capitalAdeudado;
    }

    public BigDecimal getInteresAdeudado() {
        return interesAdeudado;
    }

    public void setInteresAdeudado(BigDecimal interesAdeudado) {
        this.interesAdeudado = interesAdeudado;
    }

    public Set<NotaCredito> getNotasCredito() {
        return notasCredito;
    }

    public void setNotasCredito(Set<NotaCredito> notasCredito) {
        this.notasCredito = notasCredito;
    }

    public CuentaContable getCuentaXCobrar() {
        return cuentaXCobrar;
    }

    public void setCuentaXCobrar(CuentaContable cuentaXCobrar) {
        this.cuentaXCobrar = cuentaXCobrar;
    }
    
    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public boolean isCredito() {
        return credito;
    }

    public void setCredito(boolean credito) {
        this.credito = credito;
    }

    public CategoriaCliente getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaCliente categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getMontoMaximoCredito() {
        return montoMaximoCredito;
    }

    public void setMontoMaximoCredito(BigDecimal montoMaximoCredito) {
        this.montoMaximoCredito = montoMaximoCredito;
    }
    
}
