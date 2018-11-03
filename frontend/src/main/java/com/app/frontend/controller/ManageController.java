package com.app.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.frontend.util.FileUploadUtility;
import com.mani.backend.dao.CategoryDao;
import com.mani.backend.dao.ProductDao;
import com.mani.backend.dto.Category;
import com.mani.backend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManageController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;

	@RequestMapping(value ="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false)String operation)
	{
		System.out.println("inside show manageproducts");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product product = new Product();
		product.setActive(true);
		product.setSupplierId(1);
		mv.addObject("product", product);
		
		if(operation!=null)
		{
			if(operation.equals("product"))
			{
				
				mv.addObject("message", "Product Submitted Successfully!");
			}
		}
		
		return mv;
		
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDao.list();
	}
	
	@RequestMapping(value ="/products",method=RequestMethod.POST)
	public String  submitProduct(@Valid @ModelAttribute("product")Product product,BindingResult bindingResult,Model model,HttpServletRequest request)
	{
		
		if(bindingResult.hasErrors())
		{
			
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title","Manage Product");
			model.addAttribute("message", "Validation failed for Product Submission!");
			return "page";
		}
		
		boolean flag = productDao.add(product);
		
		if(!product.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request, product.getFile(),product.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	

}
