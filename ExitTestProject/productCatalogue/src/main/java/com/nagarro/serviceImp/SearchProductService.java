package com.nagarro.serviceImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.entity.Product;
import com.nagarro.repository.SearchProductRepo;
import com.nagarro.service.SearchProductServiceInterface;

@Service
public class SearchProductService implements SearchProductServiceInterface {

	@Autowired
	private SearchProductRepo repo;

	public List<Product> getProductListBySearch(String search) {
		return repo.findBySearch(search);
	}
	
	
	public List<Product> searchPrice(int min, int max, String brand) {
		// TODO Auto-generated method stub
		return repo.searchPrice(min, max,brand);
	}

}
