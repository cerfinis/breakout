package game;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.util.*;
import java.util.Timer;

public class GamePanel extends JPanel implements Runnable {
	
	// sizes and assets

	
	static int GAME_WIDTH = 1000;
	static int GAME_HEIGHT = 900;
	static Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static int PADDLE_WIDTH = 90;
	static final int PADDLE_HEIGHT = 9;
	static final int PLACEMENT = 500;
	static int BALL_DIAMETER = 20;
	static int BRICK_WIDTH = 50;
	static int BRICK_HEIGHT = 35;
	static final int BRICK_NUMBER = 30;
	static int record = 0;
	
	private int count;
	private Timer timer;
	
	Thread gameThread;
	Image image;
	Random random;
	Graphics graphics;
	Paddle paddle;
	Ball ball; 
	
	Lives lives;
	Score score;
	
	static ArrayList<Brick> bricks = new ArrayList<Brick>();
	
	
	GamePanel() {
		
		newBall();
		newPaddle();
		newBricks();
		
		lives = new Lives(GAME_WIDTH, GAME_HEIGHT);
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		setLayout(null);
		
		
		gameThread = new Thread(this);
		gameThread.start();
		
		
		
	}
	
    // function name: newBall()
    // description: creates a new ball with random speed
    // parameters: none
    // return: none
	public void newBall() {
		random = new Random();
		BALL_DIAMETER = 15;

		if(MainMenu.solo = true) {
		    ball = new Ball(PLACEMENT, 500, BALL_DIAMETER, BALL_DIAMETER);
		}
	}
	
    // function name: newPaddle()
    // description: creates a new paddle
    // parameters: none
    // return: none
	public void newPaddle() {
		
		if(MainMenu.solo = true) {
			PADDLE_WIDTH = 60;
		    paddle = new Paddle(PLACEMENT, 650, PADDLE_WIDTH, PADDLE_HEIGHT);
		}
	}
	
	// function name: newBricks()
    // description: generates new bricks 
    // parameters: none
    // return: none
	public void newBricks() {
		
		if(MainMenu.solo = true) {
			MapGenerator.classicMode();
		}
		
		
	}
	
    // function name: paint()
    // description: allows to draw assets on screen
    // parameters: none
    // return: none
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
		
	}
	
	// function name: draw()
    // description: draws all elements
    // parameters: none
    // return: none
	public void draw(Graphics g) {
		paddle.draw(g);
		ball.draw(g);
		lives.draw(g);
		score.draw(g);
		
		bricks.forEach(brick -> {
			brick.draw(g);
		});
		
		
		
	}
    // function name: move()
    // description: allows paddle and ball to move
    // parameters: none
    // return: none
	public void move() {
		paddle.move();
		ball.move();	
		
	}
	
    // function name: checkCollision()
    // description: check for collisions for the paddle and the ball
    // parameters: none
    // return: none
	public void checkCollision() throws UnsupportedAudioFileException, IOException, LineUnavailableException, SQLException {
		
		// y-axis
		if(ball.y == 0) {
			Audios.wallCollision();
			ball.setYDirection(-ball.yVelocity);   // ball touches top
		}
		if(ball.y > 760) {
			// ball touches bottom
			newBall();
			newPaddle();
			if(MainMenu.solo = true) {
				Lives.lives--;
				if(Lives.lives <= 0) {
					gameEnded();
				}
			}				
		}
		
		// x-axis
		if(ball.x <= 0) {
			Audios.wallCollision();
			ball.setXDirection(-ball.xVelocity);
		}
		if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
			   Audios.wallCollision();
			ball.setXDirection(-ball.xVelocity);
		}

		// paddle collision
		if(paddle.x <= 0) {
			paddle.x = 0;
		}
		if(paddle.x >= GAME_WIDTH-PADDLE_WIDTH) {
			paddle.x = GAME_WIDTH-PADDLE_WIDTH;
		}
		
		// ball touches paddle
		if(ball.intersects(paddle)) {
			Audios.ballOnPaddle();
			ball.yVelocity = -Math.abs(ball.yVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		
		// brick detection
		bricks.forEach(brick -> {
			
			if(ball.intersects(brick) && !brick.destroyed) {
				try {
					  Audios.ballOnBrick();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					e.printStackTrace();
				}
				
				// SCORING PER GAMEMODE
				
				// solo mode
				if(MainMenu.solo = true) {
					if(brick.color == Color.YELLOW) {
						record = 1;
						Score.classicScore(record);
					}
					if(brick.color == Color.GREEN) {
						record = 3;
						Score.classicScore(record);
					}
					if(brick.color == Color.ORANGE) {
						record = 5;
						Score.classicScore(record);
					}
					if(brick.color == Color.RED) {
						record = 7;
						Score.classicScore(record);
					}
					if(Score.score == 512) {
						gameEnded();
					}
				}
		
				brick.destroyed = true;
				ball.setYDirection(-ball.yVelocity);
		}
			
		});
	}
	
    // function name: gameEnded()
    // description: ends the current game for the user
    // parameters: none
    // return: none
	public void gameEnded() {
		
		if(Lives.lives <= 0) {
			
			ball = null;
			paddle = null;
			
			bricks.forEach(brick -> {
				brick.destroyed = true;
			}
			);
			
			EndGame.showScore = Score.score;
			
			Audios.mute = true;
			record = 0;
			Score.score = 0;
			Lives.lives = 3;
			
			GameFrame end = new GameFrame();
			end.endGame();
			
			EndGame.gameOver();
		}
		
		if(Score.score == 512) {
			
			ball = null;
			paddle = null;
			
			EndGame.showScore = Score.score;
			
			Audios.mute = true;
			record = 0;
			Score.score = 0;
			Lives.lives = 3;
			
			GameFrame end = new GameFrame();
			end.endGame();
			
			EndGame.gameWin();
			
		}
		
	}
	
	
    // function name: run()
    // description: allows objects in the game to move smoothly
    // parameters: none
    // return: none
	public void run() {
		
		// smooth paddle movement
		
		long lastTime = System.nanoTime();
		double tickNo = 60.0;
		double ns = 1000000000 / tickNo;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if (delta >= 1) {
				move();
				try {
					checkCollision();
				} catch (UnsupportedAudioFileException | SQLException | IOException | LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				delta--;
			}
		}
		
	}
	
    // function name: AL() - KeyAdapter
    // description: allows paddle to move upon pressing keys
    // parameters: none
    // return: none
	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			paddle.keyPressed(e);
		
		}
		public void keyReleased(KeyEvent e) {
			paddle.keyReleased(e);
		}
	}
	
}
