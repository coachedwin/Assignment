package com.nagarro.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.entity.Product;
import com.nagarro.repository.ProductRepo;
import com.nagarro.service.ProductServiceInterface;


@Service
public class ProductService implements ProductServiceInterface {
	@Autowired
	private ProductRepo repo;

	
	public Product saveProduct(Product product) {
		Product productObj = repo.save(product);
		return productObj;
	}

	
	public Product getProduct(String productCode) {

		Product productObj = repo.findByProductCode(productCode);
		return productObj;
	}

	
	public void updateProductReview(Product product) {
		repo.save(product);
	}

	
	public Long countAllProduct() {
		return repo.count();
	}

	

	public List<Product> getProducts() {
		
		return repo.findAll();
	}

}