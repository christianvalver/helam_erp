/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.vista;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import ec.com.vipsoft.erp.abinadi.logica.PlanCuentaManager;
import ec.com.vipsoft.erp.abinadi.managedbeans.SesionUsuario;
import javax.ejb.EJB;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 *
 * @author chrisvv
 */

@CDIUI("")
@Theme("mytheme")
@PreserveOnRefresh
public class MiUI extends UI{
    private Navigator navigator=new Navigator(this,this);

    public MiUI() {
        
    }
    @Default
    @Inject                        
    CDIViewProvider viewProvider;
    @EJB
    PlanCuentaManager planCuenta;
    
    @Inject
    SesionUsuario sesionUsuario;
    @Override    
    protected void init(VaadinRequest request) {
        navigator.addProvider(viewProvider);
        if(planCuenta.existeUnaEmpresaRegistrada()){
           sesionUsuario.setRucCompañia(planCuenta.getRucEmpresaXDefecto());
            navigator.navigateTo("");
        }else{
            navigator.navigateTo("entidad");
        }
     //   navigator.addView("", EntidadVista.class);
      //  setContent(this);
    }
    
}
