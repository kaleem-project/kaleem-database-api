package bfcai.kaleem.databaseAPI.repository;

import bfcai.kaleem.databaseAPI.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.ArrayList;

public interface AccountRepository extends MongoRepository<Account, String> {

	Account findAccountByUsername(String username);
	Account deleteAccountById(String id);
	ArrayList<Account> findAllByUsernameNotNull();
	Account findByUsernameAndPassword(String username, String password);
}
