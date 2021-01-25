package App;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ListPanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private static final int width = 200;
    private static final int height = 100;
    private Course course;
    ArrayList<JButton> buttons = new ArrayList<>();
    ArrayList<CourseType> types = new ArrayList<>();
    
    public ListPanel(Course course) throws SQLException
    {
    	 setLayout(new FlowLayout());
         setPreferredSize(new Dimension(width, height));

         this.course = course;

         String statement = "SELECT * FROM dbo.returnListsNames(" + course.courseId + ")";
         Statement stm = DBConnection.conn.createStatement();
         ResultSet resultSet = stm.executeQuery(statement);

        while(resultSet.next())
        {
            List BDC = new List();
            BDC.name = resultSet.getString("Name");
            BDC.link = resultSet.getString("Link");
            BDC.time = Integer.parseInt(resultSet.getString("AverageTime"));
            BDC.listId = Integer.parseInt(resultSet.getString("ListId"));;
            course.lists.add(BDC);
        }

         
         for(List i : course.lists)
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
                new TimeFrame(course.lists.get(i));
            }
        }
	}

}