public class User {
    
    public static int incrementer = 0;
    int User_Id; 
    String name;
    String password;

    public User(String name, String password){
        this.name = name;
        this.password = password;
        User.incrementer = incrementer+1;
        this.User_Id = incrementer;
    }


    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
