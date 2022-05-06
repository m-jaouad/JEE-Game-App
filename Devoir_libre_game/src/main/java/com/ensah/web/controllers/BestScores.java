package com.ensah.web.controllers;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import com.ensah.bo.GameState;
import com.ensah.bo.User;
import com.ensah.dao.GameContextManagement;
import com.ensah.dao.IGameDataManagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BestScores
 */
@WebServlet("/auth/bestScores")
public class BestScores extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bestScorePage = "/WEB-INF/vues/auth/bestScores.jsp";
		
		// get the users the users 
		IGameDataManagement mg = (IGameDataManagement) getServletContext().getAttribute("gameData") ;
		
		List<User> users =   mg.getAllUsers() ;
		
		request.setAttribute("users", users);
		
		// pass the users list along with the request the jsp page 
		request.getRequestDispatcher(bestScorePage).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
