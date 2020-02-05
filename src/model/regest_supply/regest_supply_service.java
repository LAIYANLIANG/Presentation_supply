package model.regest_supply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class regest_supply_service implements Iregest_supply_service {

	private regest_supply_Dao regest_supply_Dao;
	@Autowired
	public regest_supply_service (regest_supply_Dao regest_supply_Dao) {
		this.regest_supply_Dao=regest_supply_Dao;
	}

	@Override
	public regest_supply insert(regest_supply reg_sup) {

		return regest_supply_Dao.insert(reg_sup);
	}

	@Override
	public boolean updatePwd(regest_supply reg_sup) {
		return regest_supply_Dao.updatePwd(reg_sup);
	}

}
