package game;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import game.GamePanel.AL;

import java.util.*;

public class GameFrame extends JFrame {
	
	static GameFrame frame;
    GamePanel panel;
	
    // function name: GameFrame()
    // description: puts game panel into game frame and has panel properties
    // parameters: none
    // return: none
	public void GameFrame() {
		
		frame = new GameFrame();
		panel = new GamePanel();
		
		frame.getContentPane().add(panel);
		frame.setResizable(false);
		frame.setTitle("Breakout");
		frame.setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}
	 // function name: endGame()
    // description: puts end to current game and opens screen
    // parameters: none
    // return: none
	public void endGame() {
		frame.removeAll();
		frame.setVisible(false);
		frame.dispose();
	}

}
