package com.nagarro.service;

import com.nagarro.entity.Product;
import java.util.*;


public interface ProductServiceInterface {

	public Product saveProduct(Product product);

	public Product getProduct(String productCode);

	public void updateProductReview(Product product);

	public Long countAllProduct();
	
	public List<Product> getProducts();

}
