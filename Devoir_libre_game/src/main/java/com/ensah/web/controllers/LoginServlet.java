package com.ensah.web.controllers;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.ensah.bo.GameState;
import com.ensah.bo.Message;
import com.ensah.bo.User;
import com.ensah.dao.IGameDataManagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/vues/pages/login.jsp").forward(request, response);
	}

	/**
	 * cette permet de loguer un user
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginPage = "/WEB-INF/vues/pages/login.jsp";
		String userHome = "/WEB-INF/vues/auth/userHome.jsp";
		
		String login = ((String) request.getParameter("login")).trim();

		String password = (String) request.getParameter("password");
		
		//TODO verifier les données submitted by the user 
		
		IGameDataManagement mg = (IGameDataManagement) getServletContext().getAttribute("gameData") ;
		User user = mg.getUserByLogin(login) ;
		if(user != null) {
			if(user.getPassword().equals(password)) {
				
				// on stocke le user dans sa session 
				request.getSession().setAttribute("user", user);
				
				// on stocke aussi la partie du jeu dans la session
				request.getSession().setAttribute("gameState", new GameState());
				
				// le rediriger vers la page de jeu
				request.getRequestDispatcher(userHome).forward(request, response);
			}else {
				// le redireger vers le meme page avec un message d'erreur 
				Message message = new Message("login ou mot de  pass incorrect", 2);
				request.setAttribute("msg", message);
				request.getRequestDispatcher(loginPage).forward(request, response);
			}
		}else {
			// le redireger vers le meme page avec un message d'erreur 
			Message message = new Message("login ou mot de  pass incorrect", 2);
			request.setAttribute("msg", message);
			request.getRequestDispatcher(loginPage).forward(request, response);
		}
		
		System.out.println(mg.getAllUsers());
	}

}
