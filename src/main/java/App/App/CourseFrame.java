package App;

import javax.swing.*;

public class CourseFrame extends JFrame
{
    private static final long serialVersionUID = 1L;

    public CourseFrame()
    {
        super("Kursy");
        JPanel coursePanel = new CoursePanel();
        add(coursePanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }
}