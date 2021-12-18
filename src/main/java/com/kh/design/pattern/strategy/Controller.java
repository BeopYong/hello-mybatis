package com.kh.design.pattern.strategy;

public class Controller {

	private CommonService service;
	
	public Controller(CommonService service) {
		this.service = service;
	}
	
	public void test() {
		service.test();
	}
}
