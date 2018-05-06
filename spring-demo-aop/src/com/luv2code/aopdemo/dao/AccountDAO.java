package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean bln) {
		System.out.println(getClass() + "- doing my db work ");
	}

	public boolean doWork() {
		System.out.println(getClass() + "- doing some work ");
		return false;
	}

	public List<Account> findAccount() {
		List<Account> listAccount = new ArrayList<Account>();

		// create sample accounts
		Account acc1 = new Account("Jhon", "Silver");
		Account acc2 = new Account("Madhu", "Platinum");
		Account acc3 = new Account("Luca", "Gold");
		// add them to our accounts lists

		listAccount.add(acc1);
		listAccount.add(acc2);
		listAccount.add(acc3);

		return listAccount;
	}

	public List<Account> findAccountWithException() throws Exception {
		throw new Exception("no soup for you!!!");
	}
}
