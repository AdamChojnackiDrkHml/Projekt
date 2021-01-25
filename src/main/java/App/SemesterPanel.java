package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SemesterPanel extends JPanel implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private static final int width = 200;
    private static final int height = 150;
    private final JButton[] semesters = new JButton[7];
    
    public SemesterPanel()
    {        
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(width, height));
        for(int i = 1; i < 8; i++)
        {
            semesters[i - 1] = new JButton("semestr" + i);
            this.add(semesters[i-1]);
            semesters[i-1].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        for(int i = 0; i < 7; i++)
        {
            if (source == semesters[i])
            {
                try
                {
                    new CourseFrame(i + 1);
                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
            }
        }
    }
}