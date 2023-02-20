package ba.unsa.etf.rpr.domain;

import java.util.Date;

public class Member implements Idable {
    private int id;
    private String first_name;
    private String last_name;
    private Date join_date;

    public Member(){};
    public Member(int id, String first_name, String last_name,Date join_date){
        this.id=id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.join_date=join_date;
    };

    public int getId(){
        return id;
    }
    public String getFirst_name(){
        return first_name;
    }
    public String getLast_name(){
        return last_name;
    }
    public Date getJoin_date(){
        return join_date;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }
    public void setLast_name(String last_name){
        this.last_name = last_name;
    }
    public void setJoin_date(Date join_date){
        this.join_date = join_date;
    }
}
