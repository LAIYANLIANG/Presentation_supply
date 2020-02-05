package model.supply;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class supplyDAO implements isupplyDAO {
//	private Session session;
//	private supply supply;
	private SessionFactory sessionFactory;
	//private SessionFactory sessionFactory;

	@Autowired
	public supplyDAO(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
	}
	
//	private Session getSession() {
//		//System.out.println(session);
//		return session;
//	}

	@Override
	public supply insert(supply sup) {
//		supply hsupply=getSession().get(supply.class,supply.getSupply_id());
//		if(hsupply==null) {
//			getSession().save(hsupply);
//		}
//		return null;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(sup);
			return sup;
		} catch (Exception e) {
			System.out.println("insert-e" + e);
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public supply update(supply sup) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "From supply where supply_id=:supply_id";
			Query query = session.createQuery(hql);
			query.setParameter("supply_id", sup.getSupply_id());
			supply obj = (supply) query.uniqueResult();
			
//			if(obj!=null && 
//					!obj.getSupply_address().equals(sup.getSupply_address())&&
//					!obj.getSupply_bankaccount().equals(sup.getSupply_bankaccount())&&
//					!obj.getSupply_contact().equals(sup.getSupply_contact())&&
//					!obj.getSupply_contactphnum().equals(sup.getSupply_contactphnum())&&
//					!obj.getSupply_conumber().equals(sup.getSupply_conumber())&&
//					!obj.getSupply_email().equals(sup.getSupply_email())&&
//					!obj.getSupply_invoice().equals(sup.getSupply_invoice())&&
//					!obj.getSupply_name().equals(sup.getSupply_name())&&
//					!obj.getSupply_ph().equals(sup.getSupply_ph())&&
//					!obj.getSupply_pwd().equals(sup.getSupply_pwd())
//					) 
//			{
//			obj.setSupply_id(sup.getSupply_id());
			obj.setSupply_acc(sup.getSupply_acc());//
			obj.setSupply_pwd(sup.getSupply_pwd());//
			obj.setSupply_name(sup.getSupply_name());//
			obj.setSupply_ph(sup.getSupply_ph());//
			obj.setSupply_conumber(sup.getSupply_conumber());//
			obj.setSupply_address(sup.getSupply_address());//
			obj.setSupply_bankaccount(sup.getSupply_bankaccount());//
			obj.setSupply_email(sup.getSupply_email());//
			obj.setSupply_contactphnum(sup.getSupply_contactphnum());//
			obj.setSupply_contact(sup.getSupply_contact());//
			obj.setSupply_vip(sup.getSupply_vip());//
			obj.setLimit(sup.getLimit());//
			obj.setSupply_invoice(sup.getSupply_invoice());//
			session.update(obj);
			return obj;
//		}
//			return false;
		}catch(Exception e) {
			System.out.println("update-e:" + e);
			e.printStackTrace();
			return null;
		}
	
	}




	
//		Session session = sessionFactory.getCurrentSession();
//		String hql="From member_supply";
//		Query query = session.createQuery(hql);
//		List list=query.list();
//		if(list != null) {
//			session.delete(sup);
//			return true;
//		}
//		return false;
//		supply supply1 = new supply();
//		supply.setSupply_id(supply_id);
//		session.delete(supply1);
//
//	}
	
	@Override
	public void delete(int supply_id) {
		Session session=sessionFactory.getCurrentSession();
		supply supply=session.get(supply.class, supply_id);
		try {
		if(supply!=null) {
			session.delete(supply);
		}
		}catch(Exception e){
			System.out.println("delete_supply_DAO"+e);
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ArrayList<supply> select() {
		try {
		Session session = sessionFactory.getCurrentSession();
		String hql="From supply";
		Query query = session.createQuery(hql);
		
		return(ArrayList<supply>) query.list();
		}catch(Exception e) {
			System.out.println("select-e"+e);
			return null;
		}
	
	}

	@Override
	public supply selectone(int supply_id) {
Session session = sessionFactory.getCurrentSession();
supply supply = session.get(supply.class, supply_id);
return supply;
	}

}
