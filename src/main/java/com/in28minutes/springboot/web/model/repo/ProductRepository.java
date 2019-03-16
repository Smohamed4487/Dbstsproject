package com.in28minutes.springboot.web.model.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.in28minutes.springboot.web.model.Products;


@Repository
public interface ProductRepository extends CrudRepository<Products, Long> {
	List<Products> findAll();
	Products findById(Long id);
	Products deleteById(Long id);
	List<Products> findByItemid(Long itemid);
}
