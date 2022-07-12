package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEMS")
public class Items {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemId;
	@Column(length= 20,nullable = false)
	private String itemName;
	@Column(length= 20,nullable = false)
	private String itemCategory;
	@Column(length= 20, nullable = false)
	private double itemPrice;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", itemCategory=" + itemCategory + ", itemPrice="
				+ itemPrice + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(itemCategory, itemId, itemName, itemPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		return Objects.equals(itemCategory, other.itemCategory) && itemId == other.itemId
				&& Objects.equals(itemName, other.itemName)
				&& Double.doubleToLongBits(itemPrice) == Double.doubleToLongBits(other.itemPrice);
	}
	
}


