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
public class itemsController {

	@Autowired
	private ItemRepository repoItem;
	
	@Autowired
	private ProductRepository repoProduct;
	
	
	// displaying all the items
	@RequestMapping(value = "//item/all", method = RequestMethod.GET)
	public String showitemsListPage(ModelMap model) {
		
		List<Items> items = repoItem.findAll();
		List<Products> product;

        for (Items item : items) {
        	Long x = ((Items) item).getItemid();
        	product = repoProduct.findByItemid(x);
			int temp = 0;
			temp = product.size();
			((Items) item).setNoofproducts(temp);	
			item = repoItem.save(item);
        }
        

        model.put("i", items);
		return "items";
		
	}
	//display a particular product
	@RequestMapping(value = "/items/{itemid}/view", method = RequestMethod.GET)
	public String viewproductPage(ModelMap model, @PathVariable(value = "itemid") Long itemid) {

		Items items = repoItem.findByItemid(itemid);
		model.put("i", items);
		return "viewitem";
	}

	
	//get method to open the add item page
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public String addnewitem(ModelMap model) {
		return "additem";
	}
	
	//post method to add a new item in DB
	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public String saveNewProduct(ModelMap model, @ModelAttribute("items") Items items) {
		
		items.setNoofproducts(0);
		items = repoItem.save(items);
		String msg = "";
		msg = "Item is added "+items.getItemid();
		List<Items> item = repoItem.findAll();
		model.put("msg", msg);
		model.put("i", item);
		return "items";
	}
	
	
	//delete method to delete the item from DB
	@RequestMapping(value = "/items/{itemid}/delete", method = RequestMethod.POST)
	public String deleteitem(ModelMap model, @PathVariable(value = "itemid") Long itemid) {
		String msg = "";

		Items item = repoItem.findByItemid(itemid);

		repoItem.delete(item);

		msg = "Item is deleted "+item.getItemid();

		model.put("msg", msg);
		List<Items> items = repoItem.findAll();
		model.put("i", items);
		return "items";
	}

	//get method to open edit item page 
	@RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
	public String showEdititemssPage(ModelMap model, @PathVariable(value = "itemid") long itemid) {
		Items item = repoItem.findByItemid(itemid);
		model.put("i", item);
		return "edititem";
	}
	
	//post method to save the updated details of the product
	@RequestMapping(value = "/items/{itemid}", method = RequestMethod.POST)
	public String updateitemsdetailsPage(ModelMap model, @ModelAttribute("item") Items item,
			@PathVariable(value = "itemid") long itemid) {
		
		item.setItemid(itemid);
		item = repoItem.save(item);
		String msg = "Item is Updated with id "+itemid;
		List<Items> items = repoItem.findAll();
		model.put("msg", msg);
		model.put("i", items);

		return "items";
	}

}