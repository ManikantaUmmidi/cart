package com.app.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.frontend.util.FileUploadUtility;
import com.app.frontend.validator.ProductValidator;
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
			else if(operation.equals("category"))
			{
				mv.addObject("message", "Category Submitted Successfully!");
			}
		}
		
		return mv;
		
	}
	
	
   //get product with edit form
	@RequestMapping(value ="/{id}/product",method=RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id)
	{
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product product = productDao.get(id);
		mv.addObject("product", product);
		
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
		
		if(product.getId() == 0){
		
		new ProductValidator().validate(product, bindingResult);
		}
		else
		{
			if(!product.getFile().getOriginalFilename().equals(""))
			{
				new ProductValidator().validate(product, bindingResult);
			}
		}
		
		if(bindingResult.hasErrors())
		{
			
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title","Manage Product");
			model.addAttribute("message", "Validation failed for Product Submission!");
			return "page";
		}
		
		
		if(product.getId() == 0){
		 productDao.add(product);
		}
		else
		{
			productDao.update(product);
		}
		
		if(!product.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request, product.getFile(),product.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	public String handleProductActivation(@PathVariable int id)
	{
		
		Product pro = productDao.get(id);
		boolean isActivate = pro.isActive();
		
		pro.setActive(!isActivate);
		
		productDao.update(pro);
		
		
		return (isActivate)?"You have Successfully Deactivate the Product With Id "+pro.getId()
		
			               :"You have Successfully Activate the Product With Id "+pro.getId();
	}
	
	
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String categoryFormSubmission(@ModelAttribute("category")Category category)
	{
		categoryDao.add(category);
		
		return "redirect:/manage/products?operation=category";
	}
	
	
	@ModelAttribute("category")
	public Category getCategory()
	{
		return new Category();
	}
	
	

}
