package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddCourseFrame extends JFrame implements ActionListener
{
    JTextField nameField = new JTextField();
    JTextField leaderNameField = new JTextField();
    JTextField leaderSurnameField = new JTextField();
    JTextField typeField = new JTextField();
    JTextField semesterField = new JTextField();

    JLabel nameLabel = new JLabel("Nazwa");
    JLabel leaderNameLabel = new JLabel("Imie Prowadzącego");
    JLabel leaderSurnameLabel = new JLabel("Nazwisko Prowadzącego");
    JLabel typeLabel = new JLabel("Typ kursu");
    JLabel semesterLabel = new JLabel("Semestr");


    JButton addCourse = new JButton("Add List");

    AddCourseFrame()
    {
        super("Manage");
        setLayout(new GridLayout(6, 2));
        this.getContentPane().add(nameLabel);
        this.getContentPane().add(nameField);
        this.getContentPane().add(leaderNameLabel);
        this.getContentPane().add(leaderNameField);
        this.getContentPane().add(leaderSurnameLabel);
        this.getContentPane().add(leaderSurnameField);
        this.getContentPane().add(typeLabel);
        this.getContentPane().add(typeField);
        this.getContentPane().add(semesterLabel);
        this.getContentPane().add(semesterField);
        this.getContentPane().add(addCourse);
        addCourse.addActionListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(addCourse) && !(semesterField.getText().isEmpty() || typeField.getText().isEmpty() || nameField.getText().isEmpty() || leaderNameField.getText().isEmpty() || leaderSurnameField.getText().isEmpty()))
        {
            String query = "EXEC addCourse ?, ?, ?, ?, ?, ?";
            try
            {
                PreparedStatement stm = DBConnection.conn.prepareStatement(query);
                stm.setString(1, nameField.getText());
                stm.setString(2, leaderNameField.getText());
                stm.setString(3, leaderSurnameField.getText());
                stm.setString(4, typeField.getText());
                stm.setInt(5, Integer.parseInt(semesterField.getText()));
                stm.setInt(6, DBConnection.UserId);
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
