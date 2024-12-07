package diogo.project.model;

public class Task {

    public Task(String desc, String date, int taskId){
        this.description = desc;
        this.dueDate = date;
        this.taskId = taskId;
    }

    private String description;
    private String dueDate;
    private int taskId;

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String descMod){
        this.description = descMod;
    }
    public String getDueDate(){
        return this.dueDate;
    }
    public void setDueDate(String dueDateMod){
        this.dueDate = dueDateMod;
    }
    public int getTaskId(){
        return this.taskId;
    }
    public void setTaskId(int taskId){
        this.taskId = taskId;
    }


}

