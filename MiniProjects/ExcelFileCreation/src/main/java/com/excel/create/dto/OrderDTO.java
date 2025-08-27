package com.excel.create.dto;

import java.util.Objects;

public class OrderDTO {
	String orderID;
	String orderName;
	String dateTime;

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public OrderDTO(String orderID, String orderName, String dateTime) {
		super();
		this.orderID = orderID;
		this.orderName = orderName;
		this.dateTime = dateTime;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dateTime, orderID, orderName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDTO other = (OrderDTO) obj;
		return Objects.equals(dateTime, other.dateTime) && Objects.equals(orderID, other.orderID)
				&& Objects.equals(orderName, other.orderName);
	}
}
