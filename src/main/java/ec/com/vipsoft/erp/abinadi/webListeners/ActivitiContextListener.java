/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.webListeners;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipInputStream;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.util.ReflectUtil;

/**
 * Web application lifecycle listener.
 *
 * @author chrisvv
 */
public class ActivitiContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {                
       LOG.info("<------------------------  INICIANDO LA APPLICACION ABINADI_ERP ---------------------->");
       LOG.info("<------------------------  INICIANDO LA APPLICACION ABINADI_ERP ---------------------->");
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();        
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();                   
        repositoryService.createDeployment().addInputStream("factura_inventario_contabilidad", sce.getServletContext().getResourceAsStream("/WEB-INF/factura_inventario_contabilidad.bpmn")).deploy();            
        LOG.info("<------------------------  PROCESOS DESPLEGADOS ---------------------->");
    }
    private static final Logger LOG = Logger.getLogger(ActivitiContextListener.class.getName());

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ProcessEngines.destroy();
    }
}
