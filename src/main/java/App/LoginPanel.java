package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginPanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
    private static final int width = 200;
    private static final int height = 100;
    private JTextField loginField;
	private JPasswordField passField;
	private JButton loginButton;
	private JButton registerButton;
	private JLabel login;
	private JLabel password;
    static DBConnection dbConnection;
	public LoginPanel() throws SQLException
	{
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		dbConnection = new DBConnection(new String[] {"Admin", "dPl1s.mn]Q"});
		setLayout(new GridLayout(3, 2));
		setPreferredSize(new Dimension(width, height));
		login = new JLabel("Login");
		password = new JLabel("Haslo");
		loginField = new JTextField();
		passField = new JPasswordField();
		loginButton = new JButton("Zaloguj");
		loginButton.addActionListener(this);
		registerButton = new JButton("Zarejestruj");
		registerButton.addActionListener(this);
		add(login);
		add(loginField);
		add(password);
		add(passField);
		add(loginButton);
		add(registerButton);
	}
	
	@Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source == loginButton)
        {
			try
			{

				String login = loginField.getText();
				String password = passField.getText();
				String statement = "SELECT  dbo.authorize( '" + login + "' , '" + password + "') as password";
				assert DBConnection.conn != null;
				Statement stm = DBConnection.conn.createStatement();

				ResultSet resultSet = stm.executeQuery(statement);
				resultSet.next();
				String answer = resultSet.getString("password");
				if(answer.equals("INVALID DATA"))
				{
					JOptionPane.showMessageDialog(this, answer);
				}
				else
				{
					DBConnection.conn.close();
					dbConnection = new DBConnection(answer.split(","));
					stm = DBConnection.conn.createStatement();
					resultSet = stm.executeQuery("SELECT dbo.getUser('" + login +"') as id");
					resultSet.next();
					DBConnection.UserId = Integer.parseInt(resultSet.getString("id"));
					if(DBConnection.UserType.equals("DefaultUser"))
					{
						new SemesterFrame();
					}
					else
					{
						new AdministartiveFrame();
					}
				}
			} catch (SQLException throwables)
			{
				throwables.printStackTrace();
			}


        }
        if(source.equals(registerButton))
		{
			new RegisterFrame();
		}
    }
}