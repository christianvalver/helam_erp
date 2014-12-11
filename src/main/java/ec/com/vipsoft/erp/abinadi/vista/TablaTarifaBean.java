/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.vista;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author chrisvv
 */
public class TablaTarifaBean implements Serializable,Comparable<TablaTarifaBean>{

    private Boolean esTarifaDefecto;
    private String nombreTarifa;
    private Boolean usaPorcentaje;
    private BigDecimal porcentajeRespectoATarifaDefault;
    private Boolean esActiva;

    public Boolean getEsActiva() {
        return esActiva;
    }

    public void setEsActiva(Boolean esActiva) {
        this.esActiva = esActiva;
    }

    public Boolean getEsTarifaDefecto() {
        return esTarifaDefecto;
    }

    public void setEsTarifaDefecto(Boolean esTarifaDefecto) {
        this.esTarifaDefecto = esTarifaDefecto;
    }

    public String getNombreTarifa() {
        return nombreTarifa;
    }

    public void setNombreTarifa(String nombreTarifa) {
        this.nombreTarifa = nombreTarifa;
    }

    public Boolean getUsaPorcentaje() {
        return usaPorcentaje;
    }

    public void setUsaPorcentaje(Boolean usaPorcentaje) {
        this.usaPorcentaje = usaPorcentaje;
    }

    public BigDecimal getPorcentajeRespectoATarifaDefault() {
        return porcentajeRespectoATarifaDefault;
    }

    public void setPorcentajeRespectoATarifaDefault(BigDecimal porcentajeRespectoATarifaDefault) {
        this.porcentajeRespectoATarifaDefault = porcentajeRespectoATarifaDefault;
    }
    
    @Override
    public int compareTo(TablaTarifaBean o) {
        
        int retorno=esTarifaDefecto.compareTo(o.esTarifaDefecto);
        if(retorno!=0){
            retorno=retorno*(-1);
        }else{
            retorno=nombreTarifa.compareToIgnoreCase(o.nombreTarifa);
        }
        
         return retorno;   
    }
    
    
}
