package com.management.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.management.domain.Sale;

public interface SalesRepository extends JpaRepository<Sale, Long>{
	
	
}