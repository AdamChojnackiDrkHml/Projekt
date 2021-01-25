package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;

public class CoursePanel extends JPanel implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private static final int width = 200;
    private static final int height = 400;
    ArrayList<JButton> buttons = new ArrayList<>();
    Semester sem = new Semester();
    public CoursePanel(int a) throws SQLException
    {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(width, height));





        String statement = "SELECT * FROM dbo.returnCourses(" + a + ")";
        Statement stm = DBConnection.conn.createStatement();
        ResultSet resultSet = stm.executeQuery(statement);
        while(resultSet.next())
        {
            Course BDC = new Course();
            BDC.lecturer = resultSet.getString("LeaderName") + " " + resultSet.getString("LeaderSurename");
            BDC.name = resultSet.getString("CourseName");
            BDC.type = CourseType.valueOf(resultSet.getString("CourseType").toUpperCase());
            BDC.courseId = Integer.parseInt(resultSet.getString("CourseId"));
            sem.courses.add(BDC);
        }

        for(Course i : sem.courses)
        {
            JButton button = new JButton(i.name + " " + i.lecturer);
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
                try
                {
                    new ListFrame(sem.courses.get(i));
                } catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }
            }
        }
    }
}