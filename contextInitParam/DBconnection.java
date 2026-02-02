package contextInitParam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;

public class DBconnection {
	
	public static Connection connect(ServletConfig config) throws SQLException {

        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");

        return DriverManager.getConnection(url, username, password);
    }
	
}
