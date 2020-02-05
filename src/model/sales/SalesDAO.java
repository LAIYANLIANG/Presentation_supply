package model.sales;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class SalesDAO implements ISalesDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public SalesDAO(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Sales insert(Sales sal) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(sal);
			return sal;
		} catch (Exception e) {
			System.out.println("insert-e:" + e);
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Sales update(Sales sal) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "From Sales where supply_id =: supplyId";
			Query query = session.createQuery(hql);
			query.setParameter("supplyId", sal.getSupply_id());

			Sales obj = (Sales) query.uniqueResult();

			obj.setCommodity_name(sal.getCommodity_name());
			obj.setCommodity_price(sal.getCommodity_price());
			obj.setCommodity_originalprice(sal.getCommodity_originalprice());
			obj.setVegan(sal.getVegan());

			session.update(obj);
			return obj;
		} catch (Exception e) {
			System.out.println("update-e:" + e);
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ArrayList<Sales> select(Sales sal) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "From Sales where commodity_id =: commodityId";
			Query query = session.createQuery(hql);
			query.setParameter("commodityId", sal.getCommodity_id());
			return (ArrayList<Sales>) query.list();
		} catch (Exception e) {
			System.out.println("select-e:" + e);
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void delete(int supply_id) {
		Session session = sessionFactory.getCurrentSession();
//		String hql = "From Commodity";
//		Query query = session.createQuery(hql);
//		List list = query.list();
//		if (list != null) {
//			session.delete(sal);
//			return true;
//		}
//		return false;
		
		Sales sales = new Sales();
		sales.setSupply_id(supply_id);
		session.delete(sales);
	}

}
