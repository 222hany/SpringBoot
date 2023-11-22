package com.kh.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.springdb.model.Product;
import com.kh.springdb.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("productLists")
    public String displayProductList(Model model) {
    	//model.addAttribute("products","제품 저장할 공간");
    	model.addAttribute("products",productService.getAllProducts());
        return "productLists";
    }
    
    
}