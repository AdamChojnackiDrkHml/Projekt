package App;

import javax.swing.*;
import java.sql.SQLException;

public class CourseFrame extends JFrame
{
    private static final long serialVersionUID = 1L;

    public CourseFrame(int i) throws SQLException
    {
        super("Kursy");
        JPanel coursePanel = new CoursePanel(i);
        add(coursePanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }
}