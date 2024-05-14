package game;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MainMenu implements ActionListener {
	
	public static JFrame frmBreakout;
	private static JPanel panel;
	private static String version;
	private static String platform;
	private static String author;
	
	private static Random random = new Random();
	
	static boolean solo;
	static boolean duo;
	
	// function name: mainMenu()
	// description: creates a main menu
	// parameters: none
	// return: none	
	public void mainMenu() {
		
		// frames 
		
		frmBreakout = new JFrame();
		frmBreakout.setTitle("Breakout");
		frmBreakout.getContentPane().setBackground(Color.BLACK);
		frmBreakout.setSize(700,600);
        frmBreakout.setDefaultCloseOperation(frmBreakout.EXIT_ON_CLOSE);
        frmBreakout.getContentPane().setLayout(null);
        frmBreakout.setResizable(false);
        frmBreakout.setLocationRelativeTo(null);
        
        version = ReadProperties.version;
        platform = ReadProperties.platform;
        author = ReadProperties.author;
        
        System.out.println(version);
        
        // labels
        
        JLabel versionInfo = new JLabel(version + " " + platform + " " + author);
        versionInfo.setForeground(Color.WHITE);
        versionInfo.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 18));
        versionInfo.setBounds(490, 528, 194, 33);
        frmBreakout.getContentPane().add(versionInfo);
        
        final JLabel lblSingleplayerMode = new JLabel("", SwingConstants.CENTER);
        lblSingleplayerMode.setForeground(Color.WHITE);
        lblSingleplayerMode.setFont(new Font("Karmatic Arcade", Font.PLAIN, 16));
        lblSingleplayerMode.setBounds(10, 307, 182, 66);
        frmBreakout.getContentPane().add(lblSingleplayerMode);
        
        final JLabel lblTwoplayerMode = new JLabel("", SwingConstants.CENTER);
        lblTwoplayerMode.setForeground(Color.WHITE);
        lblTwoplayerMode.setFont(new Font("Karmatic Arcade", Font.PLAIN, 16));
        lblTwoplayerMode.setBounds(178, 300, 182, 80);
        frmBreakout.getContentPane().add(lblTwoplayerMode);
        
        final JLabel gamemodeText = new JLabel("", SwingConstants.CENTER);
        gamemodeText.setForeground(Color.WHITE);
        gamemodeText.setFont(new Font("Karmatic Arcade", Font.PLAIN, 16));
        gamemodeText.setBounds(319, 304, 200, 73);
        frmBreakout.getContentPane().add(gamemodeText);
        
        JLabel settingsText = new JLabel("SETTINGS");
        settingsText.setForeground(Color.WHITE);
        settingsText.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 16));
        settingsText.setBounds(597, 11, 77, 14);
        frmBreakout.getContentPane().add(settingsText);
        
        JLabel leaderboardText = new JLabel("LEADERBOARD");
        leaderboardText.setForeground(Color.WHITE);
        leaderboardText.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 16));
        leaderboardText.setBounds(465, 58, 110, 14);
        frmBreakout.getContentPane().add(leaderboardText);
        
        final JLabel quitGamelbl = new JLabel("", SwingConstants.CENTER);
        quitGamelbl.setForeground(Color.WHITE);
        quitGamelbl.setFont(new Font("Karmatic Arcade", Font.PLAIN, 16));
        quitGamelbl.setBounds(474, 304, 200, 73);
        frmBreakout.getContentPane().add(quitGamelbl);
        
        // titles and shadows
        
        JLabel title = new JLabel("BREAKOUT");
        title.setForeground(Color.WHITE);
        title.setBackground(new Color(0, 0, 0));
        title.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 59));
        title.setBounds(20, 11, 336, 61);
        frmBreakout.getContentPane().add(title);
        
        JLabel firstRandom = new JLabel("BREAKOUT");
        firstRandom.setForeground(MainMenu.randomColour());
        firstRandom.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 59));
        firstRandom.setBackground(Color.BLACK);
        firstRandom.setBounds(25, 11, 336, 61);
        frmBreakout.getContentPane().add(firstRandom);
        
        JLabel secondRandom = new JLabel("BREAKOUT");
        secondRandom.setForeground(MainMenu.randomColour());
        secondRandom.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 59));
        secondRandom.setBackground(Color.BLACK);
        secondRandom.setBounds(28, 11, 336, 61);
        frmBreakout.getContentPane().add(secondRandom);
     
        
        // image buttons
        
        // settings
        final JButton settingsButton = new JButton("");
        settingsButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
                settingsButton.setEnabled(true);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
                settingsButton.setEnabled(false);
        	}
        });
        settingsButton.addActionListener(new Settings());
        settingsButton.setEnabled(false);
        settingsButton.setIcon(new ImageIcon("C:\\Users\\mahi1\\eclipse-workspace\\Breakout\\src\\images\\settings.png"));
        settingsButton.setForeground(Color.BLACK);
        settingsButton.setBackground(Color.BLACK);
        settingsButton.setBounds(611, 30, 47, 46);
        settingsButton.setFocusable(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);
        frmBreakout.getContentPane().add(settingsButton);
        
        
        // leaderboard
        final JButton leaderboardButton = new JButton("");
        leaderboardButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
                leaderboardButton.setEnabled(true);
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
                leaderboardButton.setEnabled(false);
        	}
        });
        leaderboardButton.addActionListener(new Leaderboard());
        leaderboardButton.setEnabled(false);
        leaderboardButton.setForeground(Color.BLACK);
        leaderboardButton.setBackground(Color.BLACK);
        leaderboardButton.setIcon(new ImageIcon("C:\\Users\\mahi1\\eclipse-workspace\\Breakout\\src\\images\\leaderboard.png"));
        leaderboardButton.setBounds(477, 18, 90, 39);
        leaderboardButton.setFocusable(false);
        leaderboardButton.setBorderPainted(false);
        leaderboardButton.setContentAreaFilled(false);
        frmBreakout.getContentPane().add(leaderboardButton);
        
        
        // single-player mode
        final JButton soloMode = new JButton("");
        soloMode.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        soloMode.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
                soloMode.setEnabled(true);
                lblSingleplayerMode.setText("<html>SINGLE<br/>PLAYER<br/>MODE</html>");
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		soloMode.setEnabled(false);
                lblSingleplayerMode.setText("");
        	}
        });
        soloMode.addActionListener(new Solo());
        soloMode.setEnabled(false);
        soloMode.setForeground(Color.BLACK);
        soloMode.setBackground(Color.BLACK);
        soloMode.setIcon(new ImageIcon("C:\\Users\\mahi1\\eclipse-workspace\\Breakout\\src\\images\\pixel hearts.png"));
        soloMode.setBounds(28, 257, 167, 46);
        soloMode.setFocusable(false);
        soloMode.setBorderPainted(false);
        soloMode.setContentAreaFilled(false);
        frmBreakout.getContentPane().add(soloMode);
        
        
        // two-player mode
        final JButton duoMode = new JButton("");
        duoMode.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		duoMode.setEnabled(true);
        		lblTwoplayerMode.setText("<html>TWO<br/>PLAYER<br/>MODE</html>");
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		duoMode.setEnabled(false);
        		lblTwoplayerMode.setText("");
        	}
        });
        duoMode.addActionListener(new Duo());
        duoMode.setEnabled(false);
        duoMode.setIcon(new ImageIcon("C:\\Users\\mahi1\\eclipse-workspace\\Breakout\\src\\images\\p1p2.png"));
        duoMode.setBounds(212, 211, 129, 106);
        duoMode.setFocusable(false);
        duoMode.setBorderPainted(false);
        duoMode.setContentAreaFilled(false);
        frmBreakout.getContentPane().add(duoMode);
        
        
        //gamemode
        final JButton gamemodeButton = new JButton("");
        gamemodeButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        gamemodeButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
                gamemodeButton.setEnabled(true);
                gamemodeText.setText("<html>BREAKOUT<br/>ARCADE</html>");
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		gamemodeButton.setEnabled(false);
        		gamemodeText.setText("");
        	}
        });
        gamemodeButton.addActionListener(new Gamemode());
        gamemodeButton.setEnabled(false);
        gamemodeButton.setIcon(new ImageIcon("C:\\Users\\mahi1\\eclipse-workspace\\Breakout\\src\\images\\shield sword.png"));
        gamemodeButton.setBounds(363, 208, 119, 113);
        gamemodeButton.setFocusable(false);
        gamemodeButton.setBorderPainted(false);
        gamemodeButton.setContentAreaFilled(false);
        frmBreakout.getContentPane().add(gamemodeButton);
        
        //logout
        final JButton exitGame = new JButton("");
        exitGame.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		exitGame.setEnabled(true);
        		quitGamelbl.setText("<html>EXIT<br/>GAME</html>");
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		exitGame.setEnabled(false);
        		quitGamelbl.setText("");
        	}
        });
        exitGame.addActionListener(new Exit());
        exitGame.setEnabled(false);
        exitGame.setIcon(new ImageIcon("C:\\Users\\mahi1\\eclipse-workspace\\Breakout\\src\\images\\computer.png"));
        exitGame.setBounds(504, 208, 134, 113);
        exitGame.setFocusable(false);
        exitGame.setBorderPainted(false);
        exitGame.setContentAreaFilled(false);
        frmBreakout.getContentPane().add(exitGame);
        
        
        
        frmBreakout.setVisible(true);
	}
	
    // function name: randomColour()
    // description: creates random colours behind title on top of screen
    // parameters: none
    // return: randomElement (random colour chosen)
	public static Color randomColour() {
		List<Color> colours = Arrays.asList(Color.BLUE, Color.BLACK, Color.RED, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, 
				Color.PINK, Color.DARK_GRAY, Color.GRAY, Color.YELLOW);
		
		Random rand = new Random();
		Color randomElement = colours.get(rand.nextInt(colours.size()));
		return randomElement;
		
	}
	
	// function name: Exit() - ActionListener
	// description: exits the game
	// parameters: none
	// return: none	
    static class Exit implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Audios.playSoundEffect();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("QUITTING BREAKOUT...");
		System.exit(0);
	}

  }
	// function name: Leaderboard() - ActionListener
	// description: opens the leaderboard
	// parameters: none
	// return: none	
    static class Leaderboard implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Audios.playSoundEffect();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

  }
    
	// function name: Gamemode() - ActionListener
	// description: opens breakout arcade mode
	// parameters: none
	// return: none	
    static class Gamemode implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Audios.playSoundEffect();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

  }
	// function name: Solo() - ActionListener
	// description: opens single-player mode
	// parameters: none
	// return: none	
    static class Solo implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Audios.playSoundEffect();
			GameFrame game = new GameFrame();
			game.GameFrame();
			solo = true;
			frmBreakout.setVisible(false);
			
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

  }
	// function name: Settings() - ActionListener
	// description: opens settings
	// parameters: none
	// return: none	
    static class Settings implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Audios.playSoundEffect();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

  }
	// function name: Duo() - ActionListener
	// description: opens two-player mode
	// parameters: none
	// return: none	
    static class Duo implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Audios.playSoundEffect();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

  }
   
}
