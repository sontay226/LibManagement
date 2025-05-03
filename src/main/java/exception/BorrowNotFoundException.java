package exception;

public class BorrowNotFoundException extends NotFoundException {
    public BorrowNotFoundException ( Integer id ) { super("Borrow" , id);}
}
