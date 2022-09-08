package com.example.messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class RoomRepository {
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
    public static int save(Room myRoom) throws SQLException {

        int status = 0;
        try {





            Connection connection = UserRepository.getConnection();


            PreparedStatement ps = connection.prepareStatement("insert into rooms (name,password) values (?,?)");


            ps.setString(1, myRoom.getName());
            ps.setString(2, myRoom.getPassword());



            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }












    public static boolean checkPass(Room myRoom) throws SQLException {
        Connection connection = UserRepository.getConnection();
        PreparedStatement test=connection.prepareStatement("SELECT count(*) FROM rooms WHERE  password=? and name=?");

        test.setString(1,myRoom.getPassword());
        test.setString(2,myRoom.getName());

        ResultSet res= test.executeQuery();
        int result=0;
        if (res.next()){
            result = res.getInt("count");
        }

        return result>0;
    }
    public static List<Room> getAllRooms() {

        List<Room> listBooks = new ArrayList<>();
//todo orders by
        try {
            Connection connection = RoomRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from rooms");


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {


                Room myRoom=new Room();
                myRoom.setName(rs.getString("name"));

                listBooks.add(myRoom);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBooks;
    }
    public static int write(Mail myMail) throws SQLException {

        int status = 0;
        try {





            Connection connection = UserRepository.getConnection();


            PreparedStatement ps = connection.prepareStatement("insert into message (text,author,room) values (?,?,?)");


            ps.setString(1, myMail.getText());
            ps.setString(2, myMail.getAuthor());
            ps.setString(3,myMail.getRoom());


            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static List<Mail> getAllMails() {

        List<Mail> listBooks = new ArrayList<>();
//todo orders by
        try {
            Connection connection = RoomRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from message");


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {


                Mail myMail=new Mail();
                myMail.setText(rs.getString("text"));
                myMail.setAuthor(rs.getString("author"));

                listBooks.add(myMail);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBooks;
    }

}

