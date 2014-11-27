/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.dominio;

import ec.com.vipsoft.erp.abinadi.contabilidad.CuentaContable;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author chrisvv
 */
@Entity
public class CuentaBancaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCuenta;
    @Column(columnDefinition = "decimal(18,2)")
    private BigDecimal saldoEfectivo;
    @Column(columnDefinition = "decimal(18,2)")
    private BigDecimal saldoXConfirmar;
    @OneToOne
    private CuentaContable cuentaContable;

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getSaldoEfectivo() {
        return saldoEfectivo;
    }

    public void setSaldoEfectivo(BigDecimal saldoEfectivo) {
        this.saldoEfectivo = saldoEfectivo;
    }

    public BigDecimal getSaldoXConfirmar() {
        return saldoXConfirmar;
    }

    public void setSaldoXConfirmar(BigDecimal saldoXConfirmar) {
        this.saldoXConfirmar = saldoXConfirmar;
    }

    public CuentaContable getCuentaContable() {
        return cuentaContable;
    }

    public void setCuentaContable(CuentaContable cuentaContable) {
        this.cuentaContable = cuentaContable;
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
        if (!(object instanceof CuentaBancaria)) {
            return false;
        }
        CuentaBancaria other = (CuentaBancaria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vipsoft.erp.abinadi.dominio.CuentaBancaria[ id=" + id + " ]";
    }
    
}
