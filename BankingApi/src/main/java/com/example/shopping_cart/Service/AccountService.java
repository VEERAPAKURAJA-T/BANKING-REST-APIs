package com.example.shopping_cart.Service;

import java.util.List;

import com.example.shopping_cart.Dto.AccountsDto;


public interface AccountService {
	public AccountsDto createAccount(AccountsDto AccountsDto);
	public AccountsDto getAccountById(long id);
	public AccountsDto deposite(long id, Double m);
	public AccountsDto withdraw(long id,Double m);
	public List<AccountsDto> getAllAccount();
	public AccountsDto deleteById(long id);
}
