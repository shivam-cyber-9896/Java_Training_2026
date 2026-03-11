package com.shivam.monocept.string.model1;

public class EmailInputVaildater {
	String Email;
	String DomainName;
	int countUn;
	String UserName;

	public EmailInputVaildater(String Email) {
		this.Email = Email;
	}

	public void Vaildater() {
		Email = Email.trim();
		if (Email.contains("@")) {

			countUn = Email.indexOf('@');

			UserName = Email.substring(0, countUn);

			DomainName = Email.substring(countUn);

            if (DomainName.equalsIgnoreCase("@gmail.com")) {
                Print();
            } 
            System.out.println("Invaild");
            return;
	}
	}

	private void Print() {
		System.out.println(Email);
		System.out.println("UserName ="+UserName);
		System.out.println("Total Charcter in  a String  :"+countUn);
		System.out.println("Domain Name is "+DomainName);
		UserName=UserName.replace('.','_');
		System.out.println("User Name After  Vaildation "+UserName);
	}
}
