package model;

import java.io.Serializable;

public class Book implements Serializable  {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;
    
    private String author;

    private String image;
    
    private Double value;

    public Book(Long id, String title, String author, String image, Double value) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.image = image;
        this.value = value;
    }

    public Book() {
       
    }
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
