package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TimePanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private MyTimer myTimer = new MyTimer();
	private ArrayList<Long> times = new ArrayList<>();
	private static final int width = 600;
    private static final int height = 100;
    private JButton info;
    private JButton start;
    private JButton stop;
    private JButton confirm;

	private boolean canStop = false;
	private boolean canStart = true;

	private List list;

	public TimePanel(List list)
    {
    	this.list = list;
    	setLayout(new FlowLayout());
        setPreferredSize(new Dimension(width, height));
        info = new JButton("info");
    	start = new JButton("start");
    	stop = new JButton("pauza");
    	confirm = new JButton("zatwierdz");
    	info.addActionListener(this);
    	start.addActionListener(this);
    	stop.addActionListener(this);
    	confirm.addActionListener(this);
    	add(info);
    	add(start);
    	add(stop);
    	add(confirm);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if (source == info)
		{
			JOptionPane.showMessageDialog(this,"Aby zmierzyc czas wykonywania listy, kliknij start" +
					"\nAby zatrzymac mierzenie czasu, kliknij pauza" +
					"\nAby powrocic do mierzenia czasu, ponownie kliknij start" +
					"\nAby zapisac zmierzony czas, kliknij zatwierdz");
		}
		else if (source == start && canStart)
		{
			myTimer.startTheCount();
			canStop = true;
			canStart = false;
		}
		else if (source == stop && canStop)
		{
			myTimer.stopTheCount();
			JOptionPane.showMessageDialog(this,"Twoj czas: " + myTimer.yourTime + "ms");
			canStop = false;
			canStart = true;
		}
		else if (source == confirm && myTimer.yourTime != 0)
		{
			times.add(myTimer.yourTime);


			try
			{
				String statement = "SELECT * FROM Times WHERE ListId = ? AND UserId = ?";
				PreparedStatement statementP = DBConnection.conn.prepareStatement(statement);
				statementP.setInt(1, list.listId);
				statementP.setInt(2, DBConnection.UserId);
				ResultSet resultSet = statementP.executeQuery();
				if(resultSet.next())
				{
					JOptionPane.showMessageDialog(this,"Nie można dodać kolejnego czasu do tej listy");
				}
				else
				{
					String statement2 = "exec addTime ?, ?, ?";
					PreparedStatement stm = DBConnection.conn.prepareStatement(statement2);
					stm.setInt(1, list.listId);
					stm.setInt(2, (int)myTimer.yourTime);
					stm.setInt(3,DBConnection.UserId);
					stm.executeUpdate();
					JOptionPane.showMessageDialog(this,"Dodano czas");
				}

			} catch (SQLException throwables)
			{
				JOptionPane.showMessageDialog(this,throwables.getMessage());
			}
			myTimer.yourTime = 0;


		}
	}
}