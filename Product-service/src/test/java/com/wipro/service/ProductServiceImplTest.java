package com.wipro.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.dto.ProductDto;
import com.wipro.entity.Product;
import com.wipro.repository.ProductRepository;


public class ProductServiceImplTest {
	
	@Mock
	ProductRepository productRepo;

	@InjectMocks
	private ProductServiceImpl productServiceImpl;
	
	@Mock
	private ModelMapper mapper;
	
	Product product;
	ProductDto productDto;
	List<Product> productList ;
	List<ProductDto> productDtoList ;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		productList = new ArrayList<Product>();
		productDtoList = new ArrayList<ProductDto>();
		product = new Product(111, "A", "A Description",25, 100, "Category", false);
		productDto = new ProductDto();
		productDto = mapper.map(productDto,ProductDto.class);
		productList.add(product);
		productDtoList.add(productDto);
	}

	@Test
	public void getAllProductsTest() {
		when(productRepo.findAll()).thenReturn(productList);
		List<ProductDto> list = productServiceImpl.getAllProducts();
		assertEquals(list, productDtoList);
	}


}
