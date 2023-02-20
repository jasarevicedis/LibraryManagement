package ba.unsa.etf.rpr.domain;

public class Book implements Idable {

    private int id;
    private String title;
    private int PublishYear;
    private String author;

    public Book(){};
    public Book(int id, String title, int PublishYear, String author){
        this.id=id;
        this.title=title;
        this.PublishYear = PublishYear;
        this.author=author;
    };
    @Override
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
    @Override
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

