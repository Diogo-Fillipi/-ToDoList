package diogo.project.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbTasks{

    private static final String url = "[Your database url]";
    private static final String user = "[Your database user]";
    private static final String password = "[Your database Password]";

    private static Connection conn;

    public static Connection getConnection(){

        try{
            if(conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else{
                return conn;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}

