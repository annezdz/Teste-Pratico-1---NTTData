package exceptions;

public class ContaException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ContaException(String msg) {
        super(msg);
    }
}
