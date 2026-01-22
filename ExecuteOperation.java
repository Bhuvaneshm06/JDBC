package Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExecuteOperation {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void addVideo() {
	  try {
		Connection con = DBconnect.connect();
		String qu = "insert into video values(?, ?, ?, ?);";
		
		PreparedStatement pre = con.prepareStatement(qu);
		
		System.out.println("Enter video id : ");
		int i = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter video title : ");
		String title = sc.nextLine();
		System.out.println("Enter video views : ");
		long view = sc.nextLong();
		System.out.println("Enter video likes : ");
		long like = sc.nextLong();
		
		pre.setInt(1, i);
		pre.setString(2, title);
		pre.setLong(3, view);
		pre.setLong(4, like);
		
		int row = pre.executeUpdate();
		
		System.out.println("Affected rows " + row);
	  }
	  catch(SQLException e) {
		  System.out.println(e.getMessage());
	  }
	}
	
	public static void showCommand() {
		try {
			Connection con = DBconnect.connect();
			String qu = "select c.command from video v left join entrol e on v.id = e.v_id left join command c on c.id = e.c_id where v.id = ?;";
			PreparedStatement pre = con.prepareStatement(qu);
			
			System.out.println("Enter video id : ");
			int n = sc.nextInt();
			pre.setInt(1, n);
			
			ResultSet rs = pre.executeQuery();
		
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void highestViewsVideo() {
		try {
			Connection con = DBconnect.connect();
			
			String qu = "select title , views from video order by views desc limit 3;";
			
			PreparedStatement pre = con.prepareStatement(qu);
			
			ResultSet re = pre.executeQuery();
			
			while(re.next()) {
				System.out.println(re.getString(1) + " " + re.getInt(2));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void addCommand() {
		try {
			System.out.println("Videos List : ");
			DBconnect.displayVideo();
			
			Connection con = DBconnect.connect();
			String qu = "insert into command values (?, ?);";
			PreparedStatement pre = con.prepareStatement(qu);
			
			System.out.println("Enter Id : ");
			int n = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter command : ");
			String com = sc.nextLine();
			
			pre.setInt(1, n);
			pre.setString(2, com);
			
			int row = pre.executeUpdate();
			System.out.println("affected rows " + row);
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void option() {
		System.out.println("1. Add Video : ");
		System.out.println("2. Id based show commands : ");
		System.out.println("3. Top 3 views in video : ");
		System.out.println("4. Id based command video : ");
		System.out.println("5. Display Tables : ");
		
		System.out.println("Enter your option : ");
		int n = sc.nextInt();
		execute(n);
	}
	
	public static void execute(int choice) {
		
		switch(choice) {
				case 1 :
						addVideo();
					break;
					
				case 2 :
					    showCommand();
					break;
					
				case 3 :
						System.out.println("Top 3 views in video : ");
						highestViewsVideo();
					break;
					
				case 4 :
						addCommand();
					break;
					
				case 5 :
						DBconnect.displayTable();
					break;
					
				default :
					System.out.println("please enter valid input....");
		}
	}
}
