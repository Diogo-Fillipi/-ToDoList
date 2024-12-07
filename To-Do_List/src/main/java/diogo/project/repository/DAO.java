package diogo.project.repository;

import diogo.project.model.Task;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    public void createTask(Task task){
        try{
            PreparedStatement ps = DbTasks.getConnection().prepareStatement("INSERT INTO Tasks (Namee, DueDate) VALUES (?, ?)");
            ps.setString(1, task.getDescription());
            ps.setString(2, task.getDueDate());
            ps.execute();
            System.out.println("Task created in the database");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void readTask(){
        try{
            PreparedStatement ps = DbTasks.getConnection().prepareStatement("SELECT * FROM Tasks");
            ResultSet tasks = ps.executeQuery();
            System.out.println("----------------------------------------------");
            while(tasks.next()){
                System.out.println("Task id in the database: " + "[" + tasks.getInt("task_id") + "]");
                System.out.println("Task name in the database: " + "[" + tasks.getString("namee") + "]");
                System.out.println("Task due date in the database: " + "[" + tasks.getString("dueDate") + "]");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateTask(Task task){
        try{
            PreparedStatement ps = DbTasks.getConnection().prepareStatement("UPDATE Tasks SET namee = ?, dueDate = ? WHERE task_id = ?");
            ps.setString(1, task.getDescription());
            ps.setString(2, task.getDueDate());
            ps.setInt(3, task.getTaskId());
            ps.executeUpdate();
            System.out.println("Task updated in the database");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteTask(Task task){
        try{
            PreparedStatement ps = DbTasks.getConnection().prepareStatement("DELETE FROM Tasks WHERE task_id = ?");
            ps.setInt(1, task.getTaskId());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
