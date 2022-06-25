package Entity;

public class FoodAndBeverage extends Item {

	private String itemSize;
	
	public FoodAndBeverage(String itemID, String itemName, Integer itemPrice, String itemSize) {
		super(itemID, itemName, itemPrice);
		this.itemSize = itemSize;
	}
	
	@Override
	public void print() {
		System.out.println(". Item ID = " + this.getItemID());
		System.out.println("   Item Name = " + this.getItemName());
		System.out.println("   Item Category = Food & Beverage");
		System.out.println("   Item Price = " + this.getItemPrice());
		System.out.println("   Item Size = " + this.getItemSize());
		System.out.println();
	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}
	
}
