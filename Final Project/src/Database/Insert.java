package Database;

import Entity.Member;

public class Insert {

	public void insertFNB(String itemID, String itemName, Integer itemPrice, String itemSize) {
		String query = String.format("INSERT INTO food_and_beverage VALUES ('%s', '%s', '%d', '%s')", itemID, itemName, itemPrice, itemSize);
		DatabaseHelper.getConnection().executeUpdate(query);
	}
	
	public void insertGrocery(String itemID, String itemName, Integer itemPrice, String expiredDate) {
		String query = String.format("INSERT INTO other_groceries VALUES ('%s', '%s', '%d', '%s')", itemID, itemName, itemPrice, expiredDate);
		DatabaseHelper.getConnection().executeUpdate(query);
	}
	
	public void insertTransaction(String transactionID, String itemID, String customerName, Integer quantity) {
		String query = String.format("INSERT INTO transaction VALUES ('%s', '%s', '%s', '%d')", transactionID, itemID, customerName, quantity);
		DatabaseHelper.getConnection().executeUpdate(query);
	}
	public void insertMember(String MemberID, String MemberName, String MemberGender, String MemberType, Integer MemberPoint)
	{
		String query = String.format("INSERT INTO member VALUES ('%s', '%s', '%s', '%s', '%d')", MemberID, MemberName, MemberGender, MemberType, MemberPoint);
		DatabaseHelper.getConnection().executeUpdate(query);
	}
	
}
