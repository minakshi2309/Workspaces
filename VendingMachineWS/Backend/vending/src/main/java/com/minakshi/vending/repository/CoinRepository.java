package com.minakshi.vending.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minakshi.vending.model.Coin;

public interface CoinRepository extends JpaRepository<Coin, Long>{

}
