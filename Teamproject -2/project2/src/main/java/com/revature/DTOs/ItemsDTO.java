package com.revature.DTOs;

import java.util.Objects;

import com.revature.models.Items;

public class ItemsDTO {

		private int id;
		private String itemName;
		private double itemPrice;
		
		public ItemsDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public ItemsDTO(Items item) {
			super();
			id = item.getItemId();
			itemName = item.getItemName();
			itemPrice = item.getItemPrice();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		public double getItemPrice() {
			return itemPrice;
		}

		public void setItemPrice(double itemPrice) {
			this.itemPrice = itemPrice;
		}

		@Override
		public String toString() {
			return "ItemsDTO [id=" + id + ", itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, itemName, itemPrice);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ItemsDTO other = (ItemsDTO) obj;
			return id == other.id && Objects.equals(itemName, other.itemName)
					&& Double.doubleToLongBits(itemPrice) == Double.doubleToLongBits(other.itemPrice);
		}
		
		
		
		
}
