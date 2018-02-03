package com.vivek.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.vivek.app.entity.Account;

public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void withdraw(Account fromAccount, Account toAccount, Double amount) throws Exception {
		Account accountFromDb = getAccountFromDb(fromAccount.getAccountNumber());
		
		Double accountBalance = accountFromDb.getAccountBalance() - amount;
		if(accountFromDb.getAccountBalance() >= amount) {
			String SQL = "UPDATE account set account_balance=? WHERE account_number=?";
			int update = jdbcTemplate.update(SQL, accountBalance, fromAccount.getAccountNumber());
			
			if(update > 0) {
				System.out.println("Print Transaction successfull");
			} else {
				throw new Exception("Insufficent balance");
			}
			
		}
		
		
	}

	

	private Account getAccountFromDb(Long accountNumber) {
		return null;
		
		
	}



	@Override
	public void deposit(Account fromAccount, Account toAccount, Double amount) {
		// TODO Auto-generated method stub
		
	}
	
	

}
