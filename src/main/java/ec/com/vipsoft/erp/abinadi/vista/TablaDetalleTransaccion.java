/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.vista;

import com.vaadin.data.Item;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;

/**
 *
 * @author chrisvv
 */
public class TablaDetalleTransaccion extends Table{

    public TablaDetalleTransaccion() {
        super();
        addContainerProperty("código", Label.class, "");
        addContainerProperty("descripción", Label.class, "");
        addContainerProperty("débito", Label.class, "");
        addContainerProperty("crédito", Label.class,"");
    }

    void anadirDebito(String codi, String monto) {
       
        Object newItemId =addItem();
        Item row1 = getItem(newItemId);
        row1.getItemProperty("código").setValue(new Label(codi));
        row1.getItemProperty("débito").setValue(new Label(monto));
        row1.getItemProperty("crédito").setValue(new Label("    "));
        
    }

    void anadirCredito(String cuenta, String codi) {                
        Object newItemId =addItem();
        Item row1 = getItem(newItemId);
        row1.getItemProperty("código").setValue(new Label(cuenta));
        row1.getItemProperty("débito").setValue(new Label("   "));
        row1.getItemProperty("crédito").setValue(new Label(codi));
        
    }
    
    
    
}
