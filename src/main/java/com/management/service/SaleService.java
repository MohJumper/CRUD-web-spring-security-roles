package com.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.domain.Sale;
import com.management.repository.SalesRepository;

@Service
public class SaleService {
	
	@Autowired
	private SalesRepository salesRepo;
	
//	@Autowired
//	private static SalesRepository salesRepoStat;
	
	public List<Sale> listSale() {
			    
	    return salesRepo.findAll();
	}
	
	
	
    public Sale findSaleById(Long id) {
        Optional<Sale> saleOpt = salesRepo.findById(id);
        if(saleOpt.isPresent()) {
        	return saleOpt.get();
        } else {
        	throw new RuntimeException(" sale not found for id: " + id);
        }
     
    }
  
    public Sale updateSale(Sale sale) {
    	Optional<Sale> saleOpt = salesRepo.findById(sale.getId());
    	if (saleOpt.isPresent()) {
    		Sale newSale = saleOpt.get();
    		newSale.setId(sale.getId());
    		newSale.setAmount(sale.getAmount());
    		newSale.setItem(sale.getItem());
    		newSale.setQuantity(sale.getQuantity());
    		
    		newSale = salesRepo.save(newSale);
    		return newSale;
    	}
    	else {
    		sale = salesRepo.save(sale);
    		return sale;
    	}
    	
    	
    }
  
    
    public void deleteSale(Long id) {
    	salesRepo.deleteById(id);
    }

	public void saveSale(Sale sale) {
		salesRepo.save(sale);
		
	}
}