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
        CuentaContable cxcclientes=cydxc.anadirSubCuenta("CUENTAS POR COBRAR A CLIENTES");
                
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
        bodegaPrincipal.setCuentaContableBodega(cbodegaPrincipal);
        bodegaTransito.setCuentaContableBodega(cbodegaTransito);
        CuentaContable periodificaciones=ac.anadirSubCuenta("PERIODIFICACIONES");
        CuentaContable af=activo.anadirSubCuenta("ACTIVOS NO CORRIENTE");
        CuentaContable pasivoCorreintes=pasivo.anadirSubCuenta("PASIVOS CORRIENTES");
        CuentaContable pasivoNoCorriente=pasivo.anadirSubCuenta("PASIVOS NO CORRIENTES");
        CuentaContable cuentasXPagar=pasivoCorreintes.anadirSubCuenta("CUENTAS POR PAGAR");
        CuentaContable docxpagar=pasivoCorreintes.anadirSubCuenta("DOCUMENTOS POR PAGAR");
        CuentaContable provisiones=pasivoCorreintes.anadirSubCuenta("PROVISIONES");
        CuentaContable docxpagarLargoPlazo=pasivoNoCorriente.anadirSubCuenta("DOCUMENTOS POR PAGAR LARGO PLAZO");
        
        
        CuentaContable capitalyreserva=patrimonio.anadirSubCuenta("CAPITAL Y RESERVAS");
        CuentaContable ingresoOrdinario=ingresos.anadirSubCuenta("INGRESOS ACTIVIDADES ORDINARIAS");
        CuentaContable ventas=ingresoOrdinario.anadirSubCuenta("VENTAS");
        CuentaContable vomatriz=ventas.anadirSubCuenta("MATRIZ");
        CuentaContable interesesganados=ingresoOrdinario.anadirSubCuenta("INTERESES GANADOS");
        CuentaContable otrosIngresos=ingresos.anadirSubCuenta("OTROS INGRESOS");
        
        
        CuentaContable coao=costos.anadirSubCuenta("COSTO DE ACTIVIDADES ORDINARIAS");
        CuentaContable costoVentas=coao.anadirSubCuenta("COSTO DE VENTAS");
        CuentaContable costoMercaderia=costoVentas.anadirSubCuenta("COSTO DE MERCADERIA");
        
        
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
    public CuentaContable buscarCuentaXCodigo(String codigoCuenta  ,Entidad e){
        CuentaContable retorno=null;
        
        return retorno;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
