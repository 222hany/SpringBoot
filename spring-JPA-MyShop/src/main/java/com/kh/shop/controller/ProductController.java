package com.kh.shop.controller;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.shop.service.ProductService;
import com.kh.shop.vo.Product;

import org.springframework.stereotype.Service;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product_list";
    }

    @GetMapping("/details/{id}")
    public String getProductDetails(@PathVariable Long id, Model model) {
        Optional<Product> product = productService.getProductById(id);
        product.ifPresent(value -> model.addAttribute("product", value));
        return "product_detail";
    }

    @GetMapping("/new")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, Model model) {
    	Optional<Product> product = productService.getProductById(id);
    	product.ifPresent(value -> model.addAttribute("product", value));
    	return "product_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }
}