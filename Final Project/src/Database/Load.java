package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Entity.FoodAndBeverage;
import Entity.Item;
import Entity.MemberPerson;
import Entity.OtherGroceries;
import Entity.Transaction;

public class Load {
	
	public String getItemName(String id) {
		for (Item item : this.getItems()) {
			if (id.equals(item.getItemID())) {
				return item.getItemName();
			}
		}
		return null;
	}
	
	public String getTransactionID() {
		String query = String.format("SELECT * FROM transaction");
		ResultSet rs = DatabaseHelper.getConnection().executeQuery(query);
		
		String lastID = "TR000";
		try {
			while (rs.next()) {
				if (rs.isLast()) {
					lastID = rs.getString("itemID");
				}
			}
			
			String idNumber = lastID.substring(2, 5);
			int idNum = Integer.parseInt(idNumber);
			idNum++;
			
			if (idNum < 10) {
				return "TR00" + idNum;
			} else if (idNum < 100) {
				return "TR0" + idNum;
			} else {
				return "TR" + idNum;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public Vector<MemberPerson> getMember()
	{
		Vector<MemberPerson>memberlist = new Vector<>();
		String query = String.format("Select * from member");
		ResultSet rs = DatabaseHelper.getConnection().executeQuery(query);
		try {
			while (rs.next()) {
				String MemberID = rs.getString("MemberID");
				String MemberName = rs.getString("MemberName");
				String MemberGender = rs.getString("MemberGender");
				String MemberType = rs.getString("MemberType");
				Integer MemberPoints = rs.getInt("MemberPoints");
				memberlist.add(new MemberPerson(MemberID, MemberName, MemberGender, MemberType, MemberPoints));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberlist;
	}
	public Vector<MemberPerson> getMemberbyID(String ID)
	{
		Vector<MemberPerson>memberlist = new Vector<>();
		String query = String.format("Select * from member WHERE MemberID ='%s'",ID);
		ResultSet rs = DatabaseHelper.getConnection().executeQuery(query);
		try {
			while (rs.next()) {
				String MemberID = rs.getString("MemberID");
				String MemberName = rs.getString("MemberName");
				String MemberGender = rs.getString("MemberGender");
				String MemberType = rs.getString("MemberType");
				Integer MemberPoints = rs.getInt("MemberPoints");
				memberlist.add(new MemberPerson(MemberID, MemberName, MemberGender, MemberType, MemberPoints));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberlist;
	}
	public Vector<Transaction> getTransaction(){
		Vector<Transaction> transactions = new Vector<>();
		String query = String.format("Select * from transaction");
		ResultSet rs = DatabaseHelper.getConnection().executeQuery(query);
		String transactionID, itemID, customerName;
		Integer quantity;
		try {
			while (rs.next()) {
				transactionID = rs.getString("transactionID");
				itemID = rs.getString("itemID");
				customerName = rs.getString("customerName");
				quantity = rs.getInt("quantity");
				transactions.add(new Transaction(transactionID, itemID, customerName, quantity));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactions;
	}
	public boolean checkMemberID(String MemberID)
	{
		String query = "SELECT MemberID FROM member";
		ResultSet rs = DatabaseHelper.getConnection().executeQuery(query);
		try {
			while(rs.next())
			{
				if(MemberID.equals(rs.getString("MemberID")))
				{
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public String getFnBID() {
		String query = String.format("SELECT * FROM food_and_beverage");
		ResultSet rs = DatabaseHelper.getConnection().executeQuery(query);
		
		String lastID = "FB000";
		try {
			while (rs.next()) {
				if (rs.isLast()) {
					lastID = rs.getString("itemID");
				}
			}
			
			String idNumber = lastID.substring(2, 5);
			int idNum = Integer.parseInt(idNumber);
			idNum++;
			
			if (idNum < 10) {
				return "FB00" + idNum;
			} else if (idNum < 100) {
				return "FB0" + idNum;
			} else {
				return "FB" + idNum;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getGroceryID() {
		String query = String.format("SELECT * FROM other_groceries");
		ResultSet rs = DatabaseHelper.getConnection().executeQuery(query);
		
		String lastID = "PR000";
		try {
			while (rs.next()) {
				if (rs.isLast()) {
					lastID = rs.getString("itemID");
				}
			}
			
			String idNumber = lastID.substring(2, 5);
			int idNum = Integer.parseInt(idNumber);
			idNum++;
			
			if (idNum < 10) {
				return "PR00" + idNum;
			} else if (idNum < 100) {
				return "PR0" + idNum;
			} else {
				return "PR" + idNum;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public Vector<Item> getItems(){
		String itemID, itemName;
		Integer itemPrice;
		Vector<Item> items = new Vector<>();
		
		String queryFNB = String.format("SELECT * FROM food_and_beverage");
		ResultSet rsFNB = DatabaseHelper.getConnection().executeQuery(queryFNB);
		
		String itemSize;
		try {
			while (rsFNB.next()) {
				itemID = rsFNB.getString("itemID");
				itemName = rsFNB.getString("itemName");
				itemPrice = rsFNB.getInt("itemPrice");
				itemSize = rsFNB.getString("itemSize");
				items.add(new FoodAndBeverage(itemID, itemName, itemPrice, itemSize));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String queryOther = String.format("SELECT * FROM other_groceries");
		ResultSet rsOther = DatabaseHelper.getConnection().executeQuery(queryOther);
		
		String expiredDate;
		try {
			while (rsOther.next()) {
				itemID = rsOther.getString("itemID");
				itemName = rsOther.getString("itemName");
				itemPrice = rsOther.getInt("itemPrice");
				expiredDate = rsOther.getString("expiredDate");
				items.add(new OtherGroceries(itemID, itemName, itemPrice, expiredDate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}
	
}
