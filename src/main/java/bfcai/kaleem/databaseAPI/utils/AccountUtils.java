package bfcai.kaleem.databaseAPI.utils;

import bfcai.kaleem.databaseAPI.domain.Account;
import java.time.LocalDateTime;

public class AccountUtils {


	public static Account fillingAccountData(Account account){
		LocalDateTime now = LocalDateTime.now();
		account.setActive(true);
		account.setCreationTime(now);
		return account;
	}



}
