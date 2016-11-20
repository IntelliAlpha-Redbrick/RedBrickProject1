package pojo;

import java.util.Date;

public class Employee {

	// Employee Details
	private String employeeId;
	private String employeeName;
	private String employeeType;
	private String employeeContact;
	private String employeeAddress;
	private String employeeSupervisor;
	private String employeeLocation;
	private Date dateOfJoining;
	private int numOfBricks;
	private int numOfLines;
	private double pendingAmount;
	private double paidAmount;
	private double salary;
	private Date paymentDate;
	private Date workDate;

	// Getter n Setters
	public String getEmployeeId() {
		return employeeId;
	}

	public double getLastPaymentAmount() {
		return paidAmount;
	}

	public void setLastPaymentAmount(double lastPaymentAmount) {
		this.paidAmount = lastPaymentAmount;
	}

	public Date getLastPaymentDate() {
		return paymentDate;
	}

	public void setLastPaymentDate(Date lastPaymentDate) {
		this.paymentDate = lastPaymentDate;
	}

	public void setPendingAmount(double pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getNumOfBricks() {
		return numOfBricks;
	}

	public void setNumOfBricks(int numOfBricks) {
		this.numOfBricks = numOfBricks;
	}

	public int getNumOfLines() {
		return numOfLines;
	}

	public void setNumOfLines(int numOfLines) {
		this.numOfBricks = numOfLines;
	}

	public double getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(float pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

	public double getLastPaidAmount() {
		return paidAmount;
	}

	public void setLastPaidAmount(double lastPaidAmount) {
		this.paidAmount = lastPaidAmount;
	}

	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getEmployeeContact() {
		return employeeContact;
	}

	public void setEmployeeContact(String employeeContact) {
		this.employeeContact = employeeContact;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeSupervisor() {
		return employeeSupervisor;
	}

	public void setEmployeeSupervisor(String employeeSupervisor) {
		this.employeeSupervisor = employeeSupervisor;
	}

	public String getEmployeeLocation() {
		return employeeLocation;
	}

	public void setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getPreviousWorkDate() {
		return workDate;
	}

	public void setPreviousWorkDate(Date previousWorkDate) {
		this.workDate = previousWorkDate;
	}

	// Constructor
	// 1. Constructor for Add Bricks
	/**
	 * @param employeeName
	 * @param numOfBricks
	 * @param previousWorkDate
	 */
	public Employee(String employeeName, int numOfBricks, Date previousWorkDate) {
		super();
		this.employeeName = employeeName;
		this.numOfBricks = numOfBricks;
		this.workDate = previousWorkDate;
	}

	// 2. Constructor for Add Payment
	/**
	 * @param employeeName
	 * @param paidAmount
	 * @param paymentDate
	 */
	public Employee(String employeeName, double paidAmount, Date paymentDate) {
		super();
		this.employeeName = employeeName;
		this.paidAmount = paidAmount;
		this.paymentDate = paymentDate;
	}

	// 3. Constructor for Add Employee
	/**
	 * @param employeeName
	 * @param employeeType
	 * @param employeeContact
	 * @param employeeAddress
	 * @param employeeSupervisor
	 * @param employeeLocation
	 * @param dateOfJoining
	 */
	public Employee(String employeeName, String employeeType, String employeeContact, String employeeAddress,
			String employeeSupervisor, String employeeLocation, Date dateOfJoining) {
		super();
		this.employeeName = employeeName;
		this.employeeType = employeeType;
		this.employeeContact = employeeContact;
		this.employeeAddress = employeeAddress;
		this.employeeSupervisor = employeeSupervisor;
		this.employeeLocation = employeeLocation;
		this.dateOfJoining = dateOfJoining;
	}

	// 4. Constructor for tables(Pather, Dhulai, Nikasi)
	public Employee(String employeeId, String employeeName, int numOfBricks, double pendingAmount) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.numOfBricks = numOfBricks;
		this.pendingAmount = pendingAmount;
	}

	// 5. Constructor for tables(Beldar, Fireman)
	public Employee(String employeeId, String employeeName, double pendingAmount, int numOfLines) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.pendingAmount = pendingAmount;
		this.numOfLines = numOfLines;
	}

	// 5. Constructor for tables(Others)
	public Employee(String employeeId, String employeeName, double paidAmount, double salary, Date paymentDate) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.paidAmount = paidAmount;
		this.salary = salary;
		this.paymentDate = paymentDate;
	}

	// 5. Constructor for tables(Employee Details)
	public Employee(String employeeId, String employeeName, double lastPaymentAmount, Date lastPaymentDate) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.paidAmount = lastPaymentAmount;
		this.paymentDate = lastPaymentDate;
	}

	// Default Constructor
	public Employee() {
		this.employeeId = "empty";
		this.employeeName = "empty";
		this.employeeType = "empty";
		this.employeeContact = "empty";
		this.employeeAddress = "empty";
		this.employeeSupervisor = "empty";
		this.employeeLocation = "empty";
		this.numOfBricks = 0;
		this.numOfLines = 0;
		this.pendingAmount = 0.0;
		this.paidAmount = 0.0;
		this.salary = 0.0;
		this.dateOfJoining = null;
		this.paymentDate = null;
		this.workDate = null;
	}

	// ToString for testing purpose.
	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeType="
				+ employeeType + ", employeeContact=" + employeeContact + ", employeeAddress=" + employeeAddress
				+ ", employeeSupervisor=" + employeeSupervisor + ", employeeLocation=" + employeeLocation
				+ ", dateOfJoining=" + dateOfJoining + ", numOfBricks=" + numOfBricks + ", previousWorkDate=" + workDate
				+ ", numOfLines=" + numOfLines + ", pendingAmount=" + pendingAmount + ", lastPaidAmount=" + paidAmount
				+ ", lastPaymentDate=" + paymentDate + "]";
	}

}
