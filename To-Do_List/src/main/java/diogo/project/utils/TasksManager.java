package diogo.project.utils;

import diogo.project.model.Task;
import diogo.project.repository.DAO;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class TasksManager{

    private HashMap<Integer, Task> tasks;
    private DAO db;
    private Integer index;
    private Scanner inPut;

    public TasksManager(){
        this.tasks = new HashMap<>();
        this.db = new DAO();
        this.index = 1;
        this.inPut = new Scanner(System.in);
    }

    public void toAddTask() {
        System.out.println("Type the task name: ");
        String name = inPut.nextLine();
        System.out.println("Type the task due date: ");
        String date = inPut.nextLine();
        Task task = new Task(name, date, index);
        tasks.put(index, task);
        db.createTask(task);
        index++;
        System.out.println(tasks.toString());
    }


   public Task taskToDelete(){
        db.readTask();
        System.out.println("Choose the task you want to delete according to its index");
        Integer indexToDelete = inPut.nextInt();
        if(!tasks.containsKey(indexToDelete)){
            System.out.println("Index doesnt exist in the HashMap");
            return null;
        }
        db.deleteTask(tasks.get(indexToDelete));
        tasks.remove(indexToDelete);
        return tasks.get(index);
    }


    public void toShowTasks() {
        db.readTask();

    }

    public Task toUpdate() {
        System.out.println("Choose a task according to its index to change its informations.");
        db.readTask();
        Integer index = inPut.nextInt();
        inPut.nextLine();
        if(!tasks.containsKey(index)){
            System.out.println("Index doesnt exist in the HashMap");
            return null;
        }
        System.out.println("The task selected is:\n" + tasks.get(index).getDescription());
        System.out.println("Type [1] if you want to change the name or [2] if you want to change the due date.");
        int x = inPut.nextInt();
        switch(x){
            case 1:
                System.out.println("Type the new name for the task");
                inPut.nextLine();
                String nameMod = inPut.nextLine();
                tasks.get(index).setDescription(nameMod);
                db.updateTask(tasks.get(index));
                System.out.println("Task name changed with success!");
                System.out.println("-------------------------------");
                break;
            case 2:
                System.out.println("Type the new due date for th    e task");
                inPut.nextLine();
                String dueDateMod = inPut.nextLine();
                tasks.get(index).setDueDate(dueDateMod);
                db.updateTask(tasks.get(index));
                System.out.println("Task due date changed with success!");
                System.out.println("-------------------------------");
                break;
        }
        return tasks.get(index);
    }
}
