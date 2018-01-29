package com.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.shop.bill.Billing;
import com.shop.bill.BillingImpl;
import com.shop.pm.PriceMatrix;
import com.shop.pm.PriceMatrixImpl_v2;

@Configuration
@ComponentScan(basePackages = "com.shop")
public class AppConfig {

	@Bean
	public Billing billingComp() {
		Billing billing = new BillingImpl(priceMatrixV2());
		return billing;
	}

	@Bean
	public PriceMatrix priceMatrixV2() {
		return new PriceMatrixImpl_v2();
	}

}
