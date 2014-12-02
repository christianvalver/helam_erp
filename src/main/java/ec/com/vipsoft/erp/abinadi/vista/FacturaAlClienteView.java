/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.vista;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.Date;

/**
 *
 * @author chrisvv
 */
public class FacturaAlClienteView extends VerticalLayout implements View{

    private Navigator navigator;

    private Button labelRUC;
    private TextField rucIDTextField;
    private Label razonSocialLabel;
    private TextField razonSocialTextField;
    private HorizontalLayout linea1;
    private Label numeroFacturaLabel;
    private TextField numeroFacturaCliente;
    private HorizontalLayout linea2;
    private Label telefonoClienteLabel;
    private TextField telefonoClienteTextField;
    private Label direccionClienteLabel;
    private TextField direccionClineteTextField;
    private PopupDateField fechaLabel;
    private PopupDateField fechaClienteLabel;
    private PopupDateField fechaClientePopUpddate;
    private Label fechaClientelabel;
    private HorizontalLayout linea3;
    private TextField cantidadClienteTextField;
    private Label cantidadLabel;
    private Label productoLabel;
    private TextField productoClienteTextField;
    private Button buscarProductoCliente;
    private Button anadirProductoCliente;
    private Button registrarFacturaCliente;
    private Button cancelarFacturaCliente;
    private HorizontalLayout linea4;
    private Label subtotalRotulo;
    private Label subtotal;
    private Label totalIva0;
    private Label totalIva0Rotulo;
    private Label totalIva12Rotulo;
    private Label iva12;
    private Label total;
    private Label totalRotulo;
    private TablaDetalleFactura tablaDetalleCliente;
    private Label saldoRotulo;
    private Label saldo;

