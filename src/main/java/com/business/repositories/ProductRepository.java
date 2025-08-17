package com.business.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.business.entities.Product;

public interface ProductRepository extends CrudRepository<Product,Integer>
{
	public Product findByPname(String name);
	List<Product> findByPnameContainingIgnoreCase(String keyword);

}
