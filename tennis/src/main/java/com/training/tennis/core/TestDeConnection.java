package com.training.tennis.core;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class TestDeConnection {
    public static void main(String... args){
        Connection conn = null;
        try {
            //Seulement avant Java 7/JDBC 4
            //Class.forName(DRIVER_CLASS_NAME);

            MysqlDataSource dataSource = new MysqlDataSource();

            dataSource.setUrl();
            //MySQL driver MySQL Connector // com.mysql.jdbc.Driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris","root","root");
            PreparedStatement preparedStatement = conn.prepareStatement("update joueur set prenom = ?, nom =?, sexe =? where id = 1 ");

            String pnom = "chris";
            String nom = "sandjon";
            String sexe = "M";
                preparedStatement.setString(1,pnom);
                preparedStatement.setString(2,nom);
                preparedStatement.setString(3,sexe);
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
