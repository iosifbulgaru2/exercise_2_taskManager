import java.io.*;
import java.util.ArrayList;
import java.lang.ClassNotFoundException;

public class Main {
    public static ArrayList<User> users = new ArrayList<>() ;
    static String [] args;
    static  ArrayList<Object> deserialized = new ArrayList<>();

    static public String getArgs(String info){
        String str;
        str= info.split("=")[1];
       return str;
   }

    public static void inputUser(){
        loadData();
        User us = new User(getArgs(args[1]), getArgs(args[2]), getArgs(args[3]));
        users.add(us);
    }

    //Serialize data
    public static void saveData(){
        //Arr object to store all objects (all types)
        ArrayList<Object> data = new ArrayList<Object>();
        data.addAll(users);
       try{
           FileOutputStream fileOut = new FileOutputStream("data.ser");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(data);
           out.close();
           fileOut.close();
           System.out.println("Serialized data is  saved in <data.ser> !");
       }catch (IOException i){
            i.printStackTrace();
       }
    }
    //deserealize data
    public static void loadData(){
        //Array for desirialized objects
        try{
            FileInputStream fileIn = new FileInputStream("data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserialized =  (ArrayList<Object>)in.readObject();
            in.close();
            fileIn.close();
        }catch (IOException | ClassNotFoundException i){
            i.printStackTrace();
        }
    }

    public  static void printUsers(){
        //separate all objects
        loadData();
        User [] user = new User[deserialized.size()];
        for (int i = 0; i < deserialized.size(); i++) {
            user[i] = (User)deserialized.get(i);
            user[i].printUser();
        }
    }
    public  static void addTask( String username){
        for ( User u : users) {
            u.getUserName();
            System.out.println(getArgs(args[1]));
            if (u.getUserName() == username){
                u.tasks.add(new Task(username, getArgs(args[2]), getArgs(args[3])));
                System.out.println("Task added! ");
                saveData();
            }
        }
    }

    public static void main(String[] ar) {
        args = new String[ar.length];
        for (int i = 0; i < ar.length; i++) {
            args[i] = getArgs(ar[i]);
        }
        switch(args[0]) {
            case "-createUser":
                inputUser();
                saveData();
                break;
            case "-showAllUsers":
                loadData();
                printUsers();
                break;
            case "-addTask":
                loadData();
                addTask(getArgs(args[1]));
                break;
            default:
        }

    }
}
