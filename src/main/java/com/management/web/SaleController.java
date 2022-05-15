package com.management.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.management.domain.Sale;
import com.management.service.SaleService;

@Controller
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	
	@GetMapping("/")
	public String homePageView(ModelMap model) {
		List<Sale> listSale = saleService.listSale();
		model.put("listSale", listSale);
		return "index";
	}
	
	@GetMapping("/new")
	public String enterNewItem(ModelMap model) {
		Sale sale = new Sale();
		model.put("sale", sale);
		return "newForm";
	}
	
	@PostMapping("/save")
	public String saveNewItem(Sale sale) {
		saleService.saveSale(sale);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editFormView(ModelMap model, @PathVariable Long id) {
		Sale sale = saleService.findSaleById(id);
		model.put("sale", sale);
		return "editForm";
	}
	
//	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	@PostMapping("/edit/{id}")
	public String saveEdit(Sale sale) {
//		Sale sale = saleService.findSaleById(id);
		
		saleService.updateSale(sale);
		
		return "redirect:/";
	}
	

	@GetMapping("/delete/{id}")
	public String deleteSale(@PathVariable Long id) {
		this.saleService.deleteSale(id);
		return "redirect:/";
	}
	
	@GetMapping("/403")
	public String error403() {
		return "403";
	}
	
}