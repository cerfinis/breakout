package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class WelcomeScreen extends JFrame implements ActionListener {
	
	private static JFrame frame;
	private static Font normalFont = new Font("Helvetica", Font.PLAIN, 15);
	
    // function name: welcome()
    // description: creates a welcome screen
    // parameters: none
    // return: none
	public void welcome() {
		
		// frame settings
		
	    frame = new JFrame();
		frame.setSize(700,500);
        frame.setTitle("Welcome");
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        // panel settings
        
        JPanel picholder = new JPanel();
        picholder.setBackground(Color.WHITE);
        picholder.setBounds(0, 0, 299, 500);
        frame.getContentPane().add(picholder);
        
        JLabel welcomedesign = new JLabel("");
        welcomedesign.setBounds(10, 0, 330, 505);
        welcomedesign.setIcon(new ImageIcon("C:\\Users\\mahi1\\eclipse-workspace\\Breakout\\src\\images\\breakout_cover_login.jpg"));
        picholder.add(welcomedesign);
        
        JPanel otherside = new JPanel();
        otherside.setBackground(Color.BLACK);
        otherside.setBounds(299, 0, 385, 461);
        frame.getContentPane().add(otherside);
        otherside.setLayout(null);
        
        // labels
        
        JLabel breakout = new JLabel("WELCOME TO BREAKOUT");
        breakout.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 24));
        breakout.setForeground(Color.WHITE);
        breakout.setBounds(59, 71, 342, 14);
        otherside.add(breakout);
        
        // buttons
        
        JButton loginButton = new JButton("LOGIN");
        loginButton.setBackground(Color.WHITE);
        loginButton.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 19));
        loginButton.setBounds(120, 166, 145, 23);
        loginButton.addActionListener(new Logging());
        otherside.add(loginButton);
        
        JButton registerButton = new JButton("REGISTER");
        registerButton.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 19));
        registerButton.setBackground(Color.WHITE);
        registerButton.setBounds(120, 247, 145, 23);
        registerButton.addActionListener(new Registering());
        otherside.add(registerButton);
        
        JButton quitButton = new JButton("QUIT");
        quitButton.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 19));
        quitButton.setBackground(Color.WHITE);
        quitButton.setBounds(120, 331, 145, 23);
        quitButton.addActionListener(new Quit());
        otherside.add(quitButton);
		
        frame.setResizable(false);
        frame.setVisible(true);
	}
	
	
    // function name: Quit() - ActionListener
    // description: exits out of Breakout
    // parameters: none
    // return: none
    static class Quit implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("QUITTING BREAKOUT...");
		System.exit(0);
	}
	
	
    // function name: Registering() - ActionListener
    // description: closes the welcome screen and opens the registration screen
    // parameters: none
    // return: none
    }
	static class Registering implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Register register = new Register();
			register.registerScreen();
			
		}
		
	// function name: Logging() - ActionListener
	// description: closes the welcome screen and opens the login screen
	// parameters: none
	// return: none	
	}
	static class Logging implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Login login = new Login();
			login.loginScreen();
			
	}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
