package Entity;

public class OtherGroceries extends Item {
	
	private String expiredDate;

	public OtherGroceries(String itemID, String itemName, Integer itemPrice, String expiredDate) {
		super(itemID, itemName, itemPrice);
		this.expiredDate = expiredDate;
	}
	
	@Override
	public void print() {
		System.out.println(". Item ID = " + this.getItemID());
		System.out.println("   Item Name = " + this.getItemName());
		System.out.println("   Item Category = Groceries");
		System.out.println("   Item Price = " + this.getItemPrice());
		System.out.println("   Expired Date = " + this.getExpiredDate());
		System.out.println();
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

}
