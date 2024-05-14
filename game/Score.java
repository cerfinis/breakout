package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score {

	static int score = 0;
	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	
	Score(int GAME_WIDTH, int GAME_HEIGHT) {
		
		Score.GAME_WIDTH = GAME_WIDTH;
		Score.GAME_HEIGHT = GAME_HEIGHT;
		
	}
	
	// function name: classicScore()
    // description: adds points to existing score
    // parameters: int: record
    // return: none
	public static void classicScore(int record) {
		
		score = score + record;
	}
	
	 // function name: draw()
    // description: draws score on screen
    // parameters: Graphics: g
    // return: none
	public void draw(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 100));
		
		int y = 70;
		
	    g.drawString(String.valueOf(score), GAME_WIDTH/2, y);
	    
	}

}
