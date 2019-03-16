package com.in28minutes.springboot.web.model.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.in28minutes.springboot.web.model.Items;

@Repository
public interface ItemRepository extends CrudRepository<Items, Long > {
	List<Items> findAll();
	Items findByItemid(Long itemid);
	void delete(Items item);
}
