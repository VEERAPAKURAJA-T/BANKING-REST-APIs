package com.example.shopping_cart.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping_cart.Dto.AccountsDto;
import com.example.shopping_cart.Service.AccountService;

@RestController
@RequestMapping("/bank/api/")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping  //create a bank account by (POST) REST API
	public ResponseEntity<AccountsDto> createAccount(@RequestBody AccountsDto accountsDto){
		return new ResponseEntity<>(accountService.createAccount(accountsDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}") //Get a bank account by (GET) REST API
	public ResponseEntity<AccountsDto> getAccount(@PathVariable long id){
		return ResponseEntity.ok(accountService.getAccountById(id));
	}
	
	@PutMapping("/{id}/deposit") //Deposit a amount to a particular account by (PUT) REST API
	public ResponseEntity<AccountsDto> deposit(@PathVariable long id,@RequestBody Map<String , Double> money ){
		Double m=money.get("amount");
		return ResponseEntity.ok(accountService.deposite(id,m));
	}
	
	@PutMapping("/{id}/withdraw") //Withdraw a amount from a particular account by (PUT) REST API
	public ResponseEntity<AccountsDto> withdraw(@PathVariable long id, @RequestBody Map < String,Double >money){
		Double m=money.get("amount");
		return ResponseEntity.ok(accountService.withdraw(id,m));
	}
	
	@GetMapping("/accounts") //Get all the bank accounts by (GET) REST API
	public ResponseEntity<List<AccountsDto>> getAll(){
		return ResponseEntity.ok(accountService.getAllAccount());
	}
	
	@DeleteMapping("/{id}/delete")//Delete a particular bank account by (DELETE) REST API
	public ResponseEntity<AccountsDto> deleteById(@PathVariable long id){
		return ResponseEntity.ok(accountService.deleteById(id));
	}
}
