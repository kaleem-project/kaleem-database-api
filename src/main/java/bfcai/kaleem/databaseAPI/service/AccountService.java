package bfcai.kaleem.databaseAPI.service;
import bfcai.kaleem.databaseAPI.domain.Account;
import bfcai.kaleem.databaseAPI.repository.AccountRepository;
import bfcai.kaleem.databaseAPI.utils.AccountUtils;
import bfcai.kaleem.databaseAPI.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;

@Component
public class AccountService {

	@Autowired
	private AccountRepository repository;

	public Response validateAccount(String username, String password) {
		var result = new Response();
		Account userAccount = repository.findByUsernameAndPassword(username, password);
		if (userAccount == null) {result.make("Account not found", 404, null);}
		else {result.make("Account found", 200, userAccount);}
		return result;
	}

	public Response getAllAccounts() {
		var result = new Response();
		ArrayList<Account> accounts = repository.findAllByUsernameNotNull();
		if (accounts.size() == 0) {
			result.make("No accounts found", 404, null);
		} else {
			result.make("Accounts found", 200, accounts);
		}
		return result;
	}

	public Response insertNewAccount(Account account) throws Exception {
		var result = new Response();
		try (Account repoResponse = AccountUtils.fillingAccountData(repository.insert(account))) {
			result.make("Account created successfully", 201, repoResponse);
		}
		catch (DuplicateKeyException ex) {
			result.make("Duplicated username or email", 400, null);
		}
		return result;
	}

	public Response checkUsernameAvailability(String username) {
		var result = new Response();
		Account account = repository.findAccountByUsername(username);
		if (account == null) {result.make("Username is acceptable", 200, null);}
		else {result.make("Username is already exist", 400, null);}
		return result;
	}

	public Response updateAccount(Account newAccount){
		var result = new Response();
		Account account = repository.save(newAccount);
		result.make("Account updated successfully", 200, account);
		return result;
	}

	public Response deleteAccount(String id){
		var result = new Response();
		Account account = repository.deleteAccountById(id);
		result.make("Account deleted successfully", 200, account);
		return result;
	}

}
