package com.devsuperior.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.tests.Factory;

@DataJpaTest
public class ProductRepositoryTests {
	
	@Autowired
	private ProductRepository repository;
	
	private long exintingId;
	private long nonExitId;
	private long countTotalProducts;
	
	@BeforeEach
	void setUp() throws Exception{
		exintingId =  1L;
		nonExitId = 1000L;
		countTotalProducts = 25L;
	}
	
	@Test
	public void saveShouldPersistWithAutoicrementWhenIdIsNull() {
		
		Product product = Factory.createProduct();
		product.setId(null);
		
		product = repository.save(product);
		
		Assertions.assertNotNull(product.getId());
		Assertions.assertEquals(countTotalProducts + 1, product.getId());
	}
	
	//deletar o objeto quando id existe.  
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		
		repository.deleteById(exintingId);
		Optional<Product> result = repository.findById(exintingId);
		
		Assertions.assertFalse(result.isPresent());		
	}
	
	@Test
	public void deleteShouldThrowShouldEmptyResultDataAccessExceptionWhenIdDoesNotExit() {
		
		Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
			repository.deleteById(nonExitId);			
		});
	}
	
	@Test
	public void idVerificarSeExit() {
		
		Optional<Product> result = repository.findById(exintingId);
		
		Assertions.assertTrue(result.isPresent());
	}
	
	@Test
	public void idVerificarSeNaoExit() {
		
		Optional<Product> result = repository.findById(nonExitId);
		
		Assertions.assertTrue(result.isEmpty());
	}
	
}
