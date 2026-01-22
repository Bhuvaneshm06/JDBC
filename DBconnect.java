package Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconnect {
	public static Connection connect() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/JDBCconect";
		String username = "root";
		String password = "Bhuvan@411";
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
	
	public static void displayVideo() {
		try {
			Connection con = connect();
			String qu = "select * from video;";
			PreparedStatement pre = con.prepareStatement(qu);
			
			ResultSet re = pre.executeQuery();
			
			while(re.next()) {
				System.out.println(re.getInt(1) + " " + re.getString(2) + " " + re.getLong(3) + " " + re.getLong(4));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void command() {
		try {
			Connection con = connect();
			String qu = "select * from command;";
			PreparedStatement pre = con.prepareStatement(qu);
			
			ResultSet re = pre.executeQuery();
			
			while(re.next()) {
				System.out.println(re.getInt(1) + " " + re.getString(2));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void junction() {
		try {
			Connection con = connect();
			String qu = "select * from entrol;";
			PreparedStatement pre = con.prepareStatement(qu);
			
			ResultSet re = pre.executeQuery();
			
			while(re.next()) {
				System.out.println(re.getInt(1) + " " + re.getInt(2));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void displayTable() {
		System.out.println("1. Video table : ");
		System.out.println("2. Command table : ");
		System.out.println("3. Junction table : ");
		
		System.out.println("Enter your Otpion : ");
		int c = ExecuteOperation.sc.nextInt();
		
		switch(c) {
			case 1 :
					System.out.println("Video table : ");
					displayVideo();
				break;
				
			case 2 :
					System.out.println("Command table : ");
					command();
				break;
				
			case 3 :
					System.out.println("Junction table : ");
					junction();
				break;
				
			default : 
				System.out.println("please enter valid input...");
		}
		
	}
}


