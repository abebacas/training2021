package org.ssglobal.training.codes;

public class CurrentAccount {

	public int account[];
	private int lastMove;
	
	public CurrentAccount() {
		lastMove = 0;
		account = new int[10];
	}
	
	public void deposit(int value) {
		account[lastMove] = value;
		lastMove++;
	}
	
	public void withdraw(int value) {
		account[lastMove] = value;
		lastMove++;
	}
	
	public int settlement() {
		int result = 0;
		for (int i=0; i<account.length; i++) {
			result = result + account[i];
		}
		return result;
	}
	
	public static void main(String args[]) {
		CurrentAccount c = new CurrentAccount();
		c.deposit(10); // given do not change!
	}
	
	

}
