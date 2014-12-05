/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.contabilidad;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author chrisvv
 */
@Entity
@DiscriminatorValue("B")
public class TransaccionBancaria extends Transaccion implements Serializable {
    
    private boolean conciliado;
    private String numeroComprobanteBancario;

    public boolean isConciliado() {
        return conciliado;
    }

    public void setConciliado(boolean conciliado) {
        this.conciliado = conciliado;
    }

    public String getNumeroComprobanteBancario() {
        return numeroComprobanteBancario;
    }

    public void setNumeroComprobanteBancario(String numeroComprobanteBancario) {
        this.numeroComprobanteBancario = numeroComprobanteBancario;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }
    
}
