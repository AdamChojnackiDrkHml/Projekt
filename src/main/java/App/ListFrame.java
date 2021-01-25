package App;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.sql.SQLException;

public class ListFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
    public ListFrame(Course course) throws SQLException
    {
        super(course.name);
        JPanel listPanel = new ListPanel(course);
        add(listPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }
}