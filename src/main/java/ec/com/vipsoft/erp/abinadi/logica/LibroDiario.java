/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.logica;

import ec.com.vipsoft.erp.abinadi.contabilidad.CuentaContable;
import ec.com.vipsoft.erp.abinadi.contabilidad.TipoTransaccionDetalle;
import ec.com.vipsoft.erp.abinadi.contabilidad.Transaccion;
import ec.com.vipsoft.erp.abinadi.contabilidad.TransaccionDetalle;
import ec.com.vipsoft.erp.abinadi.dominio.Entidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author chrisvv
 */
@Stateless
public class LibroDiario {

    private EntityManager em;
    public Long registrarTransaccion(Transaccion transaccion) {
        //falta verificar que se haga dentro del periodo.
        String siguienteTransaccion="0";
        if(transaccion.estaCuadrada()){
            Entidad entidad=em.find(Entidad.class, transaccion.getEntidad().getId());
            siguienteTransaccion=entidad.siguienteTransaccion();
            transaccion.setSecuenciaTransaccion(entidad.siguienteTransaccion());
            for(TransaccionDetalle d:transaccion.getDetalles()){
                CuentaContable c=em.find(CuentaContable.class, d.getCuentaContable().getId());
                if(d.getTipo()==TipoTransaccionDetalle.credito){
                    c.aumentaCredito(d.getMonto());
                }
                if(d.getTipo()==TipoTransaccionDetalle.debito){
                    c.aumentaDebito(d.getMonto());
                }
            }
            em.persist(transaccion);
        }
        return Long.parseLong(siguienteTransaccion);
    }

    
}
