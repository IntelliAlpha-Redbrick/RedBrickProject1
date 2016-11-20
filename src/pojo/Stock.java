package pojo;

import java.util.Date;

public class Stock {

	private String stockId;
	private String employeeName;
	private String brickType;
	private int quantity;
	private int inStock;
	private Date stockDate;

	// Getters and Setters
	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getBrickType() {
		return brickType;
	}

	public void setBrickType(String brickType) {
		this.brickType = brickType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public Date getStockDate() {
		return stockDate;
	}

	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}

	// Constructor
	// 1. For Add Stock
	public Stock(String employeeName, String brickType, int quantity, Date stockDate) {
		super();
		this.employeeName = employeeName;
		this.brickType = brickType;
		this.quantity = quantity;
		this.stockDate = stockDate;
	}

	// 2. Table (tableStockFinished)
	public Stock(String stockId, String brickType, int quantity, int inStock, Date stockDate) {
		super();
		this.stockId = stockId;
		this.brickType = brickType;
		this.quantity = quantity;
		this.inStock = inStock;
		this.stockDate = stockDate;
	}

	// Tostring
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", employeeName=" + employeeName + ", brickType=" + brickType
				+ ", quantity=" + quantity + ", inStock=" + inStock + ", stockDate=" + stockDate + "]";
	}

}
