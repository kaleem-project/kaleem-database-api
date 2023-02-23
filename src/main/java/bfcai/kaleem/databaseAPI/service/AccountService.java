package bfcai.kaleem.databaseAPI.service;

import bfcai.kaleem.databaseAPI.domain.Account;
import bfcai.kaleem.databaseAPI.repository.AccountRepository;
import bfcai.kaleem.databaseAPI.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;

@Component
public class AccountService {

	@Autowired
	private AccountRepository repository;


	public HashMap<String, Object> validateAccount(String username, String password) {
		HashMap<String, Object> result = new HashMap<>();
		Account userAccount = repository.findByUsernameAndPassword(username, password);
		if (userAccount == null) {
			result.put("code", 404);
			result.put("message", "Account not found");
			result.put("data", null);
		} else {
			result.put("code", 200);
			result.put("message", "Account found");
			result.put("data", userAccount);
		}
		return result;
	}


	public HashMap<String, Object> getAllAccounts() {
		HashMap<String, Object> result = new HashMap<>();
		ArrayList<Account> accounts = repository.findAllByUsernameNotNull();
		if (accounts.size() == 0) {
			result.put("code", 404);
			result.put("message", "No accounts found");
			result.put("data", null);
		} else {
			result.put("code", 200);
			result.put("message", "Accounts found");
			result.put("data", accounts);
		}
		return result;
	}


	public HashMap<String, Object> addNewAccount(Account account) throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		try (Account repoResponse = AccountUtils.fillingAccountData(repository.insert(account))) {
			result.put("code", 201);
			result.put("message", "Account created successfully");
			result.put("data", repoResponse);
		} catch (DuplicateKeyException ex) {
			result.put("code", 400);
			result.put("message", "Duplicated username or email");
			result.put("data", "");
		}
		return result;
	}

	public HashMap<String, Object> usernameAvailability(String username) {
		HashMap<String, Object> result = new HashMap<>();
		Account account = repository.findAccountByUsername(username);
		if (account == null) {
			result.put("code", 200);
			result.put("message", "Username is acceptable");
		} else {
			result.put("code", 400);
			result.put("message", "Username is already exist");
		}
		return result;
	}

	public HashMap<String, Object> updateAccount(Account newAccount){
		Account account = repository.save(newAccount);
		HashMap<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("message", "Account updated successfully");
		result.put("data", account);
		return result;
	}

	public HashMap<String, Object> deleteAccount(String id){
		Account account = repository.deleteAccountById(id);
		HashMap<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("message", "Account deleted successfully");
		result.put("data", account);
		return result;
	}



}
