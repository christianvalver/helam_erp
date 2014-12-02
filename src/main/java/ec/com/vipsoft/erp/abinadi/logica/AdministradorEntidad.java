/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.logica;

import ec.com.vipsoft.erp.abinadi.contabilidad.CuentaContable;
import ec.com.vipsoft.erp.abinadi.contabilidad.PlantillaDeTransaccion;
import ec.com.vipsoft.erp.abinadi.dominio.BienEconomico;
import ec.com.vipsoft.erp.abinadi.dominio.Bodega;
import ec.com.vipsoft.erp.abinadi.dominio.Entidad;
import ec.com.vipsoft.erp.abinadi.dominio.Producto;
import ec.com.vipsoft.erp.abinadi.dominio.Tarifa;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.Pattern;

/**
 *
 * @author chrisvv
 */
@Stateless
public class AdministradorEntidad {

    @PersistenceContext
    EntityManager em;
    @EJB
    PlanCuentaManager planCuenta;

    public void registrarEntidad(@Pattern(regexp = "[0-9]{13,13}") String ruc, String razonSocial_, String nombreComercial_) {
        Entidad e = new Entidad();
        e.setRuc(ruc);
        e.setRazonSocial(razonSocial_);
        e.setNombreComercial(nombreComercial_);
        em.persist(e);
        Tarifa tarifapvp=new Tarifa();
        tarifapvp.setCodigo("pvp");
        tarifapvp.setEntidad(e);
        tarifapvp.setPorcentajeAlPVP(BigDecimal.ONE);
        tarifapvp.setTarifaDefecto(true);
        em.persist(tarifapvp);
             
        planCuenta.iniciarPlanCuentas(e);                
     //   em.persist(bodegaPrincipal);
       // return e.getId();

    }

    
    public void crearBienEconomico(BienEconomico b, String ruc) {
        Query q = em.createQuery("select e from Entidad e where e.ruc=?1");
        q.setParameter(1, ruc);
        List<Entidad> listaEntidad = q.getResultList();
        if (listaEntidad.get(0) != null) {
            Entidad entidad = em.find(Entidad.class, listaEntidad.get(0).getId());
            b.setEntidad(entidad);
            if (b instanceof Producto) {
                Query qbodega = em.createQuery("select b from Bodega b where b.entidad.id=?1");
                qbodega.setParameter(1, entidad.getId());
                List<Bodega> listaBodegas = qbodega.getResultList();
                if (!listaBodegas.isEmpty()) {
                    for(Bodega bod:listaBodegas){
                        Bodega bodega = em.find(Bodega.class, bod.getId());
                        bodega.crearKardex((Producto) b);
                        em.persist(b);
                    }
                    
                    //poner detalle en tarifa de pvp
                    Query qtarifapvp=em.createQuery("select t from Tarifa t where t.entidad.id=?1 and t.codigo='pvp'");
                    qtarifapvp.setParameter(1, entidad.getId());
                    List<Tarifa>listaTarifa=qtarifapvp.getResultList();
                    if(!listaTarifa.isEmpty()){
                        Tarifa tarifapvp=em.find(Tarifa.class, listaTarifa.get(0).getId());
                        tarifapvp.anadirBien(b,BigDecimal.ZERO);
                    }
                }
            } else {
                em.persist(b);
            }
        }

    }
    
    public Set<BienEconomico>listarBienEconomico(String ruc){
        Set<BienEconomico>retorno=new TreeSet<>();
        
        
        return retorno;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void registrarTransaccionesPlantillas(Entidad e){
        PlantillaDeTransaccion plantillaVentas=new PlantillaDeTransaccion();
        plantillaVentas.setGlosa("Registrar venta según Factura N° numeroFactura");
        CuentaContable c1=planCuenta.buscarCuentaXCodigo("4.1.1.1", e);
        CuentaContable c2=planCuenta.buscarCuentaXCodigo("1.1.3", e);
        plantillaVentas.anadirCredito(c1,BigDecimal.ZERO);
        plantillaVentas.anadirDebito(c2,BigDecimal.ZERO);
        em.persist(plantillaVentas);
        
    }
}
