/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vipsoft.erp.abinadi.webListeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;

/**
 * Web application lifecycle listener.
 *
 * @author chrisvv
 */
public class ActivitiContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /// ProcessEngines.init();
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
        //repositoryService.createDeployment().name("").<
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ProcessEngines.destroy();
    }
}