    public FacturaAlClienteView(){
        
        super();
        labelRUC=new Button("RUC/ID");
        
        rucIDTextField=new TextField();
        rucIDTextField.setInputPrompt("09999999999001");
        razonSocialLabel=new Label("Razón Social");
        razonSocialTextField=new TextField();
        razonSocialTextField.setWidth("100%");
        razonSocialTextField.setInputPrompt("Roberto Gòmez Bolaños");
        numeroFacturaLabel=new Label("Factura Nº");
        numeroFacturaCliente=new TextField();
        numeroFacturaCliente.setInputPrompt("001-001-0000235");
        linea1=new HorizontalLayout();
        linea1.setSizeFull();
        //linea1.setMargin(true);
        linea1.setSpacing(true);
        linea1.addComponent(labelRUC);
        linea1.addComponent(rucIDTextField);
        linea1.addComponent(razonSocialLabel);
        linea1.addComponent(razonSocialTextField);
        linea1.addComponent(numeroFacturaLabel);
        linea1.addComponent(numeroFacturaCliente);
        linea1.setExpandRatio(labelRUC, 1);
        linea1.setExpandRatio(rucIDTextField, 2);
        linea1.setExpandRatio(razonSocialLabel, 1);
        linea1.setExpandRatio(razonSocialTextField, 4);
        linea1.setExpandRatio(numeroFacturaLabel, 1);
        linea1.setExpandRatio(numeroFacturaCliente, 2);
        
        linea2=new HorizontalLayout();
        linea2.setSizeFull();
        //linea2.setMargin(true);
        linea2.setSpacing(true);
        telefonoClienteLabel=new Label("Teléfono:");
        telefonoClienteTextField=new TextField();
        telefonoClienteTextField.setInputPrompt("042-5555555");
        direccionClienteLabel=new Label("Dirección");
        direccionClineteTextField=new TextField();
        direccionClineteTextField.setWidth("100%");
        direccionClineteTextField.setInputPrompt("Cdla. Las avas mz 125 solar 4");
        fechaClientelabel=new Label("Fecha");
        fechaClientePopUpddate=new PopupDateField();
        fechaClientePopUpddate.setValue(new Date());
        fechaClientePopUpddate.setDateFormat("dd/MM/yyyy");
        linea2.addComponent(telefonoClienteLabel);
        linea2.addComponent(telefonoClienteTextField);
        linea2.addComponent(direccionClienteLabel);
        linea2.addComponent(direccionClineteTextField);
        linea2.addComponent(fechaClientelabel);
        linea2.addComponent(fechaClientePopUpddate);
        linea2.setExpandRatio(telefonoClienteLabel, 1);
        linea2.setExpandRatio(telefonoClienteTextField, 2);
        linea2.setExpandRatio(direccionClienteLabel, 1);
        linea2.setExpandRatio(direccionClineteTextField, 4);
        linea2.setExpandRatio(fechaClientelabel, 1);
        linea2.setExpandRatio(fechaClientePopUpddate, 2);
        
        
        linea3=new HorizontalLayout();
        linea3.setSizeFull();
        linea3.setSpacing(true);
        linea3.setMargin(true);
        cantidadLabel=new Label("Cantidad");
        cantidadClienteTextField=new TextField();
        cantidadClienteTextField.setInputPrompt("1.00");
        productoLabel=new Label("Producto");
        productoClienteTextField=new TextField();
        productoClienteTextField.setWidth("100%");
        buscarProductoCliente=new Button("...");
         
        anadirProductoCliente=new Button("+");
        registrarFacturaCliente=new Button("Registrar");
        cancelarFacturaCliente=new Button("Cancelar");
        
        linea3.addComponent(cantidadLabel);
        linea3.addComponent(cantidadClienteTextField);
        linea3.addComponent(productoLabel);
        linea3.addComponent(productoClienteTextField);
        linea3.addComponent(buscarProductoCliente);
        linea3.addComponent(anadirProductoCliente);        
        linea3.addComponent(registrarFacturaCliente);
        linea3.addComponent(cancelarFacturaCliente);
        
        linea3.setExpandRatio(cantidadLabel, 2);
        linea3.setExpandRatio(cantidadClienteTextField, 4);
        linea3.setExpandRatio(productoLabel, 2);
        linea3.setExpandRatio(productoClienteTextField, 6);
        linea3.setExpandRatio(anadirProductoCliente, 1);
        linea3.setExpandRatio(buscarProductoCliente, 1);
        linea3.setExpandRatio(registrarFacturaCliente,2);
        linea3.setExpandRatio(cancelarFacturaCliente, 2);
        
        
        //linea de subtotal --total 
        linea4=new HorizontalLayout();
        linea4.setSizeFull();
        linea4.setMargin(true);
        subtotalRotulo=new Label("Subtotal");
        subtotal=new Label("$0.00");
        totalIva0Rotulo=new Label("IVA 0%");
        totalIva0=new Label("$0.00");
        totalIva12Rotulo=new Label("IVA 12%");
        iva12=new Label("$0.00");
        totalRotulo=new Label("Total");
        total=new Label("$0.00");
        
        
        linea4.addComponent(subtotalRotulo);
        linea4.addComponent(subtotal);
        linea4.addComponent(totalIva0Rotulo);
        linea4.addComponent(totalIva0);
        linea4.addComponent(totalIva12Rotulo);
        linea4.addComponent(iva12);
        linea4.addComponent(totalRotulo);
        linea4.addComponent(total);
        saldoRotulo=new Label("Saldo");
        saldo=new Label("$0.00");
        linea4.addComponent(saldoRotulo);
        linea4.addComponent(saldo);
        tablaDetalleCliente=new TablaDetalleFactura();
        tablaDetalleCliente.setSizeFull();
        addComponent(linea1);
        addComponent(linea2);
        addComponent(linea3);
        addComponent(linea4);
        addComponent(tablaDetalleCliente);
        setExpandRatio(linea1, 2);
        setExpandRatio(linea2, 2);
        setExpandRatio(linea3, 2);
        setExpandRatio(linea4, 2);
        setExpandRatio(tablaDetalleCliente, 10);
        setComponentAlignment(linea4, Alignment.TOP_CENTER);
    }
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        navigator=event.getNavigator();
    }
    
}
