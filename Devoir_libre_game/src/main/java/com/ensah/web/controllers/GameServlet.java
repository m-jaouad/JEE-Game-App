package com.ensah.web.controllers;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import java.util.Map;
import java.util.Random;

import com.ensah.bo.GameState;
import com.ensah.bo.User;
import com.ensah.dao.IGameDataManagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * cette va implemente les regles de jeu
 */
@WebServlet("/auth/play")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IGameDataManagement mg ;
	@Override
		public void init() throws ServletException {
			mg = (IGameDataManagement) getServletContext().getAttribute("gameData") ;
		}
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userPage = "/WEB-INF/vues/auth/userHome.jsp";

		request.getRequestDispatcher(userPage).forward(request, response);
	}

	public void gameOver(int score, GameState gameState, User user, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// le joueur reçoit un score
		gameState.setScore(score);

		
		String gameOverPage = "/WEB-INF/vues/auth/gameOver.jsp";
		
		// on update le best score
		user.setBestScore(Math.max(score, user.getBestScore()));
		
		//on update the best score aussi au niveau le support de stockage
		mg.updateScore(user);
		
		// on redirege a la page de fin de partie de jeu
		request.getRequestDispatcher(gameOverPage).forward(request, response);

		// on arrete la partie de jeu i.e on reintialise la state game
		gameState.reset();

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userPage = "/WEB-INF/vues/auth/userHome.jsp";

		int deNumber = Integer.parseInt(request.getParameter("number"));

		// stocker le number de de dans la state game de user

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		GameState gameState = (GameState) request.getSession().getAttribute("gameState");

		Map<Integer, Integer> lancedNumbers = gameState.getLancedNumbers();

		// on verifie si le nombre lancée est lancé i.e il est deja dans le map
		// lancedNumbers

		if (lancedNumbers.containsKey(deNumber)) {
			gameOver(-1, gameState, user, request, response);
			
			return ;

		} else {
			// on génère un nombre aleatoire
			int rand = new Random().nextInt(1, 7);

			System.out.println("dé number " + deNumber + " : " + rand);

			// on verifier si le condition d'arrete est verifiée
			for (Integer number : lancedNumbers.keySet()) {
				// dans ce cas , on doit arretée la partie de jeu
				if (number < deNumber && lancedNumbers.get(number) >= rand) {
					gameState.setScore(0);
					gameState.setGameOver(true);
					System.out.println("condition verifiée");
					break;
				}
			}

			if (gameState.isGameOver()) {
				gameOver(0, gameState, user, request, response);

				return;
			}
			// donc le number de n'est repete ,et la condition d'arrete n'est pas verifiée ,
			// alors on ajout le dé
			lancedNumbers.put(deNumber, rand);

			if (lancedNumbers.size() == 3) {
				// on calcule le score
				int score = 0;
				for (int i = 1; i <= 3; ++i) {
					score += lancedNumbers.get(i);
				}
				gameOver(score, gameState, user, request, response);
				return;

			}

		}

		request.getRequestDispatcher(userPage).forward(request, response);

	}

}
