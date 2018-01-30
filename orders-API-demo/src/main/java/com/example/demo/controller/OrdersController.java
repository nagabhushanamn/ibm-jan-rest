package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.Order;
import com.example.demo.repository.OrdersRepository;


@Controller
@RequestMapping(value = "/orders")
public class OrdersController {

	@Autowired
	private OrdersRepository ordersRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String getAllOrders(Model model) {

		// for Test
		Order order = new Order();
		order.setCostInCents(100);
		order.setDescription("test order");
		ordersRepository.create(order);

		List<Order> orders = ordersRepository.findAll();
		model.addAttribute("orders", orders);
		return "view-orders"; // View-Name
	}

}
