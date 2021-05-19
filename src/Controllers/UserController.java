package Controllers;

import Modules.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class UserController {
    private User USER;
    private LinkedList<User> USERS;
    
    // Constructor - Load all USERS in the RAM memory
    public UserController(){
        readUser();
    }
    
    public void readUser(){
        try{
            FileReader FILEREADER;
            BufferedReader BUFFEREDREADER;
            String FILECONTENT;
            String[] FILEDATA;

            FILEREADER = new FileReader("test/users.txt");
            BUFFEREDREADER = new BufferedReader(FILEREADER);
            USERS = new LinkedList<User>();
            while((FILECONTENT = BUFFEREDREADER.readLine()) != null){
                FILEDATA = FILECONTENT.split(",");
                USER = new User(FILEDATA[0],FILEDATA[1],FILEDATA[2],Boolean.parseBoolean(FILEDATA[3]));
                USERS.add(USER);
            }
            FILEREADER.close();
        }catch(IOException error){
            System.out.println("Error while reading users.");
        }
    }
    
    //CRUD - Read USER to check if it exists
    public boolean readUser(String USERNAME, String PASSWORD){
        for (int i = 0; i < USERS.size(); i++) {
            if (USERS.get(i).getUsername().equals(USERNAME) && USERS.get(i).getPassword().equals(PASSWORD) && !USERS.get(i).getIsStaff()) {
                System.out.println("User " + USERS.get(i).getUsername() + " read.");
                return true;
            }
        }
        return false;
    }
    
    public boolean readStaff(String USERNAME, String PASSWORD){
        for (int i = 0; i < USERS.size(); i++) {
            if(USERS.get(i).getUsername().equals(USERNAME) && USERS.get(i).getPassword().equals(PASSWORD) && USERS.get(i).getIsStaff()){
                return true;
            }
        }
        return false;
    }
}
