package com.splitwise.demo.modal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table(name="bill_to_user_map")
@Entity()
@Component
public class BillToUserMap {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bill_id")
	private int billId;
	
	
	
	/*@Column(name="bill_id")
	private int billId;*/
	
	
	@Column(name="owes_getsback")
	private int owes_GetsBack;
	
	
	@Column(name="paid_by")
	private String paidBy;
	
	
	@Column(name="paid_to")
	private String PaidTo;
	
	@OneToOne(mappedBy="billToUserMap",cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.MERGE,CascadeType.REFRESH})
	//@JoinColumn(name="billToUserMap")
	private TestBillObject billObject;
	
	
	
	
	public BillToUserMap() {
		
	}
	public TestBillObject getBillObject() {
		return billObject;
	}
	public void setBillObject(TestBillObject billObject) {
		this.billObject = billObject;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getOwes_GetsBack() {
		return owes_GetsBack;
	}
	

	
	
	public BillToUserMap(int owes_GetsBack, String paidBy, String paidTo) {
		super();
		this.owes_GetsBack = owes_GetsBack;
		this.paidBy = paidBy;
		PaidTo = paidTo;
	}
	public void setOwes_GetsBack(int owes_GetsBack) {
		this.owes_GetsBack = owes_GetsBack;
	}
	public String getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}
	public String getPaidTo() {
		return PaidTo;
	}
	public void setPaidTo(String paidTo) {
		PaidTo = paidTo;
	}
	@Override
	public String toString() {
		return "BillToUserMap [billId="  + ", owes_GetsBack=" + owes_GetsBack + ", paidBy=" + paidBy
				+ ", PaidTo=" + PaidTo + "]";
	}
	
	
	
	

}
