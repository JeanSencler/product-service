package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductServiceImpl;
import com.example.demo.util.IController;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/v2/products")
public class ProductController implements IController<Product>{
	
	@Autowired
	private ProductServiceImpl productService;

	@Override
	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.ok(productService.fetchAllRecords());
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable long id) {
		return ResponseEntity.ok(productService.findById(id));
	}

	@Override
	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product customer) {
		return ResponseEntity.ok(productService.saveRecord(customer));
	}

	@Override
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> update(@RequestBody Product customer, @PathVariable long id) {
		return ResponseEntity.ok(productService.updateRecord(customer, id));
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletetById(long id) {
		return ResponseEntity.ok(productService.deleteRecord(id));
	}

}
