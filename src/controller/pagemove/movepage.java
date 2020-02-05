package controller.pagemove;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class movepage {
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(path = "/registered")
	public String processregpage() {
		return "regest/regpage";
	}
	//登入成功後，跳轉至changePwd.jsp作修改
	@RequestMapping(path="/changePwdpage")
	public String processChangePwdpage() {
		return "changePwd";
	}
	
	//
	@RequestMapping(path="/changePwdAction")
	public String pricessChangePwdaction() {
		return "login_supply";
	}
	

}
