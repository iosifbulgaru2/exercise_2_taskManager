import java.io.Serializable;

public class Task implements Serializable {
    private String username, TaskTitle, Description;

    Task(String username, String TaskTitle, String Description ){
        this.Description = Description;
        this.TaskTitle = TaskTitle;
        this.username = username;
    }


    public void printTask(){
        System.out.println("   TaskTitle: " + TaskTitle);
        System.out.println("   Description: " + Description);
    }

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getTaskTitle() {return TaskTitle;}
    public void setTaskTitle(String taskTitle) {TaskTitle = taskTitle;}
    public String getDescription() {return Description;}
    public void setDescription(String description) {Description = description;}
}
