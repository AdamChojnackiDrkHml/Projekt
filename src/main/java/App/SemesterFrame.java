package App;

import javax.swing.*;

public class SemesterFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	public SemesterFrame()
	{
		super("Semestry");
		JPanel semesterPanel = new SemesterPanel();
		add(semesterPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
	    setVisible(true);
	    pack();
	}
}
