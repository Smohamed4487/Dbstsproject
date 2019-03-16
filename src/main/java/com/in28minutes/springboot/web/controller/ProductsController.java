package com.in28minutes.springboot.web.controller;

import com.in28minutes.springboot.web.model.Items;
import com.in28minutes.springboot.web.model.Products;
import com.in28minutes.springboot.web.model.repo.ItemRepository;
import com.in28minutes.springboot.web.model.repo.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductsController {

	@Autowired
	private ProductRepository repoProduct;
	
	@Autowired
	private ItemRepository repoItem;


	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String showProductsListPage(ModelMap model) {

		List<Products> products = repoProduct.findAll();
		model.put("products", products);
		return "products";
	}

	@RequestMapping(value = "/products/{id}/view", method = RequestMethod.GET)
	public String viewproductPage(ModelMap model, @PathVariable(value = "id") Long id) {

		Products product = repoProduct.findById(id);
		model.put("products", product);
		return "viewproduct";
	}

	@RequestMapping(value = "/products/{id}/delete", method = RequestMethod.POST)
	public String deleteProduct(ModelMap model, @PathVariable(value = "id") Long id) {
		String msg = "";

		Products product = repoProduct.findById(id);

		repoProduct.delete(product);

		msg = "Product is deleted "+product.getId();

		model.put("msg", msg);
		List<Products> products = repoProduct.findAll();
		model.put("products", products);
		return "products";
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String saveProduct(ModelMap model) {
		
		List<Items> items = repoItem.findAll();
		model.put("items",items);
		return "addproduct";

	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String saveNewProduct(ModelMap model, @ModelAttribute("products") Products product) {
		
		product = repoProduct.save(product);
		String msg = "";
		msg = "New product is added "+product.getId();
		List<Products> products = repoProduct.findAll();
		model.put("msg", msg);
		model.put("products", products);
		return "products";
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public String showEditproductsPage(ModelMap model, @PathVariable(value = "id") long id) {
		Products products = repoProduct.findById(id);
		model.put("products", products);
		return "editproduct";
	}

	@RequestMapping(value = "/product/{id}/", method = RequestMethod.POST)
	public String updateProductPage(ModelMap model, @ModelAttribute("product") Products product,
			@PathVariable(value = "id") long id) {
		
		product.setId(id);
		product = repoProduct.save(product);

		String msg = "Product is Updated with id as "+id;
		List<Products> products = repoProduct.findAll();
		model.put("msg", msg);
		model.put("products", products);

		return "products";
	}

}