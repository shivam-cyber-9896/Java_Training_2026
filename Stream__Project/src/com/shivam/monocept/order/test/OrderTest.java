package com.shivam.monocept.order.test;

import java.util.List;

import com.shivam.monocept.order.model1.Input;
import com.shivam.monocept.order.model1.Order;



public class OrderTest {

	public static void main(String[] args) {
	List<Order> orders=Input.addHardcoded();
	orders=Input.input();

	}

}
