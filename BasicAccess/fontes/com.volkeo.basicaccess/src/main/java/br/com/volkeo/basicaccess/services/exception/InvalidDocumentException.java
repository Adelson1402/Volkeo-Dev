package br.com.volkeo.basicaccess.services.exception;

public class InvalidDocumentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643406076990823586L;
	
    public InvalidDocumentException(String msg) {
      super(msg);	
    }
    
    public InvalidDocumentException(String msg , Throwable cause ) {
    super(msg,cause);	
    }
}