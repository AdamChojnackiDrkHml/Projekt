package App;

import java.awt.*;
import java.sql.*;

import javax.swing.*;

public class App extends JFrame
{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws SQLException
    {
        /*DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        String dbURL = "jdbc:sqlserver://localhost\\sqlexpress;user=Admin;password=dPl1s.mn]Q";
        Connection conn = DriverManager.getConnection(dbURL);
        if (conn != null) 
        {
            System.out.println("Connected");
        }
        String statement = "SELECT * FROM Users";
        assert conn != null;
        Statement stm = conn.createStatement();

        ResultSet resultSet = stm.executeQuery(statement);*/
 //       System.out.println(resultSet.getString(0));
        EventQueue.invokeLater(() -> new SemesterFrame());
    }
}
