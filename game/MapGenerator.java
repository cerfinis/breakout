package game;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

public class MapGenerator {
	
	 // function name: classicMode()
    // description: generates a classic map
    // parameters: none
    // return: none

	public static void classicMode() {
		
		GamePanel.BRICK_WIDTH = 50;
		GamePanel.BRICK_HEIGHT = 15;
		
		for (int i = 0; i < 16; i++) 
			GamePanel.bricks.add(new Brick((i*60+25), 100, GamePanel.BRICK_WIDTH, GamePanel.BRICK_HEIGHT, Color.RED));
		for (int i = 0; i < 16; i++) 
			GamePanel.bricks.add(new Brick((i*60+25), 125, GamePanel.BRICK_WIDTH, GamePanel.BRICK_HEIGHT, Color.RED));
		for (int i = 0; i < 16; i++) 
			GamePanel.bricks.add(new Brick((i*60+25), 150, GamePanel.BRICK_WIDTH, GamePanel.BRICK_HEIGHT, Color.ORANGE));
		for (int i = 0; i < 16; i++) 
			GamePanel.bricks.add(new Brick((i*60+25), 175, GamePanel.BRICK_WIDTH, GamePanel.BRICK_HEIGHT, Color.ORANGE));
		for (int i = 0; i < 16; i++) 
			GamePanel.bricks.add(new Brick((i*60+25), 200, GamePanel.BRICK_WIDTH, GamePanel.BRICK_HEIGHT, Color.GREEN));
		for (int i = 0; i < 16; i++) 
			GamePanel.bricks.add(new Brick((i*60+25), 225, GamePanel.BRICK_WIDTH, GamePanel.BRICK_HEIGHT, Color.GREEN));
		for (int i = 0; i < 16; i++) 
			GamePanel.bricks.add(new Brick((i*60+25), 250, GamePanel.BRICK_WIDTH, GamePanel.BRICK_HEIGHT, Color.YELLOW));
		for (int i = 0; i < 16; i++) 
			GamePanel.bricks.add(new Brick((i*60+25), 275, GamePanel.BRICK_WIDTH, GamePanel.BRICK_HEIGHT, Color.YELLOW));
		
		
		
	
   }
}
