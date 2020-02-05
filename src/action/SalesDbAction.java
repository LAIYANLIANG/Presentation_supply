package action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import model.sales.Sales;
import model.sales.SalesDAO;
import model.sales.SalesService;

@Repository
public class SalesDbAction {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	private Session session;

	private void processAction() {
		try {
			session = sessionFactory.getCurrentSession();

			Sales sal = new Sales();
			System.out.println("false");
			SalesDAO sDAO = new SalesDAO(sessionFactory);
			System.out.println("false");
			SalesService sService = new SalesService(sDAO);
			System.out.println("false");
			
			sal.setSupply_id(1);
			sal.setCommodity_name("rice");
			sal.setCommodity_originalprice(200);
			sal.setCommodity_price(150);
			sal.setVegan("veg");
			sService.insert(sal);
						
		} catch (Exception e) {
			System.out.println("false");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SalesDbAction action = new SalesDbAction();
		action.processAction();
	}

}
