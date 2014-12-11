/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.vista;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;

/**
 *
 * @author chrisvv
 */
public class TablaTarifa extends Table {

    public TablaTarifa() {
        super();
        setContainerDataSource(contenedor);
        
    }
    BeanItemContainer<TablaTarifaBean>contenedor=new BeanItemContainer<>(TablaTarifaBean.class);

    public BeanItemContainer<TablaTarifaBean> getContenedor() {
        return contenedor;
    }

    public void setContenedor(BeanItemContainer<TablaTarifaBean> contenedor) {
        this.contenedor = contenedor;
    }
    
    
}
