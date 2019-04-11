package com.test.jdbc.modal;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Bill_Details")
@Component
public class BillDetails implements Serializable {
	
	private static final long serialVersionUID = -4374113410767348574L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="Owes_By")
	private String owesBy;
	
	@Column(name="Owesby_Getsback")
	private int owesByGetsBack;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.REFRESH,CascadeType.DETACH})
	@JoinColumn(name="Bill_Id")
	private BillList billList;

	public BillDetails(String owesBy, int owesByGetsBack) {
		super();
		this.owesBy = owesBy;
		this.owesByGetsBack = owesByGetsBack;
		
	}

	public BillDetails() {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getOwesBy() {
		return owesBy;
	}

	public void setOwesBy(String owesBy) {
		this.owesBy = owesBy;
	}

	public int getOwesByGetsBack() {
		return owesByGetsBack;
	}

	public void setOwesByGetsBack(int owesByGetsBack) {
		this.owesByGetsBack = owesByGetsBack;
	}

	public BillList getBillList() {
		return billList;
	}

	public void setBillList(BillList billList) {
		this.billList = billList;
	}

	@Override
	public String toString() {
		return "BillDetails [Id=" + Id + ", owesBy=" + owesBy + ", owesByGetsBack=" + owesByGetsBack + "]";
	}

	
	
	
	
	
	
}
