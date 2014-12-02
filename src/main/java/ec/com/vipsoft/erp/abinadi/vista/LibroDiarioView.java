/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.vista;

import com.vaadin.cdi.CDIView;
import com.vaadin.event.FieldEvents;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.Date;

/**
 *
 * @author chrisvv
 */
@CDIView("libroDiario")
public class LibroDiarioView extends VerticalLayout implements View{
    private final Label fechaLabel;
    private final PopupDateField fechaPopup;
    private final HorizontalLayout linea1;
    private final TextField glosa;
    private final Label glosaLabel;
    private final HorizontalLayout linea2;
    private final HorizontalLayout linea3;
    private final TextField codigo;
    private final OptionGroup tipo;
    private final TextField valor;
    private final TablaDetalleTransaccion tablaDetalle;
    private final Button botonRegistrar;

    public LibroDiarioView() {
        super();
        setSizeFull();
        setMargin(true);
        setSpacing(true);
        fechaLabel=new Label("fecha");
        fechaPopup=new PopupDateField();
        fechaPopup.setValue(new Date());
        fechaPopup.setDescription("ingrese la fecha de la transacción");
        linea1=new HorizontalLayout();
        linea1.addComponent(fechaLabel);
        linea1.addComponent(fechaPopup);
        glosaLabel=new Label("Glosa");
        glosa=new TextField();
        linea2=new HorizontalLayout();
        linea2.addComponent(glosaLabel);
        linea2.addComponent(glosa);
        linea3=new HorizontalLayout();
        codigo=new TextField("Código");
        tipo=new OptionGroup();
        tipo.addItem("debito");
        tipo.addItem("credito");
        tipo.setItemCaption("debito", "Débito");
        tipo.setItemCaption("credito", "Crédito");
        tipo.setMultiSelect(false);
        valor=new TextField("Monto");
        linea3.addComponent(codigo);
        linea3.addComponent(tipo);
        linea3.addComponent(valor);
        botonRegistrar=new Button("Registrar");
        linea3.addComponent(botonRegistrar);
        tablaDetalle=new TablaDetalleTransaccion();
        tablaDetalle.setSizeFull();
        botonRegistrar.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
        boolean debito=false;
                    String tipoSeleccionado=(String )tipo.getValue();
                    if(tipoSeleccionado.equalsIgnoreCase("debito")){
                        debito=true;
                        tablaDetalle.anadirDebito(codigo.getValue(),valor.getValue());
                    }else{
                        tablaDetalle.anadirCredito(codigo.getValue(),valor.getValue());
                    }
                
                
                
            }
        });
        
        
        
        
        
        
        
        addComponent(linea1);
        addComponent(linea2);
        addComponent(linea3);
        addComponent(tablaDetalle);
        
    }

    Navigator navigator;
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
       navigator=event.getNavigator();
    }
    
}
