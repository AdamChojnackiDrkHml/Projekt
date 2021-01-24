package App;

public class LoginFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

    public LoginFrame()
    {
        super("Logowanie");
        JPanel loginPanel = new LoginPanel();
        add(loginPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }
}