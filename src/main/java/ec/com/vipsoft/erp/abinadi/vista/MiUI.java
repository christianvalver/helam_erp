/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.vista;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import javax.inject.Inject;

/**
 *
 * @author chrisvv
 */

@CDIUI("")
@Theme("mytheme")
public class MiUI extends UI{
    private Navigator navigator=new Navigator(this,this);

    public MiUI() {
        
    }
    
    @Inject
    CDIViewProvider viewProvider;
    @Override
    protected void init(VaadinRequest request) {
        navigator.addProvider(viewProvider);
     //   navigator.addView("", EntidadVista.class);
      //  setContent(this);
    }
    
}
