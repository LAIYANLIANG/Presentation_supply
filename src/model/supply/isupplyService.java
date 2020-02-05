package model.supply;

import java.util.ArrayList;

public interface isupplyService {
public supply insert(supply sup);
public supply update (supply sup);
public ArrayList<String>select();
public void delete(int supply_id);
public supply selectone(int supply_id);

}
