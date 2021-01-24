package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CoursePanel extends JPanel implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private static final int width = 200;
    private static final int height = 100;
    ArrayList<JButton> buttons = new ArrayList<>();
    public CoursePanel()
    {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(width, height));

        Semester sem3 = new Semester();
        Course BDC = new Course();
        BDC.lecturer = "Dr inż. Piotr Syga";
        BDC.name = "Bazy danych - cwiczenia";
        BDC.type = CourseType.CWICZENIA;
        BDC.year = 2020;
        sem3.courses.add(BDC);

        Course BDL = new Course();
        BDL.lecturer = "Mgr inż. Dominik Bojko";
        BDL.name = "Bazy danych - laboratoria";
        BDL.type = CourseType.LABORATORIA;
        BDL.year = 2020;
        sem3.courses.add(BDL);

        for(Course i : sem3.courses)
        {
            JButton button = new JButton(i.name);
            button.addActionListener(this);
            add(button);
            buttons.add(button);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        for (int i = 0; i < buttons.size(); i++)
        {
            if (source == buttons.get(i))
            {
                new ListFrame(buttons.get(i).getText());
            }
        }
    }
}
