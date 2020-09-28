package be.abis.exg05.exception;

public class AgeCannotBeNegativeException extends Exception {

    public AgeCannotBeNegativeException(){
        super();
    }

    public AgeCannotBeNegativeException(String message){
        super(message);
    }

    public AgeCannotBeNegativeException(Throwable throwable){
        super(throwable);
    }

    public AgeCannotBeNegativeException(String message, Throwable throwable){
        super(message,throwable);
    }
}
