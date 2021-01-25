package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection
{

    static Connection conn;
    static int UserId;
    public DBConnection(String[] data) throws SQLException
    {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        String dbURL = "jdbc:sqlserver://localhost\\sqlexpress";
        conn = DriverManager.getConnection(dbURL, data[0], data[1]);
        while(conn == null)
        {
            conn = DriverManager.getConnection(dbURL, data[0], data[1]);
        }


    }
}