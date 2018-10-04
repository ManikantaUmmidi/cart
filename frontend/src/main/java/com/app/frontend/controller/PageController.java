package com.app.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mani.backend.dao.CategoryDao;

@Controller
public class PageController {

	@Autowired
	private CategoryDao categoryDao;
	
	
	
	@RequestMapping({"/","home"})
	public ModelAndView home()
	{
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "Home");
		model.addObject("userClickHome", true);
		model.addObject("categories",categoryDao.list());
	
		return model;
		
	}
	
	@RequestMapping("/about")
	public ModelAndView about()
	{
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "About Us");
		model.addObject("userClickAbout", true);
	
		return model;
		
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact()
	{
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "Contact Us");
		model.addObject("userClickContact", true);
	
		return model;
		
	}
	
	@RequestMapping("/show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView model = new ModelAndView("page");
		model.addObject("title", "All Products");
		model.addObject("categories",categoryDao.list());
		model.addObject("userClickAllProducts", true);
	
		return model;
		
	}
	@RequestMapping("/show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id")int id)
	{
		
		
		ModelAndView model = new ModelAndView("page");
		model.addObject("categories",categoryDao.list());
		model.addObject("category",categoryDao.get(id));
		model.addObject("title",categoryDao.get(id).getName() );
		
		model.addObject("userClickCategoryProducts", true);
	
		return model;
		
	}
	
	
}
