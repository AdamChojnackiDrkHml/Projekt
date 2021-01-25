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

public class RegisterFrame extends JFrame implements ActionListener
{
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField mailField;
    private JTextField indexField;
    private JTextField facultyField;
    private JTextField fieldOfStudyField;
    private JTextField passwordField;
    private final JTextField[] textFieldArray = {nameField, surnameField, mailField, indexField, facultyField, fieldOfStudyField, passwordField};

    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel mailLabel;
    private JLabel indexLabel;
    private JLabel facultyLabel;
    private JLabel fieldOfStudyLabel;
    private JLabel passwordLabel;
    private final JLabel[] labelArray = {nameLabel, surnameLabel, mailLabel, indexLabel, facultyLabel, fieldOfStudyLabel,passwordLabel};

    private final String[] namesArray = {"Imie", "Nazwisko", "mail studencki", "Index", "Numer Wydzialu", "Nazwa kierunku", "Haslo"};

    private JButton registerButton = new JButton("Register");


    RegisterFrame()
    {
        super("Rejestracja");
        setLayout(new GridLayout(8,2));
        for(int i = 0; i < textFieldArray.length; i++)
        {
            labelArray[i] = new JLabel(namesArray[i]);
            this.getContentPane().add(labelArray[i]);
            textFieldArray[i] = new JTextField();
            this.getContentPane().add(textFieldArray[i]);
        }
        this.getContentPane().add(registerButton);
        registerButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(registerButton))
        {
            String query = "EXEC addUser ?, ?, ?, ?, ?, ?, ?";
            for(JTextField textField : textFieldArray)
            {
                if(textField.getText().isEmpty())
                {
                    return;
                }

            }
            try
            {
                PreparedStatement stm = DBConnection.conn.prepareStatement(query);
                stm.setInt(4, Integer.parseInt(textFieldArray[3].getText()));
                stm.setInt(5, Integer.parseInt(textFieldArray[4].getText()));
                stm.setString(1, textFieldArray[0].getText());
                stm.setString(2, textFieldArray[1].getText());
                stm.setString(3, textFieldArray[2].getText());
                stm.setString(6, textFieldArray[5].getText());
                stm.setString(7, textFieldArray[6].getText());
                stm.execute();

                query = "SELECT TOP 1 Message FROM Results WHERE UserId = 4 ORDER BY MessageId DESC";
                Statement stm2 = DBConnection.conn.createStatement();
                ResultSet resultSet = stm2.executeQuery(query);
                resultSet.next();
                String answer = resultSet.getString("Message");
                JOptionPane.showMessageDialog(this, answer);
                if(answer.equals("Pomyslnie dodano"))
                {

                    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                }

            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }


        }
    }


}
