package com.shop;

import com.shop.bill.BillingImpl;

public class App {

	public static void main(String[] args) {

		// init
		BillingImpl billing = new BillingImpl();

		// use
		String[] cart = { "234567", "435645" };
		double total = billing.getTotalPrice(cart);
		System.out.println(total);

		// destroy
		// ..

	}

}
