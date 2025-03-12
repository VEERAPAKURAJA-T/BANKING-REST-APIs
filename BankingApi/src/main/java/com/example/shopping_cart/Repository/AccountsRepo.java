package com.example.shopping_cart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopping_cart.Entities.Accounts;

public interface AccountsRepo extends JpaRepository<Accounts,Long> {
	
}
