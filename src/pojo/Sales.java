package pojo;

import java.util.Date;

public class Sales {

	private String salesOrderId;
	private Date orderDate;
	private String orderType;
	private String customerName;
	private String customerContact;
	private String deliveryDetails;
	private String deliveryStatus;
	private String paymentStatus;

	private int quantity;

	private double rate;
	private double adjustedAmount;
	private double paidAmount;
	private double pendingAmount;
	private double totalAmount;

	public String getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(String salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getDeliveryDetails() {
		return deliveryDetails;
	}

	public void setDeliveryDetails(String deliveryDetails) {
		this.deliveryDetails = deliveryDetails;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String orderStatus) {
		this.deliveryStatus = orderStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getAdjustedAmount() {
		return adjustedAmount;
	}

	public void setAdjustedAmount(double adjustedAmount) {
		this.adjustedAmount = adjustedAmount;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public double getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(double pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Sales [salesOrderId=" + salesOrderId + ", orderDate=" + orderDate + ", orderType=" + orderType
				+ ", quantity=" + quantity + ", customerName=" + customerName + ", deliveryDetails=" + deliveryDetails
				+ ", orderStatus=" + deliveryStatus + ", rate=" + rate + ", adjustedAmount=" + adjustedAmount
				+ ", paidAmount=" + paidAmount + ", pendingAmount=" + pendingAmount + ", totalAmount=" + totalAmount
				+ "]";
	}

	
	//Constructor for Add Sales Order
	public Sales(String salesOrderId, String customerName, String customerContact, String deliveryStatus,
			String paymentStatus, double pendingAmount, double totalAmount) {
		super();
		this.salesOrderId = salesOrderId;
		this.customerName = customerName;
		this.customerContact = customerContact;
		this.deliveryStatus = deliveryStatus;
		this.paymentStatus = paymentStatus;
		this.pendingAmount = pendingAmount;
		this.totalAmount = totalAmount;
	}
}
