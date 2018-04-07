package com.leonsaber.challenge;

import com.leonsaber.challenge.model.entity.Product;
import com.leonsaber.challenge.model.service.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	@Test
	public void test() throws Exception {
		List<Product> productList= productRepository.findAllByOrderByProductIDAsc();
		for(Product product : productList) {
			System.out.println(product.getProductName());
		}
	}

}
