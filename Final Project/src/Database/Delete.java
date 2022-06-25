package Database;

public class Delete {
	
	public void deleteFNB(String id) {
		String query = String.format("DELETE FROM food_and_beverage WHERE itemID = '%s'", id);
		DatabaseHelper.getConnection().executeUpdate(query);
	}
	
	public void deleteGrocery(String id) {
		String query = String.format("DELETE FROM other_groceries WHERE itemID = '%s'", id);
		DatabaseHelper.getConnection().executeUpdate(query);
	}

}
