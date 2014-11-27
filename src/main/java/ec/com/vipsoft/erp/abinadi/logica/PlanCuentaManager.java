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
        activo.setCodigo("1");
        activo.setDescripcion("ACTIVOS");
        activo.setGrupo(GrupoCuenta.activo);
        CuentaAcreedora pasivo=new CuentaAcreedora();
        pasivo.setCodigo("2");
        pasivo.setDescripcion("PASIVOS");
        pasivo.setGrupo(GrupoCuenta.pasivo);
        CuentaAcreedora patrimonio=new CuentaAcreedora();
        patrimonio.setGrupo(GrupoCuenta.patrimonio);
        patrimonio.setCodigo("3");
        patrimonio.setDescripcion("PATRIMONIO");
        CuentaAcreedora ingresos=new CuentaAcreedora();
        ingresos.setCodigo("4");
        ingresos.setDescripcion("INGRESOS");
        ingresos.setGrupo(GrupoCuenta.ingresos);
        CuentaDeudora gastos=new CuentaDeudora();
        gastos.setCodigo("5");
        gastos.setDescripcion("GASTOS");
        gastos.setGrupo(GrupoCuenta.gastos);
        CuentaDeudora costos=new CuentaDeudora();
        costos.setGrupo(GrupoCuenta.costos);
        costos.setDescripcion("COSTOS");
        costos.setCodigo("6");
        ///////////////////////////////////////////////////////////////7
        
        CuentaContable ac=activo.anadirSubCuenta("ACTIVOS CORRIENTES");
        CuentaContable af=activo.anadirSubCuenta("ACTIVOS NO CORRIENTE");
        em.persist(activo);
        em.persist(pasivo);
        em.persist(patrimonio);
        em.persist(ingresos);
        em.persist(gastos);
        em.persist(costos);
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
