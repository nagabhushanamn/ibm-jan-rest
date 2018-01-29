package com.shop.bill;

import com.shop.pm.PriceMatrix;

/*
 *  design & performance issues
 *  ------------------------------
 *  
 *  -> tight-coupling
 *  
 *  		==> can't extend with new features
 *  
 *  -> too many dependency instances are created & destructed
 *  
 *      ==> slow, memory use high,...
 *  
 *  -> unit-testing not possible
 *  
 *      ==> dev/bug-fix slow
 *      
 *      -------------------------------------------------
 *      
 *      why these issues ?
 *      
 *      ==> dependent itself creating it's own dependency.
 *      
 *      soln:
 *      
 *      ==> dont create, do Lookup
 *      
 *      limitation on Lookup:
 *      
 *      ==> location tight-coupling
 *      
 *      best soln :
 *      
 *      ==> dont create/lookup , inject thru 'some-one'  ( IOC )
 *      
 *      how to implement IOC ?
 *      
 *      	using 'Dependency Injection' ( DI )
 *      
 *       - constructor DI
 *       - setter DI
 *       
 *       --------------------------------------------------------
 *       
 *       OO Principles  ( OO A & D )
 *       -----------------------------
 *       
 *       
 *       S.O.L.I.D principles
 *       
 *      
 *      S — Single responsibility principle
		O — Open for extension, & closed for modification principle
		L — Liskov substitution principle
		I — Interface segregation principle
		D — Dependency Inversion principle
 *      
 * 
 * 
 */

public class BillingImpl {

	private PriceMatrix priceMatrix;

	public BillingImpl(PriceMatrix priceMatrix) {
		this.priceMatrix = priceMatrix;
	}

	public double getTotalPrice(String[] cart) {

		double total = 0.0;
		for (String item : cart) {
			total += priceMatrix.getPrice(item);
		}
		return total;

	}
}
