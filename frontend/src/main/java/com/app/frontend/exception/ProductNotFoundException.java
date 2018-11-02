package com.app.frontend.exception;

public class ProductNotFoundException extends Exception{
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ProductNotFoundException()
	{
		this("this product is not available");
	}
	
	public ProductNotFoundException(String messge)
	{
		this.message = System.currentTimeMillis()+" :"+message;
	}
	
	

}
