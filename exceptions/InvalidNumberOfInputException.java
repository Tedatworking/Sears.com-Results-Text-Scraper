package exceptions;

/*
 * exception of invalid number of input arguments
 */

public class InvalidNumberOfInputException extends Exception {

	public InvalidNumberOfInputException(){
        super();
    }
    public InvalidNumberOfInputException(String msg){
        super(msg);
    }

}
