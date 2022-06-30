package Exceptions;

public class RunMalEscritoException extends RuntimeException {
    public RunMalEscritoException(){
        super("Run ingresado está mal escrito");
    }
}
