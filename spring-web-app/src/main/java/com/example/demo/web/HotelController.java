package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Menu;

@Controller
public class HotelController {

	@RequestMapping(value = "/menu")
	public @ResponseBody Menu getMenu() {
		return new Menu("Biryani", 200.00);
	}

}
