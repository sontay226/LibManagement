package exception;

public class NotFoundException extends BaseException{
    public NotFoundException ( String entity , Object key ) { super(entity + " with id " + key + " not exist!");}
}
