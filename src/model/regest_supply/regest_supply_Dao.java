package model.regest_supply;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class regest_supply_Dao implements Iregest_supply_Dao {

	private SessionFactory sessionFactory;

	@Autowired
	public regest_supply_Dao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public regest_supply insert(regest_supply insert_supply) {
		Session session = sessionFactory.getCurrentSession();
		session.save(insert_supply);
		return insert_supply;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean updatePwd(regest_supply insert_supply) {
		Session session = sessionFactory.getCurrentSession();

//		//Debug
//		System.out.println("updatePwd_session="+session);

		String hqlStr = "From regest_supply Where supply_acc = :supply_acc";//
		Query query = session.createQuery(hqlStr);//
//		
//		//Debug
//		System.out.println("update_query="+query);

		query.setParameter("supply_acc", insert_supply.getSupply_acc());
		regest_supply obj = (regest_supply) query.uniqueResult();//

		if (obj != null && !obj.getSupply_pwd().equals(insert_supply.getSupply_pwd())) {
			obj.setSupply_pwd(insert_supply.getSupply_pwd());
			session.update(obj);
			return true;
		}

		return false;
	}

}
