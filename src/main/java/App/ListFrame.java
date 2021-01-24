package App;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ListFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
    public ListFrame(String name)
    {
        super(name);
        JPanel listPanel = new ListPanel();
        add(listPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }
}
