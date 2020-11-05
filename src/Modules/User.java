package Modules;

public class User {
    protected String USERNAME;
    protected String PASSWORD;
    
    // Constructor without parameters
    public User(){ 
    }
    
    // Constructor with parameters
    public User(String u, String p){
        this.USERNAME = u;
        this.PASSWORD = p;
    }
    
    // Username accessor
    public String getUsername(){
        return USERNAME;
    }
    
    // Username mutator
    public void setUsername(String u){
        this.USERNAME = u;
    }
    
    // Password accessor
    public String getPassword(){
        return PASSWORD;
    }
    
    // Password mutator
    public void setPassword(String p){
        this.PASSWORD = p;
    }
    
}
