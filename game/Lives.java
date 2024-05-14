package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.*;

public class Lives {
	
	static int lives = 3;
	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	
	Lives(int GAME_WIDTH, int GAME_HEIGHT) {
		
		Lives.GAME_WIDTH = GAME_WIDTH;
		Lives.GAME_HEIGHT = GAME_HEIGHT;
		
	}
	
	 // function name: draw()
    // description: draws lives on screen
    // parameters: Graphics: g
    // return: none
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 30));
		
		g.drawString(String.valueOf(lives + " LIVES REMAINING"), 20, 40);
	
	}
}
