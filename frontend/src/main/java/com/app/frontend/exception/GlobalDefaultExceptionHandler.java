package com.app.frontend.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.mani.backend.dto.Product;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		
		ModelAndView model = new ModelAndView("error");
		model.addObject("errorTitle","The Page is not constructed");
		model.addObject("errorDescription","The Page your looking for is not available now!");
		model.addObject("title","404 Error Page");
		return model;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		
		ModelAndView model = new ModelAndView("error");
		model.addObject("errorTitle","Product is not available");
		model.addObject("errorDescription","The Product your looking for is not available right now!");
		model.addObject("title","Product Unavailable");
		return model;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		
		ModelAndView model = new ModelAndView("error");
		model.addObject("errorTitle","Contact Your Administrator!");
		model.addObject("errorDescription",ex.toString());
		model.addObject("title","Error");
		return model;
	}
	

}
