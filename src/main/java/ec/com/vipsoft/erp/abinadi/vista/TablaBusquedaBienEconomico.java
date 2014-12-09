/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.vista;

import com.vaadin.data.Item;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import ec.com.vipsoft.erp.abinadi.util.BienSeleccion;
import java.util.Set;

/**
 *
 * @author chrisvv
 */
public class TablaBusquedaBienEconomico extends Table {

    public static final String CODIGO="Código";
    public static final String CODIGOALTERNO="Código alterno";
    public static final String DESCRIPCION="Descripción";
    public static final String SELECCIONAR="Selecto";
    public TablaBusquedaBienEconomico() {
        super();
        addContainerProperty(SELECCIONAR, Selecto.class ,Selecto.construirDefault());
         addContainerProperty(DESCRIPCION ,Label.class, "");
        addContainerProperty(CODIGO,Label.class ,"");
        addContainerProperty(CODIGOALTERNO, Label.class, "");
       
       // setSelectable(true);
      //  setMultiSelect(true);
    }

    void anadir(Set<BienSeleccion> listarBienEconomico) {
        for (BienSeleccion bien : listarBienEconomico) {
            Object newItemId = addItem();
            Item row1 = getItem(newItemId);
            row1.getItemProperty(SELECCIONAR).setValue(new Selecto(bien.getSeleccionado()));
            row1.getItemProperty(CODIGO).setValue(new Label(bien.getCodigo()));
            //row1.getItemProperty(CODIGOALTERNO).setValue(new Label(bien.getCodig));
            row1.getItemProperty(DESCRIPCION).setValue(new Label(bien.getDescripcion()));
        }

    }

    
}
