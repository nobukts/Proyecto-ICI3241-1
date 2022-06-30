package Exceptions;

public class CodigoMalEscritoException extends RuntimeException {
    public CodigoMalEscritoException(){
        super("El código se encuentra mal escrito");
    }
}
