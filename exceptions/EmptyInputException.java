package exceptions;

/*
 * exception of empty input
 */

public class EmptyInputException extends Exception {
	
	public EmptyInputException(){
        super();
    }
    public EmptyInputException(String msg){
        super(msg);
    }
}
