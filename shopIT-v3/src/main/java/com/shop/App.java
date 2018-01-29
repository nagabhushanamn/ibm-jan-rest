package com.shop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.bill.Billing;
import com.shop.config.AppConfig;

public class App {

	public static void main(String[] args) {

		// init
		ConfigurableApplicationContext ac = null;
		// ac = new ClassPathXmlApplicationContext("spring.xml");
		ac = new AnnotationConfigApplicationContext(AppConfig.class);

		// use
		String[] cart = { "234567", "435645" };
		Billing billing = ac.getBean("billingComp", Billing.class);
		double total = billing.getTotalPrice(cart);
		System.out.println(total);

		// destroy
		ac.close();

	}

}
