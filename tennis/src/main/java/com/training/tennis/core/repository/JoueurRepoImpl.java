package com.training.tennis.core.repository;

import com.training.tennis.core.entity.Joueur;

import java.sql.*;

public class JoueurRepoImpl {

    public void create(Joueur joueur) {
        Connection conn = null;
        try {
            //Seulement avant Java 7/JDBC 4
            //Class.forName(DRIVER_CLASS_NAME);

            //MySQL driver MySQL Connector // com.mysql.jdbc.Driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "root");
            PreparedStatement preparedStatement = conn.prepareStatement("insert into joueur (prenom,nom,sexe) values (?,?,?)");

            preparedStatement.setString(1, joueur.getPrenom());
            preparedStatement.setString(2, joueur.getNom());
            preparedStatement.setString(3, joueur.getSexe().toString());
            preparedStatement.executeUpdate();
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Joueur joueur) {
        Connection conn = null;
        try {
            //Seulement avant Java 7/JDBC 4
            //Class.forName(DRIVER_CLASS_NAME);

            //MySQL driver MySQL Connector // com.mysql.jdbc.Driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "root");
            PreparedStatement preparedStatement = conn.prepareStatement("update joueur set prenom = ?, nom =?, sexe =? where id = 1 ");

            preparedStatement.setString(1, joueur.getPrenom());
            preparedStatement.setString(2, joueur.getNom());
            preparedStatement.setString(3, joueur.getSexe().toString());
            preparedStatement.executeUpdate();
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(Long id) {
        Connection conn = null;
        try {
            //Seulement avant Java 7/JDBC 4
            //Class.forName(DRIVER_CLASS_NAME);

            //MySQL driver MySQL Connector // com.mysql.jdbc.Driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "root");
            PreparedStatement preparedStatement = conn.prepareStatement("delete from joueur where id = ? ");

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void getById(Long id) {
        Connection conn = null;
        Joueur joueur = null;
        try {
            //Seulement avant Java 7/JDBC 4
            //Class.forName(DRIVER_CLASS_NAME);

            //MySQL driver MySQL Connector // com.mysql.jdbc.Driver
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "root");
            PreparedStatement preparedStatement = conn.prepareStatement("select * from joueur where id = ? ");

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                joueur = new Joueur();
                joueur.setId(id);
                joueur.setNom(resultSet.getString("nom"));
                joueur.setPrenom(resultSet.getString("prenom"));
                joueur.setSexe(resultSet.getString("sexe").charAt(0));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
