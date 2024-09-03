package com.wipro.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.wipro.entity.Product;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepo;
	private List<Product> productList;
	
	@BeforeEach
	public void setUp() throws Exception{
		productList = new ArrayList<Product>();
	}
	
	@AfterEach
	public void tearDown() throws Exception{
		productList.clear();	
	}

	@Test
    public void findByAvailable1Test() {
		productList = productRepo.findByAvailable(true);
        assertNotNull(productList,"No available Products");
    }
	
	@Test
    public void findByAvailable2Test() {
		productList = productRepo.findByAvailable(false);
        assertNotNull(productList,"No available Products");
    }
	
	@Test
    public void findByCategory1Test() {
		productList = productRepo.findByCategory("Electronics");
        assertNotNull(productList,"No available Products");
    }
	
	@Test
    public void findByCategory2Test() {
		productList = productRepo.findByCategory("MOBILES");
        assertNotNull(productList,"No available Products");
    }
	
	@Test
    public void findByCategory3Test() {
		productList = productRepo.findByCategory("ABC");
        int size = productList.size();
        assertEquals(0, size);
    }

   
}