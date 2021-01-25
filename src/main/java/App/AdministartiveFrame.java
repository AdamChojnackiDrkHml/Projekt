package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministartiveFrame extends JFrame implements ActionListener
{
    private JButton normalBehaviour = new JButton("Normal");
    private JButton addCourse = new JButton("Add Course");
    private JButton addList = new JButton("Add Lists");
    AdministartiveFrame()
    {
        super("Manage");
        setLayout(new GridLayout(1,3));
        this.getContentPane().add(normalBehaviour);
        this.getContentPane().add(addCourse);
        this.getContentPane().add(addList);
        normalBehaviour.addActionListener(this);
        addCourse.addActionListener(this);
        addList.addActionListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(normalBehaviour))
        {
            new SemesterFrame();
        }
        else if(e.getSource().equals(addList))
        {
            new AddListFrame();
        }
        else
        {
            new AddCourseFrame();
        }
    }
}
