package game;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public class Brick extends Rectangle {
	
	boolean destroyed;
	Color color;
	
	Brick(int x, int y, int BRICK_WIDTH, int BRICK_HEIGHT, Color s) {
		this.x = x;
		this.y = y;
		
		this.width = BRICK_WIDTH;
		this.height = BRICK_HEIGHT;
		
		color = s;
	}
	
	// function name: draw()
    // description: draws the brick
    // parameters: Graphics: g
    // return: none
	public void draw(Graphics g) {
		if(!destroyed) {
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}
	}

	
		
		
	}
