package ba.unsa.etf.rpr.domain;

public class Book {
    private int id;
    private String title;
    private int PublishYear;
    private String author;

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public int getPublishYear(){
        return PublishYear;
    }
    public String getAuthor(){
        return author;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setPublishYear(int PublishYear){
        this.PublishYear = PublishYear;
    }
    public void setAuthor(String author){
        this.author = author;
    }
}

