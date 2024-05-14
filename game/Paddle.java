package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Paddle extends Rectangle {
	
	int xVelocity;
	int speed = 6;
	
	Paddle(int PLACEMENT, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT) {
		super(PLACEMENT, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		
	}
	
    // function name: keyPressed()
    // description: moves paddle upon pressing keys
    // parameters: KeyEvent: e
    // return: none
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_A) {
			setXDirection(-speed);
			move();
		}
		if (e.getKeyCode()==KeyEvent.VK_D) {
			setXDirection(speed);
			move();
		}
		
		
	}
	
    // function name: keyReleased() - KeyEvent
    // description: stops paddle upon releasing keys
    // parameters: KeyEvent: e
    // return: none
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_A) {
			setXDirection(0);
			move();
		}
		if (e.getKeyCode()==KeyEvent.VK_D) {
			setXDirection(0);
			move();
		}
	}
	
	
    // function name: setXDirection()
    // description: allow paddle to move on x-axis
    // parameters: int: xDirection
    // return: none
	public void setXDirection(int xDirection) {
		xVelocity = xDirection;
		
	}
	
    // function name: move()
    // description: allow paddle to move on the x-axis
    // parameters: none
    // return: none
	public void move() {
		x = x + xVelocity;
		
	}
	
    // function name: draw()
    // description: draw paddle
    // parameters: Graphics: g
    // return: none
	public void draw(Graphics g) {
		
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		
	}
}
