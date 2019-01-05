package com.cg.mps.bean;

public class Mobile {
	public Integer mobileId;
	public String mobileName;
	public Double price;
	public Integer quantity;
	
	public Mobile() {
		super();
	}

	public Mobile(Integer mobileId, String mobileName, Double price,Integer quantity) {
		super();
		this.mobileId = mobileId;
		this.mobileName = mobileName;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getMobileId() {
		return mobileId;
	}

	public void setMobileId(Integer mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Mobile Details.... "
				+ "mobileId=" + getMobileId()+","+ 
				" mobileName=" + getMobileName()
			  + ", price=" + getPrice() + " "
		  	+ "quantity=" + getQuantity()+"\n";
  }
	

}