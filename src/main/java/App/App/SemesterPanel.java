package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SemesterPanel extends JPanel implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private static final int width = 200;
    private static final int height = 100;
    private JButton semester3;
    
    public SemesterPanel()
    {        
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(width, height));
        semester3 = new JButton("semestr 3");
        semester3.addActionListener(this);
        add(semester3);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source == semester3)
        {
            new CourseFrame();
        }
    }
}