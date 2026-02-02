package contextInitParam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/save")
public class SaveServlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String pass = req.getParameter("password");
		String age = req.getParameter("age");
		String gen = req.getParameter("gender");
		String add = req.getParameter("address");
		
//		System.out.println(name + email + phone + pass + age + gen + add);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ServletConfig config = getServletConfig();
			Connection con = DBconnection.connect(config);
			
			String query = "insert into person(name, email, phone, pass, age, gen, address) values(?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pre = con.prepareStatement(query);
			
			pre.setString(1, name);
			pre.setString(2, email);
			pre.setString(3, phone);
			pre.setString(4, pass);
			pre.setString(5, age);
			pre.setString(6, gen);
			pre.setString(7, add);
			
			pre.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		
	}
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ServletConfig conf = getServletConfig();
			Connection con = DBconnection.connect(conf);
			
			req.setAttribute("connection", con);	
			req.getRequestDispatcher("jsonfile").forward(req, res);
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
