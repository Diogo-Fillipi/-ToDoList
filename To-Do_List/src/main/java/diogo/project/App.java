package diogo.project;

import diogo.project.utils.TasksManager;


import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        TasksManager taskManager = new TasksManager();
        int i = 0;
        Scanner inPut = new Scanner(System.in);
        System.out.println("-------------------------------");
        System.out.println("|Be welcome to the To-do list!|");
        System.out.println("-------------------------------");
        while (i != 5) {

            System.out.println("What do you wanna do?");
            System.out.println("[1] Create a new task\n[2] Delete a task\n[3] Show the current tasks\n[4] Change the task informations\n[5] End the to-do list");
            int x = inPut.nextInt();
            if(x > 5){
                System.out.println("please select a valid option");
            }
            switch (x) {
                case 1:
                    inPut.nextLine();
                    taskManager.toAddTask();
                    break;
                case 2:
                    taskManager.taskToDelete();
                    System.out.println("-------------------------------");
                    break;
                case 3:
                    taskManager.toShowTasks();
                    System.out.println("-------------------------------");
                    break;
                case 4:
                    taskManager.toUpdate();
                    break;
                case 5:
                    System.out.println("-------------------------------");
                    System.out.println("|     Ending the program...   |");
                    System.out.println("-------------------------------");
                    i = 5;
                    break;
            }
        }
    }
}