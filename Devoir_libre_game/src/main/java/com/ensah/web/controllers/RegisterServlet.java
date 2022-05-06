package com.ensah.web.controllers;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.ensah.bo.User;
import com.ensah.dao.IGameDataManagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * cette permet d'enregistrer un utilisateur
 */

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String form = "/WEB-INF/vues/pages/register.jsp";
		// redirection au formulaire d'inscription
		request.getRequestDispatcher(form).forward(request, response);
	}
	/**
	 *  cette va permettere de faire l'inscription de user 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String loginPage = "/WEB-INF/vues/pages/login.jsp";
		String form = "/WEB-INF/vues/pages/register.jsp";
		
		String nom = (String) request.getParameter("nom");
		String prenom =(String) request.getParameter("prenom");
		String login = (String) request.getParameter("login");
		String password = (String) request.getParameter("password");
		
		//TODO verify the data sented by the user ,and insert an error a message error in the request 
		
		// creating a user object
		User user = new User();
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setLogin(login);
		user.setPassword(password);
		
		// 
		IGameDataManagement mg = (IGameDataManagement) getServletContext().getAttribute("gameData") ;
		// if the user doesn't exist in the users list , then add him 
		if(mg.getUserByLogin(login) == null) {
			mg.insertUser(user);
			
			// redirection toward the login page 
			request.getRequestDispatcher(loginPage).forward(request, response);
			
		}else {
			
			// sinon , on le redirege vers la meme page avec un message d'erreur 
			request.getRequestDispatcher(form).forward(request, response);

		}
		
		System.out.println(mg.getAllUsers());
		

	}

}
