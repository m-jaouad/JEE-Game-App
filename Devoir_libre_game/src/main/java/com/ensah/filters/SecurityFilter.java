package com.ensah.filters;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

/**
 * ce filter permet de verifier si l'utilisatuer est deja authentifie
 */
public class SecurityFilter extends HttpFilter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			System.out.println("filter serurite here...");
		// on recupere la session 
		HttpSession session = ((HttpServletRequest) request).getSession();
		
		// on verifier si deja l'utilisateur est dans la session 
		if(session.getAttribute("user") != null) {
			
			// on laisse passe 
			chain.doFilter(request, response);
		}else {
			String loginPage = "/WEB-INF/vues/pages/login.jsp";
			
			// si il est pas authentfier , on le redirige pour faire l'authentification
			getServletContext().getRequestDispatcher(loginPage).forward(request, response);
		}
		
		
	}

}
