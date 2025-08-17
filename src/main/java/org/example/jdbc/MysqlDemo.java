package org.example.jdbc;

import java.sql.*;

public class MysqlDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/aliens";
        String user = "root";
        String password = "root";

        try {
            // Load driver (not required in newer versions, but safe to keep)
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(url, user, password);
                 Statement st = con.createStatement()) {

                // Drop table if exists
                String query = "drop table if exists employee";
                int rowsAffected = st.executeUpdate(query);
                System.out.println("Drop table, affected rows = " + rowsAffected);

                // Create table
                query = "create table employee (id int primary key, name varchar(256))";
                rowsAffected = st.executeUpdate(query);
                System.out.println("Create table, affected rows = " + rowsAffected);

                // Insert using Statement
                query = "insert into employee (id,name) values(1,'Niki'),(2,'Anu')";
                rowsAffected = st.executeUpdate(query);
                System.out.println("Insert using Statement, affected rows = " + rowsAffected);

                // Select single row
                query = "select * from employee where id=2";
                try (ResultSet rs = st.executeQuery(query)) {
                    if (rs.next()) {
                        System.out.println("Row with id=2 => " + rs.getInt(1) + ":" + rs.getString(2));
                    }
                }

                // Select all
                query = "select * from employee";
                try (ResultSet rs = st.executeQuery(query)) {
                    System.out.println("All rows in employee:");
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + ":" + rs.getString(2));
                    }
                }

                // Update using PreparedStatement
                query = "update employee set name=? where id=?";
                try (PreparedStatement ps = con.prepareStatement(query)) {
                    ps.setString(1, "Rani");
                    ps.setInt(2, 1);
                    rowsAffected = ps.executeUpdate();
                    System.out.println("Update, affected rows = " + rowsAffected);
                }

                // Insert using PreparedStatement
                query = "insert into employee values(?, ?)";
                try (PreparedStatement ps = con.prepareStatement(query)) {
                    ps.setInt(1, 3);
                    ps.setString(2, "Raj");
                    rowsAffected = ps.executeUpdate();
                    System.out.println("Insert using PreparedStatement, affected rows = " + rowsAffected);
                }

                // Delete using PreparedStatement
                query = "delete from employee where id=?";
                try (PreparedStatement ps = con.prepareStatement(query)) {
                    ps.setInt(1, 2);
                    rowsAffected = ps.executeUpdate();
                    System.out.println("Delete, affected rows = " + rowsAffected);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
