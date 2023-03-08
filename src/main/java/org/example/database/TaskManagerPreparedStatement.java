package org.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskManagerPreparedStatement {
    private static PreparedStatement preparedStatement=null;

    public static PreparedStatement getPreparedStatement(Connection connection,String sql){
        try{
            preparedStatement=connection.prepareStatement(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static void closePreparedStatement(){
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
