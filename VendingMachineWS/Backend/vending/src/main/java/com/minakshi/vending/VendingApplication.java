package com.minakshi.vending;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.minakshi.vending.model.Coin;
import com.minakshi.vending.model.Product;
import com.minakshi.vending.repository.CoinRepository;
import com.minakshi.vending.repository.ProductRepository;

@SpringBootApplication
public class VendingApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner tableIntialization(ProductRepository productRepository,CoinRepository coinRepository) {
		return (args) ->{
							productRepository.save(new Product("Coca Cola", 120,10));
							productRepository.save(new Product("Lays", 300, 15));
							productRepository.save(new Product("Snickers", 300, 25));
							coinRepository.save(new Coin(50, 6));
							coinRepository.save(new Coin(10, 2));
							coinRepository.save(new Coin(20, 4));
							coinRepository.save(new Coin(100, 10));
							coinRepository.save(new Coin(200, 10));
						};
	}

}
