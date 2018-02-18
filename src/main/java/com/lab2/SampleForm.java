package com.lab2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleForm extends JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/app_database?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public JPanel panelMain;
    public JTextField user;
    public JTextField tpofwork;
    public JTextField scofwork;
    public JTextField leadtime;
    public JButton sendBtn;
    private JButton clearBtn;


    public SampleForm() {
        sendBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String namew =user.getText();
                String typew=tpofwork.getText();
                String scopew=scofwork.getText();
                String timew=leadtime.getText();

                Connection connection;
                try {
                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    if (!connection.isClosed())
                        System.out.println("Соединение с БД установлено");
                    Statement statement=connection.createStatement();
                    statement.execute("INSERT INTO application(user,type,scope,time) VALUES('"+namew+"','"+typew+"','"+scopew+"','"+timew+"')");
                    JOptionPane.showConfirmDialog(null,"Ваша зявка прията. Бригада будет отправлена!","Принята",JOptionPane.PLAIN_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                user.setText("");
                tpofwork.setText("");
                scofwork.setText("");
                leadtime.setText("");

            }
        });
    }
}
