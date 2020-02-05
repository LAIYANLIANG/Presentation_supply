package model.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "commodity")
@Component
public class Sales {
	private int commodity_id;
	private int supply_id;
	private String commodity_name;
	private int commodity_originalprice;
	private int commodity_price;
	private String Vegan;

	public Sales () {
		
	}
	
	public Sales (int supply_id, String commodity_name, int commodity_originalprice, int commodity_price, String Vegan) {
		this.setSupply_id(supply_id);
		this.setCommodity_name(commodity_name);
		this.setCommodity_originalprice(commodity_originalprice);
		this.setCommodity_price(commodity_price);
		this.setVegan(Vegan);
	}

	@Id
	@Column(name = "COMMODITY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCommodity_id() {
		return commodity_id;
	}

	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
	}

	@Column(name = "SUPPLY_ID")
	public int getSupply_id() {
		return supply_id;
	}

	public void setSupply_id(int supply_id) {
		this.supply_id = supply_id;
	}

	@Column(name = "COMMODITY_NAME")
	public String getCommodity_name() {
		return commodity_name;
	}

	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}

	@Column(name = "COMMODITY_ORIGINALPRICE")
	public int getCommodity_originalprice() {
		return commodity_originalprice;
	}

	public void setCommodity_originalprice(int commodity_originalprice) {
		this.commodity_originalprice = commodity_originalprice;
	}

	@Column(name = "COMMODITY_PRICE")
	public int getCommodity_price() {
		return commodity_price;
	}

	public void setCommodity_price(int commodity_price) {
		this.commodity_price = commodity_price;
	}

	@Column(name = "VEGAN")
	public String getVegan() {
		return Vegan;
	}

	public void setVegan(String vegan) {
		Vegan = vegan;
	}
	
}
