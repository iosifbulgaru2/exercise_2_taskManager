import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
   private String FirstName,LastName, userName;
   public ArrayList<Task> tasks = new ArrayList<>();

    public User(String user, String Name, String LName) {
        this.FirstName = Name;
        this.LastName = LName;
        this.userName = user;
    }
    public  void inputTasks(String username) {
            if(this.getUserName() == username){
                Task ts = new Task(username, "task 1", "description 1");
                this.tasks.add(ts);
        }
    }

    public void printUser(){
        System.out.println("FirstName: " + FirstName);
        System.out.println("LastName: " + LastName);
        System.out.println("userName: " + userName);
        System.out.println("  User's tasks: ");
        for ( Task t: tasks) {
            t.printTask();
        }
    }


    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getLastName() {return LastName;}
    public void setLastName(String lastName) {LastName = lastName;}
    public String getFirstName() {return FirstName;}
    public void setFirstName(String firstName) {FirstName = firstName;}
}
