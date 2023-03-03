package bfcai.kaleem.databaseAPI.controller;

import bfcai.kaleem.databaseAPI.domain.Account;
import bfcai.kaleem.databaseAPI.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v3/database")
public class AccountController {

	@Autowired
	private AccountService service;

	@PostMapping("/accounts/validate")
	public ResponseEntity<?> signin(@RequestBody Account account){
		var response = service.validateAccount(account.getUsername(), account.getPassword());
		return ResponseEntity.status(response.getCode()).body(response.toData());
	}

	@PostMapping("/accounts")
	public ResponseEntity<?> signup(@RequestBody Account account) throws Exception {
		var response = service.insertNewAccount(account);
		return ResponseEntity.status(response.getCode()).body(response);
	}

	@GetMapping("/accounts")
	public ResponseEntity<?> getAllAccounts(){
		var response = service.getAllAccounts();
		return ResponseEntity.status(response.getCode()).body(response.toData());
	}

	@GetMapping("/accounts/{username}")
	public ResponseEntity<?> isUsernameAvailable(@PathVariable String username){
		var response = service.checkUsernameAvailability(username);
		return ResponseEntity.status(response.getCode()).body(response.toData());
	}

	@PutMapping("/accounts")
	public ResponseEntity<?> updateAccount(@RequestBody Account account) throws Exception {
		var response = service.updateAccount(account);
		return ResponseEntity.status(response.getCode()).body(response.toData());
	}

	@DeleteMapping("accounts/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable String id){
		var response = service.deleteAccount(id);
		return ResponseEntity.status(response.getCode()).body(response.toData());
	}
}
