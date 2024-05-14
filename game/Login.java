package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;

public class Login implements ActionListener {
	
	private static JPanel panel;
	private static JFrame frame;
	private static JPanel imgPanel;
	private final JLabel logLabel = new JLabel("LOGIN TO BREAKOUT");
	private static JTextField textField;
	private static JCheckBox checkBox;
	private static JLabel success;
	private static JPasswordField passwordField;
	
	private static Connection conn = null;
	private final Action action = new SwingAction();

	    // function name: loginScreen()
		// description: creates a login screen
		// parameters: none
		// return: none	
	public void loginScreen()  {
		
		
    	frame = new JFrame();
    	frame.setTitle("Login to Breakout");
        frame.setSize(395,445);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        ConnectDB.connectDatabase();
        
        // panels
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.BLACK);
        panel_1.setBounds(0, 0, 377, 228);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        imgPanel = new JPanel();  // image panel
        imgPanel.setBackground(Color.BLACK);
        imgPanel.setBounds(0, 227, 377, 179);
        frame.getContentPane().add(imgPanel);
        
        // title
        
        logLabel.setBounds(68, 27, 241, 24);
        logLabel.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 25));
        logLabel.setForeground(new Color(255, 255, 255));
        
        panel_1.add(logLabel);
        
        // labels
        
        JLabel lblUsername = new JLabel("USERNAME");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 18));
        lblUsername.setBounds(21, 88, 107, 24);
        panel_1.add(lblUsername);
        
        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 18));
        lblPassword.setBounds(21, 123, 107, 24);
        panel_1.add(lblPassword);
        
        // fields
        
        textField = new JTextField();
        textField.setBackground(Color.WHITE);
        textField.setBounds(127, 91, 213, 20);
        panel_1.add(textField);
        textField.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setBackground(Color.WHITE);
        passwordField.setBounds(127, 126, 213, 20);
        panel_1.add(passwordField);
        
        // buttons
        
        JButton btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBackground(Color.WHITE);
        btnSubmit.setForeground(new Color(0, 0, 0));
        btnSubmit.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 17));
        btnSubmit.addActionListener(new Submit());
        btnSubmit.setBounds(10, 192, 107, 23);
        panel_1.add(btnSubmit);
        
        JButton btnClear = new JButton("CLEAR");
        btnClear.setBackground(Color.WHITE);
        btnClear.setForeground(Color.BLACK);
        btnClear.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 17));
        btnClear.addActionListener(new Clear());
        btnClear.setBounds(127, 192, 113, 23);
        panel_1.add(btnClear);
        
        JButton btnReturn = new JButton("GO BACK");
        btnReturn.setBackground(Color.WHITE);
        btnReturn.setForeground(Color.BLACK);
        btnReturn.setFont(new Font("Upheaval TT (BRK)", Font.PLAIN, 17));
        btnReturn.addActionListener(new Return());
        btnReturn.setBounds(250, 192, 113, 23);
        panel_1.add(btnReturn);
        
        // check box
        
        checkBox = new JCheckBox("Show Password");
        checkBox.setAction(action);
        checkBox.setBackground(Color.BLACK);
        checkBox.setForeground(Color.WHITE);
        checkBox.setBounds(10, 154, 219, 23);
        panel_1.add(checkBox);
        imgPanel.setLayout(null);
        
       
        // image 
        
        JLabel paneldesign = new JLabel();
        paneldesign.setBounds(0, 0, 377, 134);
        paneldesign.setIcon(new ImageIcon("C:\\Users\\mahi1\\eclipse-workspace\\Breakout\\src\\images\\breakout_cover_logging.png"));
        imgPanel.add(paneldesign);
        
        // success 
        
        success = new JLabel(" ");
        success.setForeground(Color.RED);
        success.setFont(new Font("Helvetica", Font.PLAIN, 11));
        success.setBackground(Color.BLACK);
        success.setBounds(10, 145, 250, 28);
        imgPanel.add(success);
        
        frame.setResizable(false);
        frame.setVisible(true);
        
	}
	
    // function name: invalidInfo()
    // description: indicates that information provided is invalid/doesn't exist
    // parameters: none
    // return: none
	public static void invalidInfo() {
		success.setText("Invalid username or password");
		
	}
    // function name: validInfo()
    // description: indicates that information provided is valid, opens up main menu of game
    // parameters: none
    // return: none
	public static void validInfo() {
		System.out.println("Logging in...");
		frame.dispose();
		
		MainMenu mainMenu = new MainMenu();
		mainMenu.mainMenu();
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
				passwordField.setEchoChar((char) 0);
			}
			else {
				passwordField.setEchoChar('*');
			}
		}
	}
	
    // function name: Return() - ActionListener
    // description: closes the login screen and re-opens the welcome screen
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
    
    // function name: Submit() - ActionListener
    // description: brings inputted information to ConnectDB class to be verified if valid
    // parameters: none
    // return: none
    static class Submit implements ActionListener {

    	@Override
    	public void actionPerformed(ActionEvent e) {
       	 
       	 String user = textField.getText();
       	 String pass = passwordField.getText();
       	 
       	 ConnectDB.logUser(user, pass);
    	 EndGame.currentUser = user;
			 
     }
    	
    }
    
    // function name: Clear() - ActionListener
 	// description: clears all contents within the input boxes
 	// parameters: none
 	// return: none	
    static class Clear implements ActionListener {

    	@Override
    	public void actionPerformed(ActionEvent e) {
         textField.setText("");
    	 passwordField.setText("");
       	  
     }
    	
    }

    
} 
