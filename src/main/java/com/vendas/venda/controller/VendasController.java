package com.vendas.venda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendasController {
	
	@RequestMapping("/vendas")
	public String hello() {
		return "Hello world !";
	}
}
