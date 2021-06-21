package com.minakshi.vending.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coin {
	
	public static final int [] VALID_COINS = {200,100,50,20,10,5};
	
	@Id
	@GeneratedValue
	private Long id;
	 
	private int value;
	private int quantityOfCoins;
		
	public Coin() {
	}

	public Coin(int value, int quantityOfCoins) {
		this.value = value;
		this.quantityOfCoins = quantityOfCoins;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getQuantityOfCoins() {
		return quantityOfCoins;
	}
	public void setQuantityOfCoins(int quantityOfCoins) {
		this.quantityOfCoins = quantityOfCoins;
	}

}
