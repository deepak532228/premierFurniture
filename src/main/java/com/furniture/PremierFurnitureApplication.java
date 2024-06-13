package com.furniture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.furniture.Repository.CartRepository;
import com.furniture.Repository.OrderRepository;
import com.furniture.Repository.ProductCategoryRepository;
import com.furniture.Repository.ProductRepository;
import com.furniture.Repository.UserRepository;
import com.furniture.service.OrderService;
@EnableJpaRepositories(basePackages="com.furniture.Repository")
@EntityScan(basePackages="com.furniture.Entity")
@SpringBootApplication 
public class PremierFurnitureApplication implements CommandLineRunner{
 
	
	@Autowired
	ProductCategoryRepository crepo;
	
	@Autowired
	OrderRepository orepo;
	
	@Autowired
	ProductRepository prepo;
	
	@Autowired
	UserRepository urepo;
	
	@Autowired
	CartRepository cerepo;
	
	@Autowired
	OrderService ords;
 
	
	public static void main(String[] args) {
		SpringApplication.run(PremierFurnitureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
				
//USER
				//urepo.save(new User("Deepak1234@gmail","deepak@#123","Admin","Deepak","Kumar",
			    //   "Patna","India","845678",0));
			
		
//PRODUCT CATEGORY
			    //crepo.save(new ProductCategory("Chair"));
				
		
//PRODUCT		
				//ProductCategory pro = crepo.findById(1L).get();
				//prepo.save(new Product("chair","plastic chair",new BigDecimal("100"),true,1000,pro));
				
				
//ORDER		
				//ords.placeOrder(new Order("FR788","Processed",u));
		
	}
  
}
