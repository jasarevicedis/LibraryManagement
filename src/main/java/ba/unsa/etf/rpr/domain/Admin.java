package ba.unsa.etf.rpr.domain;

public class Admin {
    private int id;
    private String username;
    private String password;

    //getteri
    public int getId() {
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    //setteri
    public void setId(int id){
        this.id = id;
    }
    public  void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
}


