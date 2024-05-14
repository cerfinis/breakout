package game;

import java.awt.*;
import java.util.*;

public class Ball extends Rectangle {

	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 5;
	
	Ball(int PLACEMENT, int y, int width, int height){
		
		super(PLACEMENT, y, width, height);
		
		random = new Random();
		
		int randomXDirection = random.nextInt(2);
		if(randomXDirection == 0)
			randomXDirection--;
		setXDirection(randomXDirection*initialSpeed);
		
		int randomYDirection = random.nextInt(2);
		if(randomYDirection == 0)
			randomYDirection--;
		setYDirection(randomYDirection*initialSpeed);
		
	}
	
    // function name: setXDirection()
    // description: random direction on x-axis
    // parameters: int: randomXDirection
    // return: none
	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
	}
	
    // function name: setYDirection()
    // description: random direction on y-axis
    // parameters: int: randomYDirection
    // return: none
	public void setYDirection(int randomYDirection) {
	
		yVelocity = randomYDirection;
	}
	
    // function name: move()
    // description: allow ball to move on x-axis and y-axis
    // parameters: none
    // return: none
	public void move() {
		x += xVelocity;
		y += yVelocity;
	}
	
    // function name: draw()
    // description: draws ball
    // parameters: Graphics: g
    // return: none
	public void draw(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillOval(x, y, height, width);
	}
}
