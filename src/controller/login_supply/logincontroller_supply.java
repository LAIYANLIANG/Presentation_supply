package controller.login_supply;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.login_supply.login_supply;
import model.login_supply.login_supply_service;

@Controller
@SessionAttributes(names = { "loginStatusCertified", "supply_acc", "msgError", "supply_pwd" })
public class logincontroller_supply {
	private login_supply_service service;

	@Autowired
	public logincontroller_supply(login_supply_service service) {
		this.service = service;
	}

	@RequestMapping(path = "/login_supply_controller", method = RequestMethod.POST)
	public String processAction(
			@RequestParam(name = "supply_acc") String supply_acc,
			@RequestParam(name = "supply_pwd") String supply_pwd, 
			Model m) {
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("msgError", errors);

		if (supply_acc == null || supply_acc.length() == 0) {
			errors.put("supply_acc", "帳號未輸入<br/>");
		}
		if (supply_pwd == null || supply_pwd.length() == 0) {
			errors.put("supply_pwd", "密碼未輸入<br/>");
		}
		if (errors != null && !errors.isEmpty()) {
			return "login_supply";
		}

		boolean status = service.checklogin(new login_supply(supply_acc, supply_pwd));
		if (status) {
			m.addAttribute("loginStatusCertified", true);
			// m.addAttribute("msgWelcome","welcome");
			m.addAttribute("supply_acc", supply_acc);
			// m.addAttribute("dispflag", "none");
			// m.addAttribute("dispflagBbs", "none");

			return "/login_supper_success";
		}
		errors.put("supply_allerror", "帳號或密碼不正確");
		return "login_supply";

	}
	


}
