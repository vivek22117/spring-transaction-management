package com.vivek.app.dao;

import com.vivek.app.entity.Account;

public interface AccountDao {

	public abstract void withdraw(Account fromAccount, Account toAccount, Double amount) throws Exception;
	public abstract void deposit(Account fromAccount, Account toAccount, Double amount);
}
