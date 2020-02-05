package controller.regest_supply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.regest_supply.regest_supply;
import model.regest_supply.regest_supply_service;

@Controller

public class regestcontroller_supply {
	private regest_supply_service service;
@Autowired
	private regestcontroller_supply(regest_supply_service service) {
		this.service = service;
	}
@RequestMapping(path="/regestcontroller_supply",method=RequestMethod.POST)
	private String insert(regest_supply reg_sup) {
		service.insert(reg_sup);
		return "/login_supply";
	}

}
