package controller.regest_supply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.regest_supply.regest_supply;
import model.regest_supply.regest_supply_service;

@Controller
public class changePwdcontroller_supply {
	private regest_supply_service service;

	@Autowired
	public changePwdcontroller_supply(regest_supply_service service) {
		this.service = service;
	}
 
	@RequestMapping(path = "/changePwdAction_controller", method = RequestMethod.POST)
	private String processAction(
			HttpServletRequest request, 
			@RequestParam(name="changePwd_org") String changePwd_org,
			@RequestParam(name = "changePwd") String changpwd, 
			Model m) {
		HttpSession session = request.getSession();
		String supply_acc = (String) session.getAttribute("supply_acc");
		String supply_pwd = changpwd;
		System.out.println(supply_pwd);

		if (supply_acc != null && supply_acc.length() != 0 && supply_pwd != null && supply_pwd.length() != 0) {
			boolean rstatus = service.updatePwd(new regest_supply(supply_acc, supply_pwd));

			if (rstatus) {
				m.addAttribute("msg", "密碼修改成功，請重新登入");
				return "login_supply";
			} else {
				m.addAttribute("msg", "密碼未修改，請重新輸入");
				return "changePwd";
			}
		} else {
			m.addAttribute("msg", "密碼不可空白，請重新輸入");
			return "changePwd";
		}
	}
}
