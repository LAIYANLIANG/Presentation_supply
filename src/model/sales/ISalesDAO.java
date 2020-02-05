package model.sales;

import java.util.ArrayList;

public interface ISalesDAO {
	public Sales insert(Sales sal);
	public Sales update(Sales sal);
	public ArrayList<Sales> select(Sales sal);
	public void delete(int supply_id);
	
}
