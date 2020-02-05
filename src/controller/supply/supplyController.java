package controller.supply;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.supply.supply;
import model.supply.supplyService;
import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller

@RequestMapping("/member")
public class supplyController {
	private supplyService service;


	@Autowired
	public supplyController(supplyService service) {
		this.service = service;
	}

	@RequestMapping(value = "/supply.insert.controller", method = RequestMethod.POST)
	private String insert(supply supply) {
		service.insert(supply);
		return "insert_supply_service";
	}
//	(
//			@RequestParam(name = "supply_id") int supply_id,
//			  @RequestParam(name = "supply_acc") String supply_acc,
//			  @RequestParam(name = "supply_pwd") String supply_pwd,
//			  @RequestParam(name = "supply_name") String supply_name,
//			  @RequestParam(name = "supply_ph;") String supply_ph,
//			  @RequestParam(name = "supply_address;") String supply_address,
//			  @RequestParam(name = "supply_contact;") String supply_contact,
//			  @RequestParam(name = "supply_contactphnum;") String supply_contactphnum,
//			  @RequestParam(name = "supply_email;") String supply_email,
//			  @RequestParam(name = "supply_conumber;") String supply_conumber,
//			  @RequestParam(name = "supply_bankaccount;") String supply_bankaccount,
//			  @RequestParam(name = "supply_invoice;") String supply_invoice,
//			  @RequestParam(name = "limit;") int limit,
//			  @RequestParam(name = "supply_vip;;") String supply_vip,
//			  Model m) {
//		supply supply=new supply(supply_id,supply_acc,supply_pwd,supply_name,supply_ph,supply_address,supply_contact,
//				supply_contactphnum,supply_email,supply_conumber,supply_bankaccount,supply_invoice,limit,supply_vip);
//		service.insert(supply);
//		return null;

//	}
	@RequestMapping(value = "/supply.update.controller", method = RequestMethod.POST)
	private String update(
			@RequestParam(name = "supply_id") String supply_id,
			@RequestParam(name = "supply_acc") String supply_acc, 
			@RequestParam(name = "supply_pwd") String supply_pwd,
			@RequestParam(name = "supply_name") String supply_name, 
			@RequestParam(name = "supply_ph") String supply_ph,
			@RequestParam(name = "supply_address") String supply_address,
			@RequestParam(name = "supply_contact") String supply_contact,
			@RequestParam(name = "supply_contactphnum") String supply_contactphnum,
			@RequestParam(name = "supply_email") String supply_email,
			@RequestParam(name = "supply_conumber") String supply_conumber,
			@RequestParam(name = "supply_bankaccount") String supply_bankaccount,
			@RequestParam(name = "supply_invoice") String supply_invoice,
			@RequestParam(name = "supply_limit") String limit, 
			@RequestParam(name = "supply_vip") String supply_vip,
			Model m) {

		int a = Integer.parseInt(supply_id);
		int b = Integer.parseInt(limit);
		supply supply = new supply(a, supply_acc, supply_pwd, supply_name, supply_ph, supply_address, supply_contact,
				supply_contactphnum, supply_email, supply_conumber, supply_bankaccount, supply_invoice, b, supply_vip);
		service.update(supply);
		return "update_supply_service";
	}

	@RequestMapping(value = "/supply.delete.controller", method = RequestMethod.POST)
	private String delete(
			  @RequestParam(name = "supply_id") String supply_id,
			  //@RequestParam(name = "supply_acc") String supply_acc,
//			  @RequestParam(name = "supply_pwd") String supply_pwd,
//			  @RequestParam(name = "supply_name") String supply_name,
//			  @RequestParam(name = "supply_ph;") String supply_ph,
//			  @RequestParam(name = "supply_address;") String supply_address,
//			  @RequestParam(name = "supply_contact;") String supply_contact,
//			  @RequestParam(name = "supply_contactphnum;") String supply_contactphnum,
//			  @RequestParam(name = "supply_email;") String supply_email,
//			  @RequestParam(name = "supply_conumber;") String supply_conumber,
//			  @RequestParam(name = "supply_bankaccount;") String supply_bankaccount,
//			  @RequestParam(name = "supply_invoice;") String supply_invoice,
//			  @RequestParam(name = "limit;") int limit,
//			  @RequestParam(name = "supply_vip;;") String supply_vip,
			Model m) {
//		supply supply = new supply(supply_id,supply_acc,supply_pwd,supply_name,supply_ph,supply_address,supply_contact,
//				supply_contactphnum,supply_email,supply_conumber,supply_bankaccount,supply_invoice,limit,supply_vip)
		{
			int a=Integer.parseInt(supply_id);
			supply supply = new supply();
			service.delete(a);
			return "delete_supply_service";
		}
	}
	
	@RequestMapping(value = "/supply.select.controller", method = RequestMethod.POST)
	private String select(Model m) {
		ArrayList<String> list=service.select();
		int length=list.size();
		m.addAttribute("suplist"+list);
		m.addAttribute("supplength"+length);
		return "delete_select_service";
	}
	@RequestMapping(value = "/supply.selectone.controller", method = RequestMethod.POST)
	private String selectone(@RequestParam(name = "supply_id") String supply_id,Model m) {
	
	if(supply_id != null || supply_id.length()!=0)
	{
	
		int a = Integer.parseInt(supply_id);
		 supply sup = service.selectone(a);
		m.addAttribute("supply_id",sup.getSupply_id());
		m.addAttribute("supply_acc",sup.getSupply_acc());
		m.addAttribute("supply_pwd",sup.getSupply_pwd());
		m.addAttribute("supply_name",sup.getSupply_name());
		m.addAttribute("supply_ph",sup.getSupply_ph());
		m.addAttribute("supply_address",sup.getSupply_address());
		m.addAttribute("supply_contact",sup.getSupply_contact());
		m.addAttribute("supply_contactphnum",sup.getSupply_contactphnum());
		m.addAttribute("supply_email",sup.getSupply_email());
		m.addAttribute("supply_conumber",sup.getSupply_conumber());
		m.addAttribute("supply_bankaccount",sup.getSupply_bankaccount());
		m.addAttribute("supply_invoice",sup.getSupply_invoice());
		m.addAttribute("supply_limit",sup.getLimit());
		m.addAttribute("supply_vip",sup.getSupply_vip());
		
		//System.out.println("getSupply_acc"+sup.getSupply_acc());//測試用的
		return "selectone_suply_service";
		
	}
	return "selectone_supply3";
	}
}
