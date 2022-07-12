package com.revature.dtos;

import java.util.Objects;

public class BobaDTO {
	private int id;
	private String flavor;
	private String description;
	private int price;
	private CustomerDTO customer;
	
	
	
	public BobaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "BobaDTO [id=" + id + ", flavor=" + flavor + ", description=" + description + ", price=" + price
				+ ", customer=" + customer + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(customer, description, flavor, id, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BobaDTO other = (BobaDTO) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(description, other.description)
				&& Objects.equals(flavor, other.flavor) && id == other.id && price == other.price;
	}
	

}
