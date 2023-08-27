package com.nagarro.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.entity.Product;
import com.nagarro.entity.Reviews;
import com.nagarro.repository.ReviewRepo;
import com.nagarro.service.ReviewServiceInterface;


@Service
public class ReviewService implements ReviewServiceInterface {

	@Autowired
	private ReviewRepo repo;

	
	public List<Reviews> getAllReview(Product product) {
		return repo.findByProduct(product);
	}

	

	public Long countAllReview() {
		return repo.count();
	}

	
	public Double getAverage(Product product) {
		return repo.getAverage(product);
	}



	public Product getProductCodeFromEmailId(String email) {
		return repo.getProductCodeFromEmailId(email);
	}



	public void deleteReview(int id) {
		repo.deleteById(id);
		return;
	}
}
