package exception;

public class BookNotFoundException extends NotFoundException{
    public BookNotFoundException ( Integer id ) { super("Book" , id);}
}
