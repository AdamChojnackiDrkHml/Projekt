package App;

import java.awt.*;
import java.sql.*;

import javax.swing.*;

public class App extends JFrame
{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws SQLException
    {

        EventQueue.invokeLater(() ->
        {
            try
            {
                new LoginFrame();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        });
    }
}