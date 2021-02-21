package com.vinsguru.cqrs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_order_summary")
public class PurchaseOrderSummary {

		@Id
	    private String state;
	    private Double totalSale;

	    public String getState() {
	        return state;
	    }

	    public void setState(String state) {
	        this.state = state;
	    }

	    public Double getTotalSale() {
	        return totalSale;
	    }

	    public void setTotalSale(Double totalSale) {
	        this.totalSale = totalSale;
	    }
}
