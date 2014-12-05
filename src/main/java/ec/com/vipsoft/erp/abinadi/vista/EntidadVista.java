/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.vista;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import ec.com.vipsoft.erp.abinadi.logica.AdministradorEntidad;
import ec.com.vipsoft.erp.abinadi.websesion.SesionUsuario;
import javax.annotation.PostConstruct;
//import ec.com.vipsoft.erp.abinadi.websesion.SessionUsuario;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author chrisvv
 */

@CDIView("")
public class EntidadVista extends HorizontalLayout implements View {
    private final TextField ruc;
    private final TextField razonSocial;
    private final TextField nombreComerical;
    private final Button registrar;
    private Navigator navigator;
    @Inject
    private SesionUsuario sesionUsuario;

    @EJB
    private AdministradorEntidad administradorEntidad;
    //@Inject  SessionUsuario sesion;
    public EntidadVista() {
        super();
      //  setSizeFull();
        setMargin(true);
        setSpacing(true);
                
        ruc=new TextField();
        razonSocial=new TextField();
        nombreComerical=new TextField();
        registrar=new Button("registrar");
        addComponent(new Label("ruc"));
        addComponent(ruc);
        addComponent(new Label("razón social"));
        addComponent(razonSocial);
        addComponent(new Label("nombre comercial"));
        addComponent(nombreComerical);
        addComponent(registrar);
      
        //ponemos los valores cargados por defecto 
        //
    }

    @PostConstruct
    public void despuesConstructor(){
          registrar.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                administradorEntidad.registrarEntidad(ruc.getValue(), razonSocial.getValue(),nombreComerical.getValue());
                administradorEntidad.postregistrarEntidad(ruc.getValue());
                 //ruc.setValue;   
                sesionUsuario.setRucCompañia(ruc.getValue());
    //sesion.setRuc(ruc.getValue());
                    Notification.show("se ha grabado una entidad con id ");
                    ruc.setValue("");
                    razonSocial.setValue("");
                    nombreComerical.setValue("");
                    navigator.navigateTo("bys");
                    
            }
        });
    }
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        navigator=event.getNavigator();
    }
    
}
