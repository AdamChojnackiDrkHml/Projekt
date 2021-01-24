package App;


import javax.swing.*;

public class MessageFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	public MessageFrame(String message)
	{
		super("Info");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 105);
        JTextArea text = new JTextArea(message);
        text.setEditable(false);
        add(text);
        setVisible(true);
	}
}
