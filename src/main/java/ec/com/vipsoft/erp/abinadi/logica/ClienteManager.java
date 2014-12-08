/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.logica;

import ec.com.vipsoft.erp.abinadi.dominio.Entidad;
import ec.com.vipsoft.erp.abinadi.dominio.Tarifa;
import ec.com.vipsoft.erp.abinadi.dominio.cartera.CategoriaCliente;
import ec.com.vipsoft.erp.abinadi.dominio.cartera.Cliente;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author chrisvv
 */
@Stateless
public class ClienteManager {
    @PersistenceContext
    private EntityManager em;

    public Integer registrarCliente(Entidad entidad,String rucId,String razonSocial,String direccion,String telefono,boolean credito,Tarifa tarifa){
        Integer retorno=0;
        Cliente cliente=new Cliente();
        cliente.setEntidad(entidad);
        cliente.setCapitalAdeudado(BigDecimal.ZERO);
        cliente.setCategoria(CategoriaCliente.a);
        cliente.setCredito(credito);
        cliente.setDireccion(direccion);
        cliente.setTelefono(telefono);
        cliente.setTarifa(tarifa);
        cliente.setInteresAdeudado(BigDecimal.ZERO);
        cliente.setIdentifiacion(rucId);
        cliente.setRazonSocial(razonSocial);
        em.persist(cliente);
                
        retorno=1;
        return retorno;
    }
    public List<Cliente>listarClientes(Integer maximo,String patron){
        ArrayList<Cliente>listaRetorno=new ArrayList<>();
        Query q=em.createQuery("select c from Cliente c ");
        List<Cliente>listado=q.getResultList();
        if(!listado.isEmpty()){
            Pattern pattern=Pattern.compile(patron);
            for(Cliente c:listaRetorno){
                Matcher matcher=pattern.matcher(c.getRazonSocial());
                if(matcher.matches()){
                    listaRetorno.add(c);
                }
            }
            
        }
        
        
        
        return listaRetorno;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
