package game;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register implements ActionListener {

	private static JPanel panel;
	private static JFrame frame;
	private static Font normalFont = new Font("Helvetica", Font.PLAIN, 15);
	private static JTextField email;
	private static JTextField user;
	private static JPasswordField pass;
	private static JPasswordField confPass;
	private static JLabel success;
	private static JLabel passCheck;
	private static JCheckBox checkBox;
	
	private static String username;
	private static String password;
	private static String mail;
	
	private static boolean userverify;
	private static boolean passverify;
	private static boolean everify;
	
	private static Connection conn = null;
	private final Action action = new SwingAction();
	
	// function name: registerScreen()
	// description: creates registration screen
	// parameters: none
	// return: none	
    public void registerScreen() {
    	
    	conn = ConnectDB.connectDatabase();
    	
    	frame = new JFrame();
    	frame.setResizable(false);
    	frame.setTitle("Breakout Registration");
        frame.setSize(500,730);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        
        // panels
        
        JPanel mainPanel = new JPanel();            // panel with boxes
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setBounds(0, 0, 484, 504);
        frame.getContentPane().add(mainPanel);
        mainPanel.setLayout(null);

        JPanel imagePanel = new JPanel();          // panel with image
        imagePanel.setBackground(Color.BLACK);
        imagePanel.setBounds(0, 497, 484, 164);
        frame.getContentPane().add(imagePanel);
        
        // labels
        
        JLabel title = new JLabel("BREAKOUT");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 28));
        title.setBounds(172, 48, 135, 21);
        mainPanel.add(title);
        
        JLabel regLabel = new JLabel("REGISTER A NEW ACCOUNT");
        regLabel.setBounds(63, 91, 368, 21);
        regLabel.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 28));
        regLabel.setForeground(Color.WHITE);
        mainPanel.add(regLabel);
        
        JLabel userLabel = new JLabel("EMAIL ADDRESS");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 18));
        userLabel.setBounds(29, 216, 180, 21);
        mainPanel.add(userLabel);
        
        JLabel emailLabel = new JLabel("USERNAME");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 18));
        emailLabel.setBounds(29, 153, 180, 21);
        mainPanel.add(emailLabel);
        
        JLabel passLabel = new JLabel("PASSWORD");
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 18));
        passLabel.setBounds(29, 287, 106, 21);
        mainPanel.add(passLabel);
        
        JLabel confirmLabel = new JLabel("CONFIRM PASSWORD");
        confirmLabel.setForeground(Color.WHITE);
        confirmLabel.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 18));
        confirmLabel.setBounds(29, 350, 194, 21);
        mainPanel.add(confirmLabel);
        
        JLabel image = new JLabel("");  // image
        image.setIcon(new ImageIcon("C:\\Users\\mahi1\\eclipse-workspace\\Breakout\\src\\images\\breakout_cover_register.jpg"));
        imagePanel.add(image);
        
        // fields
        
        user = new JTextField();
        user.setBackground(Color.WHITE);
        user.setBounds(29, 185, 384, 20);
        mainPanel.add(user);
        user.setColumns(10);
        
        email = new JTextField();
        email.setBackground(Color.WHITE);
        email.setColumns(10);
        email.setBounds(29, 248, 384, 20);
        mainPanel.add(email);
        
        pass = new JPasswordField();
        pass.setBackground(Color.WHITE);
        pass.setColumns(10);
        pass.setBounds(29, 319, 384, 20);
        mainPanel.add(pass);
        
        confPass = new JPasswordField();
        confPass.setBackground(Color.WHITE);
        confPass.setColumns(10);
        confPass.setBounds(29, 382, 384, 20);
        mainPanel.add(confPass);
        
        
        
        // buttons
        
        
        JButton regButton = new JButton("REGISTER\r\n");
        regButton.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 19));
        regButton.setBackground(Color.WHITE);
        regButton.addActionListener(new Registration());
        regButton.setBounds(160, 430, 147, 23);
        mainPanel.add(regButton);
        
        JButton backButton = new JButton("GO BACK");
        backButton.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 19));
        backButton.setBackground(Color.WHITE);
        backButton.addActionListener(new Return());
        backButton.setBounds(160, 464, 147, 23);
        mainPanel.add(backButton);
        

        // check box
        
        checkBox = new JCheckBox("Show Password");
        checkBox.setAction(action);
        checkBox.setForeground(Color.WHITE);
        checkBox.setBackground(Color.BLACK);
        checkBox.setBounds(29, 409, 123, 23);
        mainPanel.add(checkBox); 
        
        // alerts
        
        JPanel successP = new JPanel();
        successP.setBackground(Color.BLACK);
        successP.setBounds(0, 658, 484, 33);
        frame.getContentPane().add(successP);
        successP.setLayout(null);
        
        
        // success
        
        success = new JLabel(" ");
        success.setForeground(Color.RED);
        success.setBounds(10, 5, 250, 28);
        success.setFont(new Font("Helvetica", Font.PLAIN, 11));
        success.setBackground(new Color(0, 0, 0));
        successP.add(success);
        
        passCheck = new JLabel(" ");
        passCheck.setForeground(Color.RED);
        passCheck.setFont(new Font("Helvetica", Font.PLAIN, 11));
        passCheck.setBackground(Color.BLACK);
        passCheck.setBounds(288, 5, 196, 28);
        successP.add(passCheck);
        frame.setVisible(true);
		

	}
    
    // function name: userCheck()
    // description: checks if username meets criteria
    // parameters: none
    // return: none
    public static void userCheck() {
		username = user.getText();
		
		if (username.length() < 11 && username.length() > 3) {
			success.setText("");
			userverify = true;
		}
		else if (username.length() == 0){
			success.setText("No username entered");
			userverify = false;
		}
		else {
			success.setText("Username must be between 4-10 characters");
			userverify = false;
		}
		
		
    	
    }
    
    // function name: passwordCheck()
    // description: checks if password meets criteria
    // parameters: none
    // return: none
    public static void passwordCheck() {
    	
    	password = pass.getText();
		
		if (password.equals(confPass.getText())) {
			passCheck.setText("");
			passverify = true;
		}
		else {
			passCheck.setText("Passwords do not match");
			passverify = false;
		}
		
		if (password.length() < 8) {
			passCheck.setText("Password too short");
			passverify = false;
		}
    }
    
    // function name: emailCheck()
    // description: checks if email meets criteria
    // parameters: none
    // return: none
    public static void emailCheck() {
    	
    	mail = email.getText();
    	if (EmailValidation.validateMail(mail) == true) {
    		everify = true;
    	}
    	else {
    		everify = false;
    	}
    	
    	
    }
    
    // function name: finalCheck()
    // description: checks all of the criteria together to allow the user to register
    // parameters: none
    // return: none
    public static void finalCheck() {
    	
    	Register.userCheck();
    	Register.passwordCheck();
    	Register.emailCheck();
    	
    	username = user.getText();
    	password = pass.getText();
    	mail = email.getText();
    	
    	int count = 0;
    	
    	if (userverify) {
    		count = count + 1;
    	}
    	if (passverify) {
    		count = count + 1;
    	}
    	if (everify) {
    		count = count + 1;
    	}
    	
    	if (count == 3) {
    		System.out.println("Criteria met");
    		success.setText("Successfully registered!");
    		success.setForeground(Color.GREEN);
    		
    		ConnectDB.regUser(username, password, mail);
    	}
    	else {
    		System.out.println("Criteria not met");
    	}
    	
    }
    
    // function name: exists()
    // description: confirms that user/account already exists
    // parameters: none
    // return: none
    public static void exists() {
    	success.setText("User already registered");
    	passCheck.setText("User already registered");
    }
    
    // function name: Registration() - ActionListener()
    // description: checks whether the account already exists
    // parameters: none
    // return: none
    static class Registration implements ActionListener {

    	public void actionPerformed(ActionEvent e) {
    		Register.finalCheck();
    	
        }
    }
    
    // function name: invalidEmail()
    // description: indicates that an invalid email address has been provided
    // parameters: none
    // return: none
    public static void invalidMail() {
    	success.setText("Invalid email address provided");
    }
    
    
    // function name: Return() - ActionListener
    // description: closes the registration screen and re-opens the welcome screen
    // parameters: none
    // return: none
    static class Return implements ActionListener {

    	@Override
    	public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			WelcomeScreen welcome = new WelcomeScreen();
			welcome.welcome();
    	}
    		
    		
    		
    }
    
	// function name: SwingAction()
	// description: shows password upon checkbox being ticked
	// parameters: none
	// return: none

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Show Password");
		}
		public void actionPerformed(ActionEvent e) {
			if (checkBox.isSelected()) {
				pass.setEchoChar((char) 0);
				confPass.setEchoChar((char) 0);
			}
			else {
				pass.setEchoChar('*');
				confPass.setEchoChar('*');
			}
		}
	}
}
