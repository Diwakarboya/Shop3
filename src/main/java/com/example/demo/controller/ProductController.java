package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Product;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/add")
	public String postprod(@ModelAttribute("prod") Product prod) {
		
		service.addprod(prod);
		return "redirect:/home";
	}
	
	
	@GetMapping("/home")
	public String getprod(Model model) {		
		model.addAttribute("listofproducts",service.showprod());
		return "index";		
	}
	
	@GetMapping("/prodform")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Product prod = new Product();
		model.addAttribute("prod",prod);
		return "addprod";
		
	}
	@GetMapping("/update/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
//		Employee employee = employeeService.getEmployeeById(id);
		Product prod = service.getbyid(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("prod",prod);
		return "updateprod";
	}

}
