package com.splitwise.demo.modal;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;






@Table(name="Bill_List")
@Entity()
@Component
public class TestBillObject implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4374113410767348574L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bill_id")
	public int billId;
	
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private int price;
	
	//@OneToMany(	cascade= {CascadeType.ALL})
	@OneToOne(	cascade= {CascadeType.ALL})
	@JoinColumn(name="bill_to_user_id")
	//private List<BillToUserMap> billToUserMap;
	private BillToUserMap billToUserMap;
	
	
	
	public void setBillId(int billId) {
		this.billId = billId;
	}


	public BillToUserMap getBillToUserMap() {
		return billToUserMap;
	}


	public void setBillToUserMap(BillToUserMap billToUserMap) {
		this.billToUserMap = billToUserMap;
	}


	/*	
	public void addBillTouser(BillToUserMap billToUser)
	{
		if(billToUserMap==null)
		{
		//	billToUserMap= new LinkedList<>();
			
		}
		//billToUserMap.add(billToUser);
	}
		
	
		

	public List<BillToUserMap> getBillToUserMap() {
		return billToUserMap;
	}


	public void setBillToUserMap(List<BillToUserMap> billToUserMap) {
		this.billToUserMap = billToUserMap;
	}

*/
	public TestBillObject( String description, int price) {
		
		
		this.description = description;
		this.price = price;
		
		
		
	}


	public TestBillObject() {
		
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


	@Override
	public String toString() {
		return "TestBillObject [billId=" + billId + ", description=" + description + ", price=" + price + "]";
	}

	



	
	
	
	
	
	
	
	
}
