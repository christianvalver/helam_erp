
package ec.com.vipsoft.erp.abinadi.vista;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import javax.annotation.PostConstruct;

/**
 *
 * @author chrisvv
 */
@CDIView("")
public class MenuVista  extends VerticalLayout implements View{
    private final HorizontalLayout linea1;
    private final Button facturacion;

    private final Button bienesYServicios;
    
    public MenuVista() {
        super();
        setMargin(true);
        linea1=new HorizontalLayout();
        linea1.setMargin(true);
        linea1.setSizeFull();
        facturacion=new Button("Facturación");

        linea1.addComponent(facturacion);
        bienesYServicios=new Button("Bienes y servicios");
        linea1.addComponent(bienesYServicios);
        
        addComponent(linea1);
        
    }

    
    @PostConstruct
            
    public void despuesConstructor(){
           facturacion.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                navegador.navigateTo("FacturacionCliente");
            }
        });
           bienesYServicios.addClickListener(new Button.ClickListener() {

               @Override
               public void buttonClick(Button.ClickEvent event) {
                   navegador.navigateTo("bys");
               }
           });
    }       
    Navigator navegador;
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        navegador=event.getNavigator();
    }
    
}
