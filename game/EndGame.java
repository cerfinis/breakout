package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EndGame {
	
	static JFrame frame;
	static int showScore;
	static String currentUser;
	
    // function name: gameOver()
    // description: opens game over window if user loses
    // parameters: none
    // return: none

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void gameOver() {
		
    	frame = new JFrame();
    	frame.setResizable(false);
    	frame.setTitle("Game Over");
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, 484, 361);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel title = new JLabel("BREAKOUT");
        title.setBounds(104, 30, 120, 24);
        title.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 25));
        title.setForeground(Color.WHITE);
        panel.add(title);
        
        JLabel gameOver = new JLabel("GAME OVER");
        gameOver.setForeground(Color.RED);
        gameOver.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 52));
        gameOver.setBounds(104, 56, 279, 38);
        panel.add(gameOver);
        
        JLabel youLose = new JLabel("YOU LOSE");
        youLose.setForeground(Color.WHITE);
        youLose.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 25));
        youLose.setBounds(263, 98, 120, 24);
        panel.add(youLose);
        
        JLabel nextText = new JLabel("WHAT WOULD YOU LIKE TO DO NEXT?");
        nextText.setForeground(Color.WHITE);
        nextText.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 25));
        nextText.setBounds(22, 145, 441, 24);
        panel.add(nextText);
        
        JButton playAgain = new JButton("PLAY AGAIN");
        playAgain.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 15));
        playAgain.setBackground(Color.WHITE);
        playAgain.addActionListener(new Retry());
        playAgain.setBounds(76, 227, 120, 23);
        panel.add(playAgain);
        
        JButton mainMenu = new JButton("MAIN MENU");
        mainMenu.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 15));
        mainMenu.setBackground(Color.WHITE);
        mainMenu.addActionListener(new Back());
        mainMenu.setBounds(263, 227, 120, 23);
        panel.add(mainMenu);
        
        JLabel yourScore = new JLabel("YOUR SCORE: " + showScore);
        yourScore.setForeground(Color.WHITE);
        yourScore.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 25));
        yourScore.setBounds(127, 281, 256, 24);
        panel.add(yourScore);
        
        JLabel newHigh = new JLabel("");
        newHigh.setForeground(Color.ORANGE);
        newHigh.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 25));
        newHigh.setBounds(127, 317, 256, 24);
        panel.add(newHigh);
        
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        System.out.println(currentUser);
        
        
        try {
			ConnectDB.updateScore(currentUser, showScore);
			if(showScore > ConnectDB.wins) {
				newHigh.setText("NEW HIGH SCORE!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		
	}
	
	public static void gameWin() {
		
		frame = new JFrame();
    	frame.setResizable(false);
    	frame.setTitle("You Win");
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, 484, 361);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel title = new JLabel("BREAKOUT");
        title.setBounds(104, 30, 120, 24);
        title.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 25));
        title.setForeground(Color.WHITE);
        panel.add(title);
        
        JLabel youWin = new JLabel("! YOU WIN !");
        youWin.setForeground(Color.GREEN);
        youWin.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 52));
        youWin.setBounds(104, 56, 279, 38);
        panel.add(youWin);
        
        JLabel nextText = new JLabel("WHAT WOULD YOU LIKE TO DO NEXT?");
        nextText.setForeground(Color.WHITE);
        nextText.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 25));
        nextText.setBounds(22, 145, 441, 24);
        panel.add(nextText);
        
        JLabel yourScore = new JLabel("YOUR SCORE: " + showScore);
        yourScore.setForeground(Color.WHITE);
        yourScore.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 25));
        yourScore.setBounds(127, 281, 256, 24);
        panel.add(yourScore);
        
        JButton playAgain = new JButton("PLAY AGAIN");
        playAgain.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 15));
        playAgain.setBackground(Color.WHITE);
        playAgain.addActionListener(new Retry());
        playAgain.setBounds(76, 227, 120, 23);
        panel.add(playAgain);
        
        JButton mainMenu = new JButton("MAIN MENU");
        mainMenu.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 15));
        mainMenu.setBackground(Color.WHITE);
        mainMenu.addActionListener(new Back());
        mainMenu.setBounds(263, 227, 120, 23);
        panel.add(mainMenu);
        
        JLabel newHigh = new JLabel("");
        newHigh.setForeground(Color.ORANGE);
        newHigh.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 25));
        newHigh.setBounds(127, 317, 256, 24);
        panel.add(newHigh);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
       System.out.println(currentUser);
        
       try {
			ConnectDB.updateScore(currentUser, showScore);
			if(showScore > ConnectDB.wins) {
				newHigh.setText("NEW HIGH SCORE!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
    // function name: Retry()
    // description: re-opens game window with new game
    // parameters: none
    // return: none
    static class Retry implements ActionListener {

    	@Override
    	public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Audios.mute = false;
			GameFrame GameFrame = new GameFrame();
			GameFrame.GameFrame();
			
    	}
    	
    }
    
    // function name: gameOver()
    // description: returns user to main menu
    // parameters: none
    // return: none
    static class Back implements ActionListener {

    	@Override
    	public void actionPerformed(ActionEvent e) {
    		Audios.mute = false;
			frame.setVisible(false);
			MainMenu.frmBreakout.setVisible(true);
    	}
    	
    }
}
