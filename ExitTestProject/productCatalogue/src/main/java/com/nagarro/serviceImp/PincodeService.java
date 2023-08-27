package com.nagarro.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.entity.ProductCode;
import com.nagarro.repository.PincodeRepo;
import com.nagarro.service.PincodeServiceInterface;

@Service
public class PincodeService implements PincodeServiceInterface {

	@Autowired
	private PincodeRepo repo;

	public ProductCode getPincode(Long pincode) {

		ProductCode pinObj = repo.findByPincode(pincode);
		return pinObj;
	}

}
