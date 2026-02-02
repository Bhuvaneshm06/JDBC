package contextInitParam;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/select") xml file la kudutha inga kuduka theva illa
public class InitParam extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletConfig con =  super.getServletConfig();
		String s = con.getInitParameter("name");
		String s1 = con.getInitParameter("name1");
		String s2 = con.getInitParameter("name2");
		System.out.println(s + s1 + s2);
		
	}
}
