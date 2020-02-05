package model.supply;

import java.util.ArrayList;

public interface isupplyDAO {
public supply insert(supply sup);
public supply update(supply sup);
public ArrayList<supply> select ();
public void delete (int supply_id);
public supply selectone(int supply_id);
}
