package Modules;

public class User {
    private String USERNAME;
    private String PASSWORD;
    private String EMAIL;
    private boolean ISSTAFF;

    public User(String USERNAME, String PASSWORD, String EMAIL, boolean isStaff) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.EMAIL = EMAIL;
        this.ISSTAFF = isStaff;
    }

    public boolean getIsStaff() {
        return ISSTAFF;
    }

    public void setIsStaff(boolean isStaff) {
        this.ISSTAFF = isStaff;
    }

    

    public String getEmail() {
        return EMAIL;
    }

    public void setEmail(String EMAIL) {
        this.EMAIL = EMAIL;
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
