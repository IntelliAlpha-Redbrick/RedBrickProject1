package pojo;

import java.util.Date;

public class Purchase {

	private String purchaseOrderId;
	private Date orderDate;
	private String purchaseType;
	private int quantity;
	private String sellerContact;
	private String sellerName;
	private String deliveryStatus;
	private String orderDescription;
	private double totalAmount;
	private double pendingAmount;
	private double paidAmount;
	
	public String getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(String purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSellerContact() {
		return sellerContact;
	}
	public void setSellerContact(String sellerContact) {
		this.sellerContact = sellerContact;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getPendingAmount() {
		return pendingAmount;
	}
	public void setPendingAmount(double pendingAmount) {
		this.pendingAmount = pendingAmount;
	}
	public double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	
	//Constructor for Purchase Order Dialog
	public Purchase(String purchaseType, String sellerContact, String sellerName, int quantity, String orderDescription,
			double totalAmount, double paidAmount, Date orderDate) {
		super();
		this.purchaseType = purchaseType;
		this.sellerContact = sellerContact;
		this.sellerName = sellerName;
		this.quantity = quantity;
		this.orderDescription = orderDescription;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
		this.orderDate = orderDate;
	}
	
	//Purchase View Details pane
	public Purchase(String purchaseOrderId, Date orderDate, String purchaseType, int quantity, String sellerContact,
			String sellerName, String deliveryStatus, double paidAmount, double pendingAmount) {
		super();
		this.purchaseOrderId = purchaseOrderId;
		this.orderDate = orderDate;
		this.purchaseType = purchaseType;
		this.quantity = quantity;
		this.sellerContact = sellerContact;
		this.sellerName = sellerName;
		this.deliveryStatus = deliveryStatus;
		this.paidAmount = paidAmount;
		this.pendingAmount = pendingAmount;
	}
	
	
	
	

}
