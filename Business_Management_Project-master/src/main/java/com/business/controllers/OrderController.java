package com.business.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.business.entities.Product;
import com.business.services.ProductServices;

@Controller
public class OrderController
{
		@Autowired
		ProductServices ps;
		
		@GetMapping("/product/search")
		public String getallp(Model model){
			List<Product> allProducts = this.ps.getAllProducts();
			model.addAttribute("products", allProducts);
			return "BuyProduct";
		}
		

}
