/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.vista;

import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import ec.com.vipsoft.erp.abinadi.dominio.BienEconomico;

/**
 *
 * @author chrisvv
 */
public class TablaBienesYServicios extends Table{

    public TablaBienesYServicios() {
        super();
        addContainerProperty("Código", Label.class,"");
        addContainerProperty("Código alterno", Label.class, "");
        addContainerProperty("IVA", Label.class, "");
        addContainerProperty("ICE", Label.class, "");
        addContainerProperty("Descripción", Label.class, "");
    }
    public void anadirLinea(BienEconomico bien){
        
    }
    
    
}
