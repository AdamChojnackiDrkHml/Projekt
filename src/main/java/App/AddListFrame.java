package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddListFrame extends JFrame implements ActionListener
{
    JTextField nameField = new JTextField();
    JTextField courseField = new JTextField();
    JTextField linkField = new JTextField();

    JLabel nameLabel = new JLabel("Nazwa");
    JLabel courseLabel = new JLabel("Kurs");
    JLabel link = new JLabel("Link");

    JButton addList = new JButton("Add List");

    AddListFrame()
    {
        super("Manage");
        setLayout(new GridLayout(4,2));
        this.getContentPane().add(nameLabel);
        this.getContentPane().add(nameField);
        this.getContentPane().add(courseLabel);
        this.getContentPane().add(courseField);
        this.getContentPane().add(link);
        this.getContentPane().add(linkField);
        this.getContentPane().add(addList);
        addList.addActionListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(addList) &&!(nameField.getText().isEmpty() || courseField.getText().isEmpty() || linkField.getText().isEmpty()))
        {
            String query = "EXEC addList ?, ?, ?, ?";
            try
            {
                PreparedStatement stm = DBConnection.conn.prepareStatement(query);
                stm.setString(1, nameField.getText());
                stm.setString(2, courseField.getText());
                stm.setString(3, linkField.getText());
                stm.setInt(4, DBConnection.UserId);
                stm.execute();

                String query2 = "SELECT TOP 1 Message FROM Results WHERE UserId = " + DBConnection.UserId + " ORDER BY MessageId DESC";
                Statement stm2 = DBConnection.conn.createStatement();
                ResultSet resultSet = stm2.executeQuery(query2);
                resultSet.next();
                String answer = resultSet.getString("Message");
                JOptionPane.showMessageDialog(this, answer);
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }

        }
    }
}
