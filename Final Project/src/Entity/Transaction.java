package Entity;

public class Transaction {

	private String transactionID;
	private String itemID;
	private String customerName;
	private Integer quantity;
	
	public Transaction(String transactionID, String itemID, String customerName, Integer quantity) {
		super();
		this.transactionID = transactionID;
		this.itemID = itemID;
		this.customerName = customerName;
		this.quantity = quantity;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
