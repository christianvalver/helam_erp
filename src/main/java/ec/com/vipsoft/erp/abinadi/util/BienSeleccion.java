/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.util;

import java.io.Serializable;

/**
 *
 * @author chrisvv
 */
public class BienSeleccion implements Serializable,Comparable<BienSeleccion>{

    private Boolean seleccionado;
    private String codigo;
    private String descripcion;

    public Boolean getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public int compareTo(BienSeleccion o) {
        int retorno = seleccionado.compareTo(o.seleccionado);
        if (retorno == 0) {
            retorno = descripcion.compareToIgnoreCase(o.descripcion);
            if (retorno == 0) {
                retorno = codigo.compareToIgnoreCase(o.codigo);
            }
        }
        return retorno;
    }
    
}
