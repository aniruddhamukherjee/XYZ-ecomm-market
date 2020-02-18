package com.aniruddha.XYZecommmarket;

import com.aniruddha.XYZecommmarket.beans.Product;
import com.aniruddha.XYZecommmarket.business.ProductBusiness;
import com.aniruddha.XYZecommmarket.dao.ProductRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class XyzEcommMarketApplicationUnitTests {

	//for checking products catalogue in DB
	@Autowired
	ProductRepository productRepository;

	//for mocking dao
	@Mock
	ProductRepository dataServiceMock;

	@InjectMocks
	ProductBusiness productBusiness;

	protected List<Product> prodList ;

	@Before
	public void setupTestData() {
		prodList = new ArrayList<Product>();
		Product prod1 = new Product();
		prod1.setId(1);
		prod1.setName("Avengers T-shirt");
		prod1.setBrand("brand1");
		prod1.setType("shirt");
		prod1.setPrice(200.50);
		prod1.setColor("blue");
		prod1.setSize(42);
		prod1.setAvailableCount(500);
		prod1.setSupplier("Marvel");

		Product prod2 = new Product();
		prod2.setId(2);
		prod2.setName("Justice League T-shirt");
		prod2.setBrand("brand2");
		prod2.setType("shirt2");
		prod2.setPrice(240.50);
		prod2.setColor("white");
		prod2.setSize(40);
		prod2.setAvailableCount(900);
		prod2.setSupplier("DC");

		prodList.add(prod1);
		prodList.add(prod2);
	}

	/**
	 * DB data test
	 */
	@Test
	public void testProductsListNotEmpty() {
		List<Product> l = productRepository.getAllProducts(1);
		Assert.assertTrue(l.size() > 0);
	}


	/**
	 * business layer test with mock DB data
	 */
	@Test
	public void testGetAllProductsMock(){
		when(dataServiceMock.getAllProducts(1)).thenReturn(prodList);
		assertEquals(2, productBusiness.getAllProducts(1).size());
	}

	/**
	 * business layer test with mock DB data
	 */
    @Test
	public void testGetProductsByBrand(){
		List<Product> prodListForBrand = new ArrayList<Product>();
		Product prod1 = new Product();
		prod1.setId(3);
		prod1.setName("Black Cap");
		prod1.setBrand("Nike");
		prod1.setType("cap");
		prod1.setPrice(500.0);
		prod1.setColor("black");
		prod1.setSize(16);
		prod1.setAvailableCount(600);
		prod1.setSupplier("AbcRetail");
		prodListForBrand.add(prod1);
		when(dataServiceMock.getProductsByBrand(anyString(), anyInt())).thenReturn(prodListForBrand);
		assertTrue(!CollectionUtils.isEmpty(productBusiness.getProductsByBrand("Nike",1)));
		assertTrue(productBusiness.getProductsByBrand("Nike", 1).size()==1);
		assertEquals("Black Cap",productBusiness.getProductsByBrand("Nike", 1).get(0).getName());
	}

	/**
	 * business layer test with mock DB data
	 */
	@Test
	public void testGetProductBySku(){
		Product prod1 = new Product();
		prod1.setId(4);
		prod1.setName("Nike shoe");
		prod1.setBrand("Nike");
		prod1.setType("shoe");
		prod1.setPrice(655.0);
		prod1.setColor("black");
		prod1.setSize(16);
		prod1.setAvailableCount(600);
		prod1.setSupplier("ABB retail");
		when(dataServiceMock.getProductBySKU(4)).thenReturn(prod1);
		assertEquals("Nike shoe", productBusiness.getProductBySKU(4).getName());
		assertEquals("Nike", productBusiness.getProductBySKU(4).getBrand());
		assertEquals("shoe", productBusiness.getProductBySKU(4).getType());
		assertEquals("655.0", String.valueOf(productBusiness.getProductBySKU(4).getPrice()));
	}

	@Ignore
	@Test
	public void testGetProductsByTypeAndColor(){
		//TODO similar logic as above
	}

	//TODO other business layer methods tests

}
