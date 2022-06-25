package Database;

public class Update {

	public void updateFNB(Integer price, String id) {
		String query = String.format("UPDATE food_and_beverage SET itemPrice = '%d' WHERE itemID = '%s'", price, id);
		DatabaseHelper.getConnection().executeUpdate(query);
	}
	
	public void updateGrocery(Integer price, String id) {
		String query = String.format("UPDATE other_groceries SET itemPrice = '%d' WHERE itemID = '%s'", price, id);
		DatabaseHelper.getConnection().executeUpdate(query);
	}
	
}
