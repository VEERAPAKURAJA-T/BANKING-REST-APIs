package com.example.shopping_cart.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping_cart.Dto.AccountsDto;
import com.example.shopping_cart.Entities.Accounts;
import com.example.shopping_cart.Mapper.ObjectMapper;
import com.example.shopping_cart.Repository.AccountsRepo;
import com.example.shopping_cart.Service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountsRepo accountsRepo;
	@Override
	public AccountsDto createAccount(AccountsDto AccountsDto) {
		Accounts account =ObjectMapper.mappingToAccounts(AccountsDto);
		accountsRepo.save(account);	
		return ObjectMapper.mappingToAccountDto(account);
	}
	@Override
	public AccountsDto getAccountById(long id) {
		Accounts accounts=accountsRepo.findById(id).orElse(null);
		
		return ObjectMapper.mappingToAccountDto(accounts);
	}
	@Override
	public AccountsDto deposite(long id, Double m) {
		Accounts accounts=accountsRepo.findById(id).orElse(null);
		Double money=accounts.getBalance()+m;
		accounts.setBalance(money);
		accountsRepo.save(accounts);
		return ObjectMapper.mappingToAccountDto(accounts);
	}
	@Override
	public AccountsDto withdraw(long id, Double m) {
		Accounts accounts=accountsRepo.findById(id).orElse(null);
		if(m>accounts.getBalance()) {
			throw new RuntimeException("Insufficient Bank balance");
		}
		Double money=accounts.getBalance()-m;
		accounts.setBalance(money);
		accountsRepo.save(accounts);
		return ObjectMapper.mappingToAccountDto(accounts);
	}
	@Override
	public List<AccountsDto> getAllAccount() {
		List<Accounts> accounts=accountsRepo.findAll();
		
		return accounts.stream().map(account -> ObjectMapper.mappingToAccountDto(account)).collect(Collectors.toList());
	}
	@Override
	public AccountsDto deleteById(long id) {
		Accounts accounts=accountsRepo.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
		AccountsDto accountsDto=ObjectMapper.mappingToAccountDto(accounts);
		accountsRepo.delete(accounts);
		return accountsDto;
	}

}
