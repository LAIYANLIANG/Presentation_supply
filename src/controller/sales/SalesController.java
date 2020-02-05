package controller.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.sales.Sales;
import model.sales.SalesService;

@Controller
public class SalesController {

	private SalesService service;

	@Autowired
	public SalesController(SalesService service) {
		this.service = service;
	}

//	@RequestMapping(value = "/sales.insert.controller", method = RequestMethod.POST)
//	private String processAction(@RequestParam(name = "supply_id") int supply_id,
//								 @RequestParam(name = "commodity_name") String commodity_name,
//								 @RequestParam(name = "commodity_originalprice") int commodity_originalprice,
//								 @RequestParam(name = "commodity_price") int commodity_price,
//								 @RequestParam(name = "Vegan") String Vegan,
//								 Model m
//								 ) {
//
//		Sales sales = new Sales();
//		
//		sales.setSupply_id(supply_id);
//		sales.setCommodity_name(commodity_name);
//		sales.setCommodity_originalprice(commodity_originalprice);
//		sales.setCommodity_price(commodity_price);
//		sales.setVegan(Vegan);
//		
//		service.insert(sales);
//
//		
//		
//		return "test1";
//	}
	
	@RequestMapping(value = "/sales.insert.controller", method = RequestMethod.POST)
	private String insert(Sales sales) {	
		service.insert(sales);
		return "test1";
	}
	
	@RequestMapping(value = "/sales.update.controller", method = RequestMethod.POST)
	private String update(@RequestParam(name = "supply_id") int supply_id,
			 			  @RequestParam(name = "commodity_name") String commodity_name,
			 			  @RequestParam(name = "commodity_originalprice") int commodity_originalprice,
			 			  @RequestParam(name = "commodity_price") int commodity_price,
			 			  @RequestParam(name = "Vegan") String Vegan,
			 			  Model m) {	
		Sales sales = new Sales(supply_id, commodity_name, commodity_originalprice, commodity_price, Vegan);
		service.update(sales);
		return "test1";
	}
	
	@RequestMapping(value = "/sales.delete.controller", method = RequestMethod.POST)
	private String delete(@RequestParam(name = "supply_id") int supply_id,
			 			  Model m) {	
		Sales sales = new Sales();
		service.delete(supply_id);
		return "test1";
	}
	
}