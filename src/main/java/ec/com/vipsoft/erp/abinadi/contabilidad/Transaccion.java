/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.contabilidad;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author chrisvv
 */
@Entity
@DiscriminatorValue("t")
public class Transaccion extends PlantillaDeTransaccion {
    private static final long serialVersionUID = 1L;
    @Temporal(TemporalType.DATE)
    private Date fechaTransaccion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    private String usuario;
    private boolean mayorizada;
    private String secuenciaTransaccion;
    @OneToOne
    private Transaccion transaccionReversada;

    @ManyToOne
    private CuentaContable cuentaACompletar;
    public Transaccion getTransaccionReversada() {
        return transaccionReversada;
    }

    public void setTransaccionReversada(Transaccion transaccionReversada) {
        this.transaccionReversada = transaccionReversada;
    }
    
    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    

    @Override
    public String toString() {
        return "ec.com.vipsoft.erp.abinadi.contabilidad.Transaccion[ id=" + id + " ]";
    }

    public boolean isMayorizada() {
        return mayorizada;
    }

    public void setMayorizada(boolean mayorizada) {
        this.mayorizada = mayorizada;
    }    

    
    public boolean estaCuadrada() {
        boolean retorno=false;
        
        return retorno;
    }

    public String getSecuenciaTransaccion() {
        return secuenciaTransaccion;
    }

    public void setSecuenciaTransaccion(String secuenciaTransaccion) {
        this.secuenciaTransaccion = secuenciaTransaccion;
    }
    
}
