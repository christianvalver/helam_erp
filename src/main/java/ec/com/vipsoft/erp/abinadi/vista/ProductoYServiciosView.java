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
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import ec.com.vipsoft.erp.abinadi.dominio.Producto;
import ec.com.vipsoft.erp.abinadi.logica.AdministradorEntidad;
import javax.ejb.EJB;

/**
 *
 * @author chrisvv
 */

@CDIView("bys")
public class ProductoYServiciosView extends VerticalLayout implements View{

    @EJB
    AdministradorEntidad amdinistrador;
    private final TextField ruc;
    private final TextField codigoICE;
    private final TextField codigoIVA;
    private final TextField codigo;
    private final TextField codigoAlterno;
    private final TextField descripcion;
    private final Button registrar;
    private final OptionGroup productoservicio;
    public ProductoYServiciosView() {
        super();
        ruc=new TextField();
        codigoIVA=new TextField();
        codigoICE=new TextField();
        codigo=new TextField();
        codigoAlterno=new TextField();
        descripcion=new TextField();
        HorizontalLayout linea1=new HorizontalLayout();
        HorizontalLayout linea2=new HorizontalLayout();
        linea1.setSpacing(true);
        linea2.setSpacing(true);
        registrar=new Button("registrar");
        linea1.addComponent(new Label("ruc"));
        linea1.addComponent(ruc);
        linea1.addComponent(new Label("código IVA"));
        linea1.addComponent(codigoIVA);
        linea1.addComponent(new Label("código ICE"));
        linea1.addComponent(codigoICE);
        linea2.addComponent(new Label("código"));
        linea2.addComponent(codigo);
        linea2.addComponent(new Label("código alterno"));
        linea2.addComponent(codigoAlterno);
        linea2.addComponent(new Label("descripción"));
        linea2.addComponent(descripcion);
        productoservicio=new OptionGroup();
        productoservicio.addItem("producto");
        productoservicio.addItem("servicio");
        productoservicio.setItemCaption("producto", "producto");
        productoservicio.setItemCaption("servicio", "servicio");
        productoservicio.setMultiSelect(false);
        
        linea2.addComponent(registrar);
        linea1.setMargin(true);
        linea2.setMargin(true);
        addComponent(linea1);
        addComponent(linea2);
        registrar.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {                
               // if(productoservicio.getItem("producto").getItemProperty(""))
                
                Producto p=new Producto();
                p.setCodigo(codigo.getValue());
                p.setDescripcion(descripcion.getValue());
                p.setCodigoICE(codigoICE.getValue());
                p.setCodigoIVA(codigoIVA.getValue());
                amdinistrador.crearBienEconomico(p ,ruc.getValue());
                Notification.show("registrado");
                Integer _codigo=Integer.parseInt(codigo.getValue());                
                codigo.setValue(String.valueOf(_codigo+1));
                codigoAlterno.setValue("");
                descripcion.setValue("");
                
            }
        });
    }

    
    Navigator navigator;
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        navigator=event.getNavigator();
    }
    
}
