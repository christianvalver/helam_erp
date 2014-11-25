/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.logica;

import ec.com.vipsoft.erp.abinadi.dominio.BienEconomico;
import ec.com.vipsoft.erp.abinadi.dominio.Bodega;
import ec.com.vipsoft.erp.abinadi.dominio.Entidad;
import ec.com.vipsoft.erp.abinadi.dominio.Producto;
import java.util.List;
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

    public void registrarEntidad(@Pattern(regexp = "[0-9]{13,13}") String ruc, String razonSocial_, String nombreComercial_) {
        Entidad e = new Entidad();
        e.setRuc(ruc);
        e.setRazonSocial(razonSocial_);
        e.setNombreComercial(nombreComercial_);
        Bodega bodegaPrincipal = new Bodega();
        bodegaPrincipal.setCodigo("001");
        bodegaPrincipal.setDescripcion("BODEGA MATRIZ");
        bodegaPrincipal.setEntidad(e);
        em.persist(e);
        em.persist(bodegaPrincipal);
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
                    Bodega bodega = em.find(Bodega.class, listaBodegas.get(0).getId());
                    bodega.crearKardex((Producto) b);
                    em.persist(b);                    
                }
            } else {
                em.persist(b);
            }

        }

    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
