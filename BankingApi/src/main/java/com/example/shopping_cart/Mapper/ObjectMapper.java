package com.example.shopping_cart.Mapper;

import com.example.shopping_cart.Dto.AccountsDto;
import com.example.shopping_cart.Entities.Accounts;

public class ObjectMapper {
	public static Accounts mappingToAccounts(AccountsDto accountsDto) {
		Accounts accounts=new Accounts(accountsDto.getId(),accountsDto.getAccountHolderName(),accountsDto.getBalance());
		return accounts;
	}
	
	public static AccountsDto mappingToAccountDto(Accounts accounts) {
		AccountsDto accountsDto=new AccountsDto(accounts.getId(),accounts.getAccountHolderName(),accounts.getBalance());
		return accountsDto;
	}
}
