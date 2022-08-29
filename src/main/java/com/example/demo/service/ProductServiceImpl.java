package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.IProductRepo;
import com.example.demo.util.IService;

@Service
public class ProductServiceImpl implements IService<Product> {
	
	@Autowired
	private IProductRepo productRepository;

	@Override
	public Product saveRecord(Product record) {
		return productRepository.save(record);
	}

	@Override
	public List<Product> fetchAllRecords() {
		return productRepository.findAll();
	}

	@Override
	public Product updateRecord(Product record, long id) {
		Product productoDB = findById(id);
		if (!Objects.isNull(productoDB)) {
			productRepository.deleteById(id);
			return productoDB;
		}
			
		 throw new NullPointerException();
	}

	@Override
	public Product findById(long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public String deleteRecord(long id) {
		Product productoDB = findById(id);
		if (!Objects.isNull(productoDB)) {
			productRepository.deleteById(id);
			return productoDB.toString();
		}
			
		return "No existe";
	}

}
