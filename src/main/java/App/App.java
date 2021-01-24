package App;

import java.awt.*;

import javax.swing.*;

public class App extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> new SemesterFrame());
    }
}
