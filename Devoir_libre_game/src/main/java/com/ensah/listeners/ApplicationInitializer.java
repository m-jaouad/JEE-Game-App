package com.ensah.listeners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.ensah.bo.User;
import com.ensah.dao.DataManagementFactory;
import com.ensah.dao.IGameDataManagement;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationInitializer
 * 
 * cette class a pour objectif d'initializer une list , et la mettre dans le context , une fois que l'application a demarre 
 * 
 * la liste est thred-safe 
 *
 */
@WebListener
public class ApplicationInitializer implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ApplicationInitializer() {
    	
    }
    
     public void contextInitialized(ServletContextEvent sce) {
     	ServletContext ctx = sce.getServletContext();
     	
    	String type = ctx.getInitParameter("type_stockage");

		IGameDataManagement gameData = DataManagementFactory.getFactory(type, ctx);

		ctx.setAttribute("gameData", gameData);
     	
     	// liste thread safe  	
    	List<User>  userList = Collections.synchronizedList(new ArrayList<User>());
    	
    //	userList.add(new User("JAOUAD", "MOSTAFA", "MOSTAFA", "123", 0));
    	
    	ctx.setAttribute("users", userList);

     }

	
}