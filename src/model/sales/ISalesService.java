package model.sales;

import java.util.ArrayList;

public interface ISalesService {
	public Sales insert(Sales sal);
	public Sales update(Sales sal);
	public ArrayList<String> select(Sales sal);
	public void delete(int supply_id);
}
