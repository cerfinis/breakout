package game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	
	static String jdbcurl = "breakouts.db"; // link this to your database
	static Statement statement;
	static Connection connection;
	static int wins;
	
	
    // function name: connectDatabase()
    // description: connects to the database used with the game
    // parameters: none
    // return: null
	public static Connection connectDatabase() {
		
	    jdbcurl = "jdbc:sqlite:...breakouts.db"; // adjust to your needs
		try {
			connection = DriverManager.getConnection(jdbcurl);
				
				System.out.println("Connected");
				 
			
		} catch (SQLException e) {
			System.out.println("Error connecting to database");
			e.printStackTrace();
		}
		return null;		
	}
	
	
    // function name: logUser()
    // description: check if the user is registered or not
    // parameters: Strings: username, password
    // return: none
	public static void logUser(String username, String password) {
		
         String sql = "SELECT * FROM Users WHERE Username ='"+username+"'AND Password = '"+password+"'";
       	 
       	 try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("Worked");
				Login.validInfo();
				
			}
			else {
				System.out.println("User not registered");
				Login.invalidInfo();
			}
			
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		
	}

   }
	
    // function name: regUser()
    // description: allows the user to register for the game
    // parameters: Strings: username, password, mail
    // return: none
	public static void regUser(String username, String password, String mail) {
	
		String sql = "SELECT * FROM Users WHERE Username ='"+username+"' AND Password = '"+password+"' "
	   	 		+ "OR Email = '"+mail+"'";
   	    try {
		  Statement statement = connection.createStatement();
		  ResultSet rs = statement.executeQuery(sql);
		
		  if(rs.next()) {
			System.out.println("User already registered");
			Register.exists();
		  }
		  else {
			System.out.println("User successfully registered!");
			ConnectDB.insertUser(username, password, mail);
		}
		
   	 } catch (SQLException e1) {
   		 System.out.println(e1.getMessage());
   	 }
  }
    // function name: insertUser()
    // description: inserts the user into the table if user isn't registered
    // parameters: Strings: username, password, mail
    // return: none
	public static void insertUser(String username, String password, String mail) throws SQLException {
		String sql = "INSERT INTO Users (Username, Password, Email) VALUES ('"+username+"', '"+password+"', '"+mail+"')";
		String sql2 = "INSERT INTO Highscores (Username, Score) VALUES ('"+username+"', '1')";

		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		statement.executeUpdate(sql2);
		
	}
	
	public static void updateScore(String username, int score) throws SQLException {
		
		Statement statement = connection.createStatement();
		String sql = "UPDATE Highscores SET Score = '"+score+"' WHERE Username = '"+username+"' AND Score < '"+score+"';";
		wins = statement.executeQuery("SELECT Score FROM Highscores WHERE Username = '"+username+"';").getInt("Score");
		statement.executeUpdate(sql);
		
		System.out.println(wins);
		
	}

}
