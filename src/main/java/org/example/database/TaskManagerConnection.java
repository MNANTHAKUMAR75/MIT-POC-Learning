package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TaskManagerConnection {
    private static final String DB_URL="jdbc:mysql://localhost:3306/task";
    private static final String DB_USER="root";
    private static final String DB_PASSWORD="nantha123";
    private static final String DB_DRIVER="com.mysql.jdbc.Driver";
    private  static Connection connection=null;

    public static Connection connect(){
        try{
            Class.forName(DB_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void disConnect(){
        if (connection!=null){
            try {
                connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
