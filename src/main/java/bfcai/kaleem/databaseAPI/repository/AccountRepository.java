package bfcai.kaleem.databaseAPI.repository;

import bfcai.kaleem.databaseAPI.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

}
