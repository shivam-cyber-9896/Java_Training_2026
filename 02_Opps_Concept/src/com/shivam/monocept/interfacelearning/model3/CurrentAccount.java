package com.shivam.monocept.interfacelearning.model3;

public class CurrentAccount implements AccountOperation {

	private static long counter = 9898L;

    private final  long AccountNumber;
    private String accountName;
    private double balance;
    private double overdraftLimit;
public CurrentAccount(String name,String balance,String overdraftLimit){
	counter++;
	 this.AccountNumber=counter;
	 this.accountName=name;
	 this.balance=Double.parseDouble(balance);
	 this.overdraftLimit=Double.parseDouble(overdraftLimit);
}
	@Override
	public void deposit(String Balance) {
		// TODO Auto-generated method stub
		this.balance+=Double.parseDouble(Balance);
		
	}

	@Override
	public void withDrow(String Amount) {
		// TODO Auto-generated method stub
		double totalBalance=balance+overdraftLimit; 
		if(totalBalance<=Double.parseDouble(Amount)) {
			balance-=Double.parseDouble(Amount);
			if(balance<0) {
			overdraftLimit-=balance;
			balance=0;
			}
			checkBalance();
			return;
		}
		System.out.println("Transication not Posssible");
	}

	@Override
	public void checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("Account Balance is "+balance
				+"/n overdraftLimit"+overdraftLimit);
		
	}

}
