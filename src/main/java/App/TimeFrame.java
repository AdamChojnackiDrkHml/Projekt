package App;



import javax.swing.*;

public class TimeFrame extends JFrame
{
    private static final long serialVersionUID = 1L;

    public TimeFrame(String name)
    {
        super(name);
        JPanel timePanel = new TimePanel();
        add(timePanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }

}
