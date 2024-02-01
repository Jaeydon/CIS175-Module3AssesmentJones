/**
 * @author Jaeydon Jones - jmjones31@dmacc.edu
 * CIS175 22895 - Java II
 * {2/1/2024}
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "baglist")
public class AdventurerInventory {
	
	@Id
	@GeneratedValue
	@Column(name="gold")
	private int gold;
	@Column(name="itemCategory")
	private String itemCategory;
	@Column(name="item")
	private String item;
	
	public AdventurerInventory() {
       super();
	}

	public AdventurerInventory(String itemCategory, String item) {
		this.itemCategory = itemCategory;
		this.item = item;

	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "AdventurerInventory [Gold=" + gold + ", itemCategory=" + itemCategory + ", item=" + item + "]";
	}
	
	

}