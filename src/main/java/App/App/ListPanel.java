package App;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ListPanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private static final int width = 200;
    private static final int height = 100;
    ArrayList<JButton> buttons = new ArrayList<>();
    ArrayList<CourseType> types = new ArrayList<>();
    
    public ListPanel()
    {
    	 setLayout(new FlowLayout());
         setPreferredSize(new Dimension(width, height));
         
         Course BDC = new Course();
         List list0 = new List();
         List list1 = new List();
         List list2 = new List();
         BDC.lecturer = "Dr inż. Piotr Syga";
         BDC.name = "Bazy danych - cwiczenia";
         BDC.type = CourseType.CWICZENIA;
         BDC.year = 2020;
         list0.name = "Lista 0";
         list1.name = "Lista 1";
         list2.name = "Lista 2";
         BDC.lists.add(list0);
         BDC.lists.add(list1);
         BDC.lists.add(list2);
         
         for(List i : BDC.lists)
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
                new TimeFrame(buttons.get(i).getText());
            }
        }
	}

}