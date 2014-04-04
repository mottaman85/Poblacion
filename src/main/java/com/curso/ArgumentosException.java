package com.curso;

public class ArgumentosException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2756404880754759474L;

	public ArgumentosException(){
		super();
	}

	public ArgumentosException(String msj){
		super("001-"+msj);
	}
	
}
