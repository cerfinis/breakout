package game;

import java.sql.SQLException;

public class Breakout {

	public static void main(String[] args) throws Exception {
		
		ReadProperties config = new ReadProperties();
		ReadProperties.config();
		
		ConnectDB connect = new ConnectDB();
		ConnectDB.connectDatabase();  
		
		WelcomeScreen welcome = new WelcomeScreen();
		welcome.welcome();

	}

}
