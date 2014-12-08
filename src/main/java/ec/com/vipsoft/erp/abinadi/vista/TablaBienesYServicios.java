/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.vista;

import com.vaadin.data.Item;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import ec.com.vipsoft.erp.abinadi.dominio.BienEconomico;
import ec.com.vipsoft.erp.abinadi.dominio.Producto;
import ec.com.vipsoft.erp.abinadi.dominio.Servicio;
import java.util.List;

/**
 *
 * @author chrisvv
 */
public class TablaBienesYServicios extends Table{

    public static final String CODIGO="Código";
    public static final String CODIGOALTERNO="Código alterno";
    public static final String IVA="IVA";
    public static final String ICE="ICE";
    public static final String DESCRIPCION="Descripción";
    public static final String TIPO="Tipo";
    public TablaBienesYServicios() {
        
        super();
        addContainerProperty(CODIGO, Label.class,"");
        addContainerProperty(CODIGOALTERNO, Label.class, "");
        addContainerProperty(IVA, Label.class, "");
        addContainerProperty(ICE, Label.class, "");
        addContainerProperty(DESCRIPCION, Label.class, "");
        addContainerProperty(TIPO, Label.class, "");
        //setColumnWidth("Código",70);
        //setColumnWidth("Código alterno",70);
        //setColumnWidth("IVA",70);
        //setColumnWidth("ICE",70);
        //setColumnWidth("Descripción",150);
        //setColumnWidth("Tipo",70);
        
    }
    public void anadirLinea(BienEconomico bien){
         Object newItemId =addItem();
        Item row1 = getItem(newItemId);
        row1.getItemProperty(CODIGO).setValue(new Label(bien.getCodigo()));
        row1.getItemProperty(CODIGOALTERNO).setValue(new Label(bien.getCodigoAlterno()));
        row1.getItemProperty(IVA).setValue(new Label(bien.getCodigoIVA()));
        row1.getItemProperty(ICE).setValue(new Label(bien.getCodigoICE()));
        row1.getItemProperty(DESCRIPCION).setValue(new Label(bien.getDescripcion()));
        
        if(bien instanceof Servicio){
            row1.getItemProperty(TIPO).setValue(new Label("SERVICIO"));
        }
        if(bien instanceof Producto ){
            row1.getItemProperty(TIPO).setValue(new Label("PRODUCTO"));
        }
    }

    void anadir(List<BienEconomico> lista) {
        for(BienEconomico b:lista){
            anadirLinea(b);
        }
    }

    void limpiar() {
      
    }
    
    
}
