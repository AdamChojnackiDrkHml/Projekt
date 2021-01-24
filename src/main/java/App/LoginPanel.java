package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
    private static final int width = 200;
    private static final int height = 100;
    private JTextField loginField;
	private JPasswordField passField;
	private JButton loginButton;
	private JLabel login;
	private JLabel password;
    
	public LoginPanel()
	{
		setLayout(new GridLayout(2, 2));
		setPreferredSize(new Dimension(width, height));
		login = new JLabel("Login");
		password = new JLabel("Haslo");
		loginField = new JTextFeld();
		passField = new JPasswordField();
		loginButton = new JButton("Zaloguj");
		loginButton.addActionListener(this);
		add(login);
		add(loginField);
		add(password);
		add(passField);
		add(loginButton);
	}
	
	@Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source == loginButton)
        {
            new SemesterFrame();
        }
    }
}