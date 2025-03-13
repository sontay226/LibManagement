package Entities;

public class Book {
    private String Name ,  Author , Genre;
    private int Id , Quantity;
    public Book () {}
    public Book( int Id , int Quantity , String Name , String Author , String Genre) {
        this.Id = Id;
        this.Author = Author;
        this.Name = Name;
        this.Genre = Genre;
        this.Quantity = Quantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
