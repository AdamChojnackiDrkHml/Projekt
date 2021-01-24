package App;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
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

	public TimePanel()
    {
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
			new MessageFrame("Aby zmierzyc czas wykonywania listy, kliknij start" +
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
			new MessageFrame("Twoj czas: " + myTimer.yourTime + "ms");
			canStop = false;
			canStart = true;
		}
		else if (source == confirm && myTimer.yourTime != 0)
		{
			times.add(myTimer.yourTime);
			myTimer.yourTime = 0;
			new MessageFrame("Dodano czas");
		}
	}
}