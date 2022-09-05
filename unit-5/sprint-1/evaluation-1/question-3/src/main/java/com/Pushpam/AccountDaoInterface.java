package com.Pushpam;

public interface AccountDaoInterface {

	Account findById(int id);
	String save(Account account);
	String update(Account account);
	String remove(int id);
	String withdraw(double amount,int accountId);
	String deposit(double amount,int accountId);
	
	
}
