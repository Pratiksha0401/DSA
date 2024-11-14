package org.example.jdbc;

import java.sql.*;

public class MysqlDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens","root","root");
        Statement st = con.createStatement();

        // drop table
        String query = "drop table employee";
        int rowsAffected = st.executeUpdate(query);
        System.out.println("affected rows"+rowsAffected);

        //create table
        query = "create table employee (id int , name varchar(256), primary key (id))";
        rowsAffected = st.executeUpdate(query);
        System.out.println("affected rows"+rowsAffected);

        //insert
//        query = "insert into alien (id,name) values(3,'Niki'),(4,'Anu')";
//        rowsAffected = st.executeUpdate(query);
//        System.out.println("affected rows"+rowsAffected);

        // select 1
        query = "select * from alien where id=2";
        ResultSet rs = st.executeQuery(query);
        rs.next();
        System.out.println(rs.getInt(1)+":"+rs.getString(2));

        query = "select * from alien";
        rs = st.executeQuery(query);
        while(rs.next()) {
            System.out.println(rs.getInt(1) + ":" + rs.getString(2));
        }

        //update
        query = "update alien set name='rani' where id=3";
        st.execute(query);

        query = "insert into alien values(?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,7);
        ps.setString(2,"Raj");
        rowsAffected = ps.executeUpdate();
        System.out.println("affected rows"+rowsAffected);

        query = "delete from alien where id=?";
        ps = con.prepareStatement(query);
        ps.setInt(1,5);
        rowsAffected = ps.executeUpdate();
        System.out.println("affected rows"+rowsAffected);

        st.close();
        con.close();
    }
}
