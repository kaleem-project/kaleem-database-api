package bfcai.kaleem.databaseAPI.controller;

import bfcai.kaleem.databaseAPI.domain.Account;
import bfcai.kaleem.databaseAPI.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v3/database")
public class AccountController {

	@Autowired
	private AccountService service;


	@PostMapping("/accounts/signin")
	public ResponseEntity<?> signinUser(@RequestBody Account account){
		HashMap<String, Object> searchResult = service.validateAccount(account.getUsername(), account.getPassword());
		return ResponseEntity.status((int)searchResult.get("code")).body(searchResult);
	}

	@PostMapping("/accounts/signup")
	public ResponseEntity<?> signupUser(@RequestBody Account account) throws Exception {
		HashMap<String, Object> response = service.addNewAccount(account);
		return ResponseEntity.status((int)response.get("code")).body(response);
	}

	@GetMapping("/accounts")
	public ResponseEntity<?> getAllAccounts(){
		HashMap<String, Object> response = service.getAllAccounts();
		return ResponseEntity.status((int)response.get("code")).body(response);
	}


	@GetMapping("/accounts/{username}")
	public ResponseEntity<?> isUsernameAvailable(@PathVariable String username){
		var res = service.usernameAvailability(username);
		return ResponseEntity.status((int) res.get("code")).body(res);
	}

	@PutMapping("/accounts")
	public ResponseEntity<?> updateAccount(@RequestBody Account account) throws Exception {
		var response = service.updateAccount(account);
		return ResponseEntity.status((int) response.get("code")).body(response);
	}

	@DeleteMapping("accounts/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable String id){
		var response = service.deleteAccount(id);
		return ResponseEntity.status((int)response.get("code")).body(response);
	}
}
