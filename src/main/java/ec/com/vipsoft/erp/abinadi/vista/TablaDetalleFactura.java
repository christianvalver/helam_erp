/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.vista;

import com.vaadin.ui.Label;
import com.vaadin.ui.Table;

/**
 *
 * @author chrisvv
 */
public class TablaDetalleFactura extends Table {

    public TablaDetalleFactura() {
        super();
        addContainerProperty("Cantidad", Label.class, "");
        addContainerProperty("Código", Label.class, "");
        addContainerProperty("Descripción",Label.class,"");
        addContainerProperty("Valor Unitario", Label.class, "");
        addContainerProperty("Descuento", Label.class, "");
        addContainerProperty("Total", Label.class, "");
    }
    
    
}
