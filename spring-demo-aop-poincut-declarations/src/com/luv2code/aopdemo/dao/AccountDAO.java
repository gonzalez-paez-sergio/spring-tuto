package com.luv2code.aopdemo.dao;

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
}
