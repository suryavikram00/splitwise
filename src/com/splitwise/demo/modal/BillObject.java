package com.splitwise.demo.modal;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;






@Table(name="bill_List")
@Entity()
@Component
public class BillObject implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4374113410767348574L;
    
	@Id
	@Column(name="id")
	public int billId;
	
	@Id
	@Column(name="description")
	private String description;
	
	@Column(name="bill_price")
	private int price;
	
	
	@Column(name="paid_by")
	private String paidBy;
	
	
	
	

	public BillObject( String description, int price, String paidBy, String[] splitBy) {
		
		
		this.description = description;
		this.price = price;
		this.paidBy = paidBy;
		
	}


	public BillObject() {
		
	}
	
		
	
	public int getBillId() {
		return billId;
	}



	/*public void setBillId(int id) {
		this.billId = id;
	}
*/
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

	public String getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}


	@Override
	public String toString() {
		return "BillObject [billId=" + billId + ", description=" + description + ", price=" + price + ", paidBy="
				+ paidBy + "]";
	}



	
	
	
	
	
	
	
	
}
