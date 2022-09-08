package com.example.messenger;

import java.sql.*;

import static java.lang.System.out;

public class UserRepository {
    public static Connection getConnection() {

        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/messenger ";
        String user = "postgres";
        String password = "174180183";

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                out.println("Connected to the PostgreSQL server successfully.");
            } else {
                out.println("Failed to make connection!");
            }
        } catch (SQLException sqlException) {
            out.println(sqlException);
        }
        return connection;
    }
    public static int save(User myUser) throws SQLException {

        int status = 0;
        try {





            Connection connection = UserRepository.getConnection();


            PreparedStatement ps = connection.prepareStatement("insert into users (login,password) values (?,?)");


            ps.setString(1, myUser.getLogin());
            ps.setString(2, myUser.getPassword());



            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }








    public static User createUser(ResultSet rs) throws SQLException {
        User myUser = new User();


        myUser.setPassword(rs.getString(3));
        myUser.setLogin(rs.getString(4));


        return myUser;
    }




    public static boolean checkPass(User myUser) throws SQLException {
        Connection connection = UserRepository.getConnection();
        PreparedStatement test=connection.prepareStatement("SELECT count(*) FROM users WHERE  password=? and login=?");

        test.setString(1,myUser.getPassword());
        test.setString(2,myUser.getLogin());

        ResultSet res= test.executeQuery();
        int result=0;
        if (res.next()){
            result = res.getInt("count");
        }

        return result>0;
    }


}
