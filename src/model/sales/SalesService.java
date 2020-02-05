package model.sales;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
//@EnableTransactionManagement
public class SalesService implements ISalesService {

	private SalesDAO sDao;

	@Autowired
	public SalesService(SalesDAO sDao) {
		this.sDao = sDao;
	}

	@Override
	public Sales insert(Sales sal) {
		return sDao.insert(sal);
	}

	@Override
	public Sales update(Sales sal) {
		return sDao.update(sal);
	}

	@Override
	public ArrayList<String> select(Sales sal) {
		ArrayList<Sales> coms = sDao.select(sal);
		ArrayList<String> comStr = new ArrayList<String>();
		for(Sales comm : coms) {
			comStr.add(0, comm.getCommodity_name()+" "+comm.getCommodity_originalprice()+" "+
					 comm.getCommodity_price()+" "+comm.getVegan());
		}
		return comStr;
	}
	
	@Override
	public void delete(int supply_id) {
		sDao.delete(supply_id);
	}

}
