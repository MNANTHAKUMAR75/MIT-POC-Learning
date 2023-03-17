package org.example.operations;

import org.example.database.TaskManagerConnection;
import org.example.database.TaskManagerPreparedStatement;
import org.example.model.TaskManager;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public class TaskManagerOperations {

    private TaskManagerOperations(){
    }
    //Adding tasks
    public static TaskManager addTask(TaskManager task){
        String sql="INSERT INTO TASKMANAGER (id, name, description,dueDate) VALUES (?, ?, ?, ?)";

        Connection connection=TaskManagerConnection.connect();
        PreparedStatement preparedStatement=null;
        preparedStatement=TaskManagerPreparedStatement.getPreparedStatement(connection,sql);

        try{
            preparedStatement.setInt(1,task.getId());
            preparedStatement.setString(2,task.getName());
            preparedStatement.setString(3,task.getDescription());
            preparedStatement.setDate(4,task.getDueDate());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error Adding Values: "+ e.getMessage());
        }
        finally {
            TaskManagerPreparedStatement.closePreparedStatement();
            TaskManagerConnection.disConnect();
        }

        return task;
    }

    //Updating Tasks
    public static TaskManager updateTask(TaskManager task,int taskId){
        String sql="UPDATE TASKMANAGER SET name=?, description=?, dueDate=? WHERE id=?";

        Connection connection=TaskManagerConnection.connect();
        PreparedStatement preparedStatement=null;
        preparedStatement=TaskManagerPreparedStatement.getPreparedStatement(connection,sql);


        try{
            preparedStatement.setString(1,task.getName());
            preparedStatement.setString(2,task.getDescription());
            preparedStatement.setDate(3,task.getDueDate());
            preparedStatement.setInt(4,taskId);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("Error Updating Values: "+e.getMessage());
        }
        finally {
            TaskManagerPreparedStatement.closePreparedStatement();
            TaskManagerConnection.disConnect();
        }

        return task;
    }

    //Updating Task
    public static void deleteTask(int taskId){
        String sql="DELETE FROM TASKMANAGER WHERE id=?";

        Connection connection=TaskManagerConnection.connect();
        PreparedStatement preparedStatement=null;
        preparedStatement=TaskManagerPreparedStatement.getPreparedStatement(connection,sql);

        try{
            preparedStatement.setInt(1,taskId);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("Error Deleting Value: "+ e.getMessage());
        }
        finally {
            TaskManagerPreparedStatement.closePreparedStatement();
            TaskManagerConnection.disConnect();
        }
    }

    //Get All Tasks
    public static List<TaskManager> getAllTasks(){
        String sql="SELECT * FROM TASKMANAGER";
        List<TaskManager> tasks=new ArrayList<>();
        Connection connection=TaskManagerConnection.connect();
        PreparedStatement preparedStatement=null;
        preparedStatement=TaskManagerPreparedStatement.getPreparedStatement(connection,sql);

        try(ResultSet result=preparedStatement.executeQuery(sql)){
            while(result.next()){
                int id=result.getInt("id");
                String name=result.getString("name");
                String description=result.getString("description");
                Date dueDate=result.getDate("dueDate");

                TaskManager task=new TaskManager(id,name,description, dueDate);
                tasks.add(task);
            }
        }
        catch (SQLException e){
            System.out.println("Error in viewing all messages: "+ e.getMessage());
        }
        finally {
            TaskManagerPreparedStatement.closePreparedStatement();
            TaskManagerConnection.disConnect();
        }

        return tasks;
    }

    //Get tasks by id
    public static TaskManager getTask(int taskId){
        String sql="select * FROM TaskManager WHERE id=?";
        TaskManager tasks=null;

        Connection connection=TaskManagerConnection.connect();
        PreparedStatement preparedStatement=null;
        preparedStatement=TaskManagerPreparedStatement.getPreparedStatement(connection,sql);

        try{
            preparedStatement.setInt(1,taskId);
            ResultSet result= preparedStatement.executeQuery();
            if(result.next()){
                int id=result.getInt("id");
                String name=result.getString("name");
                String description=result.getString("description");
                Date dueDate=result.getDate("dueDate");

                tasks=new TaskManager(id,name,description,dueDate);
            }
        }
        catch(SQLException e){
            System.out.println("Error retriving Task: "+e.getMessage());
        }
        finally {
            TaskManagerPreparedStatement.closePreparedStatement();
            TaskManagerConnection.disConnect();
        }
        return tasks;
    }
}
