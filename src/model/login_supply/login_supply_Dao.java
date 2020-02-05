package model.login_supply;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class login_supply_Dao implements Ilogin_supply_Dao {
	private SessionFactory sessionFactory;

	@Autowired
	public login_supply_Dao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public boolean checklogin(login_supply supply) {

//		System.out.println("supply_acc=" + supply.getSupply_acc());
//		System.out.println("pwd=" + supply.getSupply_pwd());
//		System.out.println("supply_name="+supply.getSupply_name());
//		System.out.println("supply_id="+supply.getSupply_id());
		Session session = sessionFactory.getCurrentSession();
//		System.out.println("session=" + session);
		String hqlStr = "From login_supply where supply_acc =:sacc and supply_pwd =:spwd";
		Query query = session.createQuery(hqlStr);
//		System.out.println(query);
		query.setParameter("sacc", supply.getSupply_acc());
		query.setParameter("spwd", supply.getSupply_pwd());

		login_supply login_supply = (login_supply) query.uniqueResult();

		if (login_supply != null) {
			return true;
		}
		return false;
	}

}
