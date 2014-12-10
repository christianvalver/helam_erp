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
import ec.com.vipsoft.erp.abinadi.dominio.BienEconomico;
import ec.com.vipsoft.erp.abinadi.dominio.Producto;
import ec.com.vipsoft.erp.abinadi.dominio.Servicio;
import ec.com.vipsoft.erp.abinadi.logica.AdministradorEntidad;
import ec.com.vipsoft.erp.abinadi.managedbeans.SesionUsuario;
import java.util.List;
import javax.annotation.PostConstruct;
//import ec.com.vipsoft.erp.abinadi.websesion.SessionUsuario;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author chrisvv
 */

@CDIView("bys")
public class ProductoYServiciosView extends VerticalLayout implements View{

    public static final String PRODUCTO="producto";
    public static final String SERVICIO="servicio";
    @Inject    
    SesionUsuario sesion;
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
    private final TablaBienesYServicios tablaBienesYServicios;
    public ProductoYServiciosView() {
        super();
        setMargin(true);
        ruc=new TextField();
        codigoIVA=new TextField();
        codigoIVA.setWidth("40px");
        codigoIVA.setMaxLength(2);
        codigoICE=new TextField();
        codigoICE.setWidth("55px");
        codigoICE.setMaxLength(4);
        codigo=new TextField();
        codigo.setWidth("70px");
        codigo.setMaxLength(6);
        codigo.setRequired(true);
        codigoAlterno=new TextField();
        codigoAlterno.setWidth("70px");
        codigoAlterno.setMaxLength(6);
        descripcion=new TextField();
        descripcion.setRequired(true);
        descripcion.setWidth("100%");
        descripcion.setNullSettingAllowed(false);
                
        HorizontalLayout linea1=new HorizontalLayout();
        //HorizontalLayout linea2=new HorizontalLayout();
        linea1.setSpacing(true);
        //linea2.setSpacing(true);
        registrar=new Button("registrar");
        registrar.addStyleName("primary");
//        linea1.addComponent(new Label("ruc"));
//        linea1.addComponent(ruc);
        linea1.addComponent(new Label("código IVA"));
        linea1.addComponent(codigoIVA);
        linea1.addComponent(new Label("código ICE"));
        linea1.addComponent(codigoICE);
        linea1.addComponent(new Label("código"));
        linea1.addComponent(codigo);
        linea1.addComponent(new Label("código alterno"));
        linea1.addComponent(codigoAlterno);
        linea1.addComponent(new Label("descripción"));
        linea1.addComponent(descripcion);
        productoservicio=new OptionGroup();
        productoservicio.addItem(PRODUCTO);
        productoservicio.addItem(SERVICIO);
        productoservicio.setItemCaption(PRODUCTO, "producto");
        productoservicio.setItemCaption(SERVICIO, "servicio");
        productoservicio.setMultiSelect(false);
        linea1.addComponent(productoservicio);
        linea1.addComponent(registrar);
        linea1.setMargin(true);
        //linea2.setMargin(true);
        addComponent(linea1);
        tablaBienesYServicios=new TablaBienesYServicios();
        tablaBienesYServicios.setSizeFull();
        tablaBienesYServicios.setMultiSelect(false);
                
        addComponent(tablaBienesYServicios);
         registrar.addClickListener(new Button.ClickListener() {

            @Override
             public void buttonClick(Button.ClickEvent event) {
                 //validacion
                 if ((codigoIVA.getValue() == null) || (codigo.getValue() == null) || (descripcion.getValue() == null)|| (descripcion.getValue().length()==0) ) {
                     Notification.show("debe llenar campos codigo, iva, descripcion", Notification.Type.ERROR_MESSAGE);
                 } else {
                     BienEconomico p;
                     String tipoSeleccionado = (String) productoservicio.getValue();
                     if (tipoSeleccionado.equalsIgnoreCase(PRODUCTO)) {
                         p = new Producto();
                     } else {
                         p = new Servicio();
                     }
                     
                     p.setCodigo(codigo.getValue());
                     p.setDescripcion(descripcion.getValue());
                     p.setCodigoICE(codigoICE.getValue());
                     p.setCodigoIVA(codigoIVA.getValue());
                     
                     amdinistrador.crearBienEconomico(p, sesion.getRucCompañia());
                     Notification.show("registrado");
                     Integer _codigo = Integer.parseInt(codigo.getValue());                     
                     codigo.setValue(String.valueOf(_codigo + 1));
                     codigoAlterno.setValue("");
                     descripcion.setValue(null);
                     tablaBienesYServicios.anadirLinea(p);
                 }

               // if(productoservicio.getItem("producto").getItemProperty(""))

                //Producto p=new Producto();
                
                //tablaBienesYServicios.anadir(amdinistrador.listarBienesEconomicos(sesion.getRucCompañia()));
                
            }
        });
        //ruc.setValue(sesion.getRuc());
    }

    @PostConstruct
    public void postconstruir(){
       
    }
    
  
    
    Navigator navigator;
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        navigator=event.getNavigator();
        List<BienEconomico>lista=amdinistrador.listarBienesEconomicos(sesion.getRucCompañia());
        tablaBienesYServicios.limpiar();
        tablaBienesYServicios.anadir(lista);
        
    }
    
}
