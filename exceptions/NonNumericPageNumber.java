package exceptions;

public class NonNumericPageNumber extends Exception {
	
	public NonNumericPageNumber(){
        super();
    }
    public NonNumericPageNumber(String msg){
        super(msg);
    }

}
