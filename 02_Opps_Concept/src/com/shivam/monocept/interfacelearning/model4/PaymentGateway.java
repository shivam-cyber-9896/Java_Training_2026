package com.shivam.monocept.interfacelearning.model4;

public interface PaymentGateway {
	void pay(double Amount);
	void refund(double Amount);

}
