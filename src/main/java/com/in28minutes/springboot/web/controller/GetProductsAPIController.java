package com.in28minutes.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.web.model.Products;
import com.in28minutes.springboot.web.model.repo.ProductRepository;

@RestController
public class GetProductsAPIController {

	@Autowired
	private ProductRepository repoProduct;

	@RequestMapping(value = "/api/v1/products", method = RequestMethod.GET, produces = "application/json")
	public List<Products> showProductsListPage() {

		List<Products> products = repoProduct.findAll();

		return products;
	}
}
