/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.logica;

import ec.com.vipsoft.erp.abinadi.contabilidad.CuentaAcreedora;
import ec.com.vipsoft.erp.abinadi.contabilidad.CuentaContable;
import ec.com.vipsoft.erp.abinadi.contabilidad.CuentaDeudora;
import ec.com.vipsoft.erp.abinadi.contabilidad.GrupoCuenta;
import ec.com.vipsoft.erp.abinadi.dominio.Bodega;
import ec.com.vipsoft.erp.abinadi.dominio.Entidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author chrisvv
 */
@Stateless
public class PlanCuentaManager {

    @PersistenceContext
    private EntityManager em;
    public void iniciarPlanCuentas(Entidad entidad) {
        CuentaDeudora activo=new CuentaDeudora();
        activo.setEntidad(entidad);
        activo.setCodigo("1");
        activo.setDescripcion("ACTIVOS");
        activo.setGrupo(GrupoCuenta.activo);
        CuentaAcreedora pasivo=new CuentaAcreedora();
        pasivo.setEntidad(entidad);
        pasivo.setCodigo("2");
        pasivo.setDescripcion("PASIVOS");
        pasivo.setGrupo(GrupoCuenta.pasivo);
        CuentaAcreedora patrimonio=new CuentaAcreedora();
        patrimonio.setEntidad(entidad);
        patrimonio.setGrupo(GrupoCuenta.patrimonio);
        patrimonio.setCodigo("3");
        patrimonio.setDescripcion("PATRIMONIO");
        CuentaAcreedora ingresos=new CuentaAcreedora();
        ingresos.setEntidad(entidad);
        ingresos.setCodigo("4");
        ingresos.setDescripcion("INGRESOS");
        ingresos.setGrupo(GrupoCuenta.ingresos);
        CuentaDeudora gastos=new CuentaDeudora();
        gastos.setEntidad(entidad);
        gastos.setCodigo("5");
        gastos.setDescripcion("GASTOS");
        gastos.setGrupo(GrupoCuenta.gastos);
        CuentaDeudora costos=new CuentaDeudora();
        costos.setEntidad(entidad);
        costos.setGrupo(GrupoCuenta.costos);
        costos.setDescripcion("COSTOS");
        costos.setCodigo("6");
        ///////////////////////////////////////////////////////////////7
        
        CuentaContable ac=activo.anadirSubCuenta("ACTIVOS CORRIENTES");
        CuentaContable efectivoequ=ac.anadirSubCuenta("EFECTIVO Y EQUIVALENTES A EFECTIVO");
        CuentaContable caja=efectivoequ.anadirSubCuenta("CAJA");
        CuentaContable efectransito=efectivoequ.anadirSubCuenta("EFECTIVO EN TRANSITO");
        CuentaContable bancos=efectivoequ.anadirSubCuenta("BANCOS");
        CuentaContable equivalentesEfectovo=efectivoequ.anadirSubCuenta("EQUIVALENTES DE EFECTIVO");
        CuentaContable chequespordepositar=equivalentesEfectovo.anadirSubCuenta("CHEQUES RECIBIDOS POR DEPOSITAR");
        CuentaContable inversiontemporales=ac.anadirSubCuenta("INVERSIONES FINANCIERAS A CORTO PLAZO");
        CuentaContable cydxc=ac.anadirSubCuenta("CUENTAS Y DOCUMENTOS POR COBRAR");
        
         Bodega bodegaPrincipal = new Bodega();
        bodegaPrincipal.setCodigo("001");
        bodegaPrincipal.setDescripcion("BODEGA MATRIZ");
        bodegaPrincipal.setEntidad(entidad);  
        bodegaPrincipal.setEstricto(true);
        Bodega bodegaTransito=new Bodega();
        bodegaTransito.setCodigo("00");
        bodegaTransito.setDescripcion("BODEGA TRANSITO");
        bodegaTransito.setEntidad(entidad);
        bodegaTransito.setEstricto(false);
        
        CuentaContable inventario=ac.anadirSubCuenta("INVENTARIO");
        CuentaContable cbodegaPrincipal=inventario.anadirSubCuenta("BODEGA MATRIZ");
        CuentaContable cbodegaTransito=inventario.anadirSubCuenta("BODEGA TRANSITO");
        bodegaPrincipal.setCuentaContable(cbodegaPrincipal);
        bodegaTransito.setCuentaContable(cbodegaTransito);
        CuentaContable periodificaciones=ac.anadirSubCuenta("PERIODIFICACIONES");
        CuentaContable af=activo.anadirSubCuenta("ACTIVOS NO CORRIENTE");
        
        em.persist(activo);
        em.persist(pasivo);
        em.persist(patrimonio);
        em.persist(ingresos);
        em.persist(gastos);
        em.persist(costos);
        em.persist(bodegaPrincipal);
        em.persist(bodegaTransito);
        
    }

    public boolean existeUnaEmpresaRegistrada(){
        boolean retorno=false;
        Entidad entidad=em.find(Entidad.class, 1l);
        if(entidad!=null){
            retorno=true;
        }               
        return retorno;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
