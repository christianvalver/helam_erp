/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.vista;

import com.vaadin.ui.CheckBox;

/**
 *
 * @author chrisvv
 */
public class Selecto extends CheckBox{

    public Selecto() {
        super();
        setCaption("");
        setValue(false);
    }
    
    
    public static Selecto construirDefault(){
        return new Selecto();
    }

    Selecto(Boolean seleccionado) {
        super();
        setCaption("");
        setValue(seleccionado);
    }
    
}
