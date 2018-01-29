package com.shop.pm;

import org.springframework.stereotype.Service;

@Service(value = "priceMatrixV1")
public class PriceMatrixImpl_v1 implements PriceMatrix {

	public double getPrice(String item) {
		return 100.00;
	}

}
