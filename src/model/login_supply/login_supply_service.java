package model.login_supply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class login_supply_service implements Ilogin_supply_service {
	private login_supply_Dao lDao;
	
	@Autowired
	public login_supply_service(login_supply_Dao lDao) {
		this.lDao=lDao;
	}

	@Override
	public boolean checklogin(login_supply supply) {
		return lDao.checklogin(supply);
	}

}
