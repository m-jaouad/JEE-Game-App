package com.ensah.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameState {
	
	
	private boolean gameOver = false ;
	
	Map<Integer, Integer> lancedNumbers = new HashMap<>(3);
	
	private int score ;
	
	
	public void reset() {
		gameOver = false ;
		lancedNumbers = new HashMap<>(3);
		setScore(0);
	}

	public GameState() {
		
	}
	

	


	public Map<Integer, Integer> getLancedNumbers() {
		return lancedNumbers;
	}

	public void setLancedNumbers(Map<Integer, Integer> lancedNumbers) {
		this.lancedNumbers = lancedNumbers;
	}





	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	
}
