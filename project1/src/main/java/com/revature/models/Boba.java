package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name ="boba")
public class Boba {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private String flavor;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private int price;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customerName;
	
	
	public Boba(int id, String flavor, String description, int price, Customer customerName) {
		super();
		this.id = id;
		this.flavor = flavor;
		this.description = description;
		this.price = price;
		this.customerName = customerName;
	}
	
	
	public Boba() {
		super();
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

	public Customer getCustomer() {
		return customerName;
	}

	public void setCustomer(Customer customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "Boba [id=" + id + ", flavor=" + flavor + ", description=" + description + ", price=" + price
				+ ", customerName=" + customerName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerName, description, flavor, id, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boba other = (Boba) obj;
		return Objects.equals(customerName, other.customerName) && Objects.equals(description, other.description)
				&& Objects.equals(flavor, other.flavor) && id == other.id && price == other.price;
	}

}
