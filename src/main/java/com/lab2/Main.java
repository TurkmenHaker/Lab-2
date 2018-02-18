package com.lab2;

import javax.swing.*;
import java.sql.*;

public class Main {


    public static void main(String[] args) {

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            //connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //Statement statement=connection.createStatement();

            //if (!connection.isClosed())
              //  System.out.println("Соединение с БД установлено");
        } catch (SQLException e) {
            System.out.println("Драйвер не зарегистрировался");
        }




        JFrame frame=new JFrame("Заявка на коммунальные услуги");
        frame.setContentPane(new SampleForm().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);





    }
}
