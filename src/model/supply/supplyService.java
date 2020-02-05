package model.supply;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class supplyService implements isupplyService {
//	private Session session;
	private supplyDAO sDao;
//	private SessionFactory sessionFactory;

//	public supplyService(Session session) {
//		System.out.println(session);
//		this.session=session;
//		sDao=new supplyDAO(sessionFactory);
//	}

	@Autowired
	public supplyService(supplyDAO sDao) {
		this.sDao = sDao;
	}

	@Override
	public supply insert(supply sup) {
		return sDao.insert(sup);
	}

	@Override
	public supply update(supply sup) {
		return sDao.update(sup);
	}

	@Override
	public ArrayList<String> select() {
		ArrayList<supply> sups = sDao.select();
		ArrayList<String> supStr = new ArrayList<String>();
		for (supply comm : sups) {
			supStr.add(0,
					          comm.getSupply_id() + " " 
			                + comm.getSupply_acc() + " " 
							+ comm.getSupply_pwd() + " "
							+ comm.getSupply_name() + " " 
							+ comm.getSupply_ph() + " " 
							+ comm.getSupply_address() + " "
							+ comm.getSupply_contact() + " " 
							+ comm.getSupply_contactphnum() + " "
							+ comm.getSupply_email() + " " 
							+ comm.getSupply_conumber() + " "
							+ comm.getSupply_bankaccount() + " " 
							+ comm.getSupply_invoice() + " " 
							+ comm.getSupply_vip()+ " " 
							+ comm.getLimit() + " " 
							);
		}
		return supStr;
	}

	@Override
	public void delete(int supply_id) {
		sDao.delete(supply_id);
	}

	@Override
	public supply selectone(int supply_id) {
		return sDao.selectone(supply_id);
	}

}
