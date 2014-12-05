
package ec.com.vipsoft.erp.abinadi.vista;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author chrisvv
 */
@CDIView("menu")
public class MenuVista  extends VerticalLayout implements View{
    private final HorizontalLayout linea1;
    private final Button facturacion;

    public MenuVista() {
        super();
        setMargin(true);
        linea1=new HorizontalLayout();
        linea1.setMargin(true);
        linea1.setSizeFull();
        facturacion=new Button("Facturación");
        facturacion.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                navegador.navigateTo("FacturacionCliente");
            }
        });
        linea1.addComponent(facturacion);
        
        addComponent(linea1);
        
    }

    
    Navigator navegador;
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        navegador=event.getNavigator();
    }
    
}
