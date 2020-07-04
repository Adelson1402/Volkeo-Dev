package br.com.volkeo.basicaccess.services.exception;

public class ObjectNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643406076990823586L;
	
    public ObjectNotFoundException(String msg) {
      super(msg);	
    }
    
    public ObjectNotFoundException(String msg , Throwable cause ) {
    super(msg,cause);	
    }
}
