package contextInitParam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jsonfile")
public class Persons extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		try {
			Connection con = (Connection) (req.getAttribute("connection"));
			
			String query = "select * from person;";
			PreparedStatement pre = con.prepareStatement(query);
			
			ResultSet rel = pre.executeQuery();
			
			StringBuilder json = new StringBuilder("[");
			boolean first = true;

			while (rel.next()) {
			    if (!first) {
			        json.append(",");
			    }
			    first = false;

			    json.append("{")
			        .append("\"Name\":\"").append(rel.getString(2)).append("\",")
			        .append("\"Email\":\"").append(rel.getString(3)).append("\",")
			        .append("\"PhoneNumber\":\"").append(rel.getString(4)).append("\",")
			        .append("\"Password\":\"").append(rel.getString(5)).append("\",")
			        .append("\"Age\":\"").append(rel.getString(6)).append("\",")
			        .append("\"Gender\":\"").append(rel.getString(7)).append("\",")
			        .append("\"Address\":\"").append(rel.getString(8)).append("\",")
			        .append("}");
			}

			json.append("]");
			res.setContentType("application/json");
			res.getWriter().print(json.toString());
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
