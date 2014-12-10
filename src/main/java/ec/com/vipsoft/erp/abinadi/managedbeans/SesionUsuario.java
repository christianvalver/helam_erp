/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.managedbeans;

import ec.com.vipsoft.erp.abinadi.dominio.BienEconomico;
import ec.com.vipsoft.erp.abinadi.dominio.Entidad;
import ec.com.vipsoft.erp.abinadi.logica.AdministradorEntidad;
import ec.com.vipsoft.erp.abinadi.util.BienSeleccion;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author chrisvv
 */
@SessionScoped
public class SesionUsuario implements Serializable {

    public SesionUsuario() {
        objetosSeleccionadosTemporales = new TreeSet<>();
    }
    @EJB
    private AdministradorEntidad adminEntidad;
    protected String usuario;
    protected String rucCompañia;
    protected String sucursal;
    protected Entidad entidad;
    protected Set<BienSeleccion> objetosSeleccionadosTemporales;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRucCompañia() {
        return rucCompañia;
    }

    public void setRucCompañia(String rucCompañia) {
        this.rucCompañia = rucCompañia;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String siguienteNoFactura() {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }
    
    public void anadirSeleccion(BienSeleccion b){
        objetosSeleccionadosTemporales.add(b);
    }
    
    public void limpiarObjetosSeleccionados(){
        objetosSeleccionadosTemporales.clear();
    }

    public Set<BienSeleccion>listarSelecionados(){
        return objetosSeleccionadosTemporales;
    }
    public Set<BienSeleccion>listarBienesParaSeleccion(){
        Set<BienSeleccion>retorno=new TreeSet<>();
        Collection<BienEconomico>listadoBienes=adminEntidad.listarBienEconomico(rucCompañia);
        for(BienEconomico b:listadoBienes){
            BienSeleccion bs=new BienSeleccion();
            bs.setCodigo(b.getCodigo());
            bs.setDescripcion(b.getDescripcion());
            bs.setSeleccionado(false);
            retorno.add(bs);
        }
        
        return retorno;
    }
}
