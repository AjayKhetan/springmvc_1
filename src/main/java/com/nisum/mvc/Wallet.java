package com.nisum.mvc;
import org.springframework.stereotype.Component;

@Component
public class Wallet {

	private int balance;
	private String type;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Wallet(int balance, String type) {
		this.balance = balance;
		this.type = type;
	}

	public Wallet() {
		// TODO Auto-generated constructor stub
	}

}
