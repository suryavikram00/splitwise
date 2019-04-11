package com.test.jdbc.modal;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Bill_List")
@Component
public class BillList implements Cloneable,Serializable  {
	
	 private static final long serialVersionUID = -4374113410767348574L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Paid_By")
	private String paidBy;
	
	@Column(name="Bill_Price")
	private int billPrice;
	
	@OneToMany(mappedBy="billList",fetch=FetchType.EAGER, cascade= {CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.REFRESH,CascadeType.DETACH})	
	private List<BillDetails> billDetails ;
	
	public BillList() {
		
		// TODO Auto-generated constructor stub
	}

	public BillList(String description, String paidBy, int billPrice) {
	
		this.description = description;
		this.paidBy = paidBy;
		this.billPrice = billPrice;
	
	}
	
	public void addBillDetails(BillDetails billDetail)
	{
		if(billDetails==null)
		{
			billDetails= new LinkedList<BillDetails>();
		}
		
		billDetails.add(billDetail);
		
		billDetail.setBillList(this);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}

	public int getBillPrice() {
		return billPrice;
	}

	public void setBillPrice(int billPrice) {
		this.billPrice = billPrice;
	}

	public List<BillDetails> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetails> billDetails) {
		this.billDetails = billDetails;
	}



	@Override
	public String toString() {
		return "BillList [id=" + id + ", description=" + description + ", paidBy=" + paidBy + ", billPrice=" + billPrice
				+ ", billDetails=" + billDetails + "]";
	}
	
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}  
	
	
	
}
