package Main;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import Database.Delete;
import Database.Insert;
import Database.Load;
import Database.Update;
import Entity.BronzeMember;
import Entity.FoodAndBeverage;
import Entity.GoldMember;
import Entity.Item;
import Entity.Member;
import Entity.MemberPerson;
import Entity.OtherGroceries;
import Entity.SilverMember;
import Entity.Transaction;

public class Main {
	
	Scanner sc = new Scanner(System.in);
	Load load = new Load();
	Insert insert = new Insert();
	Delete delete = new Delete();
	Update update = new Update();
	Vector<MemberPerson>memberlist = load.getMember();
	Member bronze = new BronzeMember();
	Member silver = new SilverMember();
	Member gold = new GoldMember();
	
	public void printMenu() {
		System.out.println("Mini-Market");
		System.out.println("===========");
		System.out.println("1. Staff");
		System.out.println("2. Customer");
		System.out.println("3. Member");
		System.out.print("Login as >> ");
	}
	
	public void printStaffMenu() {
		System.out.println("Staff Menu");
		System.out.println("==========");
		System.out.println("1. Add Item");
		System.out.println("2. Update Item");
		System.out.println("3. Delete Item");
		System.out.println("4. View Items");
		System.out.println("5. Add Member");
		System.out.println("6. View Member");
		System.out.println("7. Back");
		System.out.print(">> ");
	}
	
	public void addItem() {
		String category;
		do {
			System.out.print("Input Item Category [FnB | Grocery] (case insensitie): ");
			category = sc.nextLine();
		} while (!category.equalsIgnoreCase("FnB") && !category.equalsIgnoreCase("Grocery"));
		
		String itemName;
		do {
			System.out.print("Input Item Name [must more than 3 characters]: ");
			itemName = sc.nextLine();
		} while (itemName.length() < 3);
		
		Integer itemPrice;
		do {
			System.out.print("Input Item Price [must greater than 1000]: ");
			try {
				itemPrice = sc.nextInt();
			} catch (Exception e) {
				itemPrice = 0;
			}
			sc.nextLine();
		} while (itemPrice < 1000);
		
		if (category.equalsIgnoreCase("FnB")) {
			String itemID;
			itemID = load.getFnBID();
			
			String itemSize;
			do {
				System.out.print("Input Item Size [Small | Medium | Large] (case insensitive): ");
				itemSize = sc.nextLine();
			} while (!itemSize.equalsIgnoreCase("Small") && !itemSize.equalsIgnoreCase("Medium") && !itemSize.equalsIgnoreCase("Large"));
			insert.insertFNB(itemID, itemName, itemPrice, itemSize);
		} else {
			String itemID;
			itemID = load.getGroceryID();
			
			String expiredDate;
			do {
				System.out.print("Input Item Expired Date [in 'dd-mm-yyyy' format]: ");
				expiredDate = sc.nextLine();
			} while (expiredDate.length() < 10);
			insert.insertGrocery(itemID, itemName, itemPrice, expiredDate);
		}
		System.out.println("Item Successfully Added!");
	}
	
	public void updateItem() {
		viewItems();
		if (!load.getItems().isEmpty()) {
			Integer index;
			do {
				System.out.print("Input Item Number To Be Updated [1 - " + load.getItems().size() + "]: ");
				try {
					index = sc.nextInt();
				} catch (Exception e) {
					index = -1;
				}
				sc.nextLine();
			} while (index < 1 || index> load.getItems().size());
			
			Integer itemPrice;
			do {
				System.out.print("Input Item Price [must greater than 1000]: ");
				try {
					itemPrice = sc.nextInt();
				} catch (Exception e) {
					itemPrice = 0;
				}
				sc.nextLine();
			} while (itemPrice < 1000);
			if (load.getItems().get(index - 1).getItemID().startsWith("FB")) {
				update.updateFNB(itemPrice, load.getItems().get(index - 1).getItemID());
			} else {
				update.updateGrocery(itemPrice, load.getItems().get(index - 1).getItemID());
			}
			System.out.println("Item Successfully Updated!");
		}
	}
	
	public void deleteItem() {
		viewItems();
		if (!load.getItems().isEmpty()) {
			Integer index;
			do {
				System.out.print("Input Item Number To Be Deleted [1 - " + load.getItems().size() + "]: ");
				try {
					index = sc.nextInt();
				} catch (Exception e) {
					index = -1;
				}
				sc.nextLine();
			} while (index < 1 || index> load.getItems().size());
			
			if (load.getItems().get(index - 1).getItemID().startsWith("FB")) {
				delete.deleteFNB(load.getItems().get(index - 1).getItemID());
			} else {
				delete.deleteGrocery(load.getItems().get(index - 1).getItemID());
			}
			System.out.println("Item Succeddfully Deleted");
		}
	}
	
	public void viewItems() {
		if (load.getItems().isEmpty()) {
			System.out.println("No Items!");
		} else {
			int i = 1;
			for (Item item : load.getItems()) {
				System.out.print(i);
				item.print();
				i++;
			}
		}
	}
	
	public void staffMenu() {
		boolean isRun = true;
		int choice = 0;
		
		do {
			
			do {
				printStaffMenu();
				try {
					choice = sc.nextInt();
				} catch (Exception e) {
					choice = 0;
				}
				sc.nextLine();
			} while (choice < 1 || choice > 7);
			System.out.println();
			switch(choice) {
				case 1:
					addItem();
					System.out.println("Press Enter to Continue...");
					sc.nextLine();
					break;
				case 2:
					updateItem();
					System.out.println("Press Enter to Continue...");
					sc.nextLine();
					break;
				case 3:
					deleteItem();
					System.out.println("Press Enter to Continue...");
					sc.nextLine();
					break;
				case 4:
					viewItems();
					System.out.println("Press Enter to Continue...");
					sc.nextLine();
					break;
				case 5:
					AddMember();
					System.out.println("Press Enter to Continue...");
					break;
				case 6 :
					ViewMember();
					System.out.println("Press Enter to Continue...");
					break;
				case 7:
					isRun = false;
					break;
			}
			
		} while (isRun);
	}

	public void printCustomerMenu() {
		System.out.println("Customer Menu");
		System.out.println("=============");
		System.out.println("1. Create Transaction");
		System.out.println("2. View Transaction");
		System.out.println("3. Back");
		System.out.print(">> ");
	}
	
	public void createTransaction() {
		if (!load.getItems().isEmpty()) {
			String transactionID;
			transactionID = load.getTransactionID();
			
			String customerName;
			do {
				System.out.print("Input Your Name [must more than 3 characters]: ");
				customerName = sc.nextLine();
			} while (customerName.length() < 3);
			
			viewItems();
			Integer index;
			do {
				System.out.print("Input Item Number [1 - " + load.getItems().size() + "]: ");
				try {
					index = sc.nextInt();
				} catch (Exception e) {
					index = - 1;
				}
				sc.nextLine();
			} while (index < 1 || index > load.getItems().size());
			
			Integer quantity;
			do {
				System.out.print("Input quantity [must greater than 0]: ");
				try {
					quantity = sc.nextInt();
				} catch (Exception e) {
					quantity = 0;
				}
				sc.nextLine();
			} while (quantity < 1);
			
			insert.insertTransaction(transactionID, load.getItems().get(index - 1).getItemID(), customerName, quantity);
			
			System.out.println();
			System.out.println("Detail Transaction");
			System.out.println("==================");
			System.out.println("Transaction ID = " + transactionID);
			System.out.println("CustomerName = " + customerName);
			System.out.println("Item Name = " + load.getItems().get(index - 1).getItemName());
			if (load.getItems().get(index - 1) instanceof FoodAndBeverage) {
				System.out.println("Item Size = " + ((FoodAndBeverage)load.getItems().get(index - 1)).getItemSize());
			} else {
				System.out.println("Expired Date = " + ((OtherGroceries)load.getItems().get(index - 1)).getExpiredDate());
			}
			System.out.println("Quantity = " + quantity);
			System.out.println("Total Price = " + (quantity * load.getItems().get(index - 1).getItemPrice()));
			System.out.println();
		}
	}
	
	
	
	public void AddMember()
	{
		System.out.print("Input Member Name : ");
		String MemberName = sc.nextLine();
		boolean cek = false;
		while(cek==false)
		{
			System.out.println("Input Member Gender : ");
			String MemberGender = sc.nextLine();
			if(MemberGender.equalsIgnoreCase("Male") || MemberGender.equalsIgnoreCase("Female"))
			{
				cek=true;
				boolean cek2 = false;
				while(cek2==false)
				{
					System.out.print("Input Member Type [Bronze | Silver | Gold |] :");
					String MemberType = sc.nextLine();
					if(MemberType.equalsIgnoreCase("Bronze"))
					{
						cek2=true;
						insert.insertMember(GenerateMemberID(), MemberName, MemberGender, MemberType, bronze.SetMemberPoints());
					}
					else if(MemberType.equalsIgnoreCase("Silver"))
					{
						cek2=true;
						insert.insertMember(GenerateMemberID(), MemberName, MemberGender, MemberType, silver.SetMemberPoints());
					}
					else if(MemberType.equalsIgnoreCase("Gold"))
					{
						cek2=true;
						insert.insertMember(GenerateMemberID(), MemberName, MemberGender, MemberType, gold.SetMemberPoints());
					}
				}
			}
		}
	}
	public void ViewMember()
	{
		if(memberlist.isEmpty())
		{
			System.out.println("No Member");
		}
		else
		{
			for(MemberPerson mp : memberlist)
			{
				System.out.println("ID : " +mp.getMemberGender());
				System.out.println("Member Name : "+mp.getMemberName());
				System.out.println("Member Gender : "+mp.getMemberGender());
				System.out.println("Member Type : "+mp.getMemberType());
				System.out.println("Member Points : "+mp.getMemberPoint());
			}
		}
	}
	public String GenerateMemberID()
	{
		Random rand = new Random();
		Integer random = rand.nextInt(10);
		Integer random2 = rand.nextInt(10);
		Integer random3 = rand.nextInt(10);
		return "MB"+random+random2+random3;
	}
	public void viewTransaction() {
		if (load.getTransaction().isEmpty()) {
			System.out.println("No Transaction!");
		} else {
			int i = 1;
			for (Transaction tr : load.getTransaction()) {
				System.out.println(i + ". Transaction ID = " + tr.getTransactionID());
				System.out.println("   Customer Name = " + tr.getCustomerName());
				System.out.println("   Item Name = " + load.getItemName(tr.getItemID()));
				System.out.println("   Quantity = " + tr.getQuantity());
				System.out.println();
			}
		}
	}
	public void printMemberMenu()
	{
		
		System.out.println("1. View Member Detail");
		System.out.println("2. Back");
		System.out.print(">>");
	}
	
	public void MemberMenu() {
		
		boolean isRun = true;
		int choice = 0;
		
		do {
			
			do {
				printMemberMenu();
				try {
					choice = sc.nextInt();
				} catch (Exception e) {
					choice = 0;
				}
				sc.nextLine();
			} while (choice < 1 || choice > 2);
			System.out.println();
			switch(choice) {
				case 1:
					
					printMemberDetail();
					System.out.println("Press Enter to Continue...");
					sc.nextLine();
					break;
				
				case 2:
					isRun = false;
					break;
			}
			
		} while (isRun);
		
		
			
		
	}
	
	public void printMemberDetail()
	{
		
		boolean cek=false;
		while(cek==false)
		{
			System.out.print("Input Member ID : ");
			String MemberID = sc.nextLine();
			if(load.checkMemberID(MemberID)==true)
			{
				cek=true;
				//Vector<MemberPerson>member = load.getMemberbyID(MemberID);
				for(MemberPerson m : load.getMemberbyID(MemberID))
				{
					System.out.println("Name : " +m.getMemberName());
					System.out.println("Type : "+m.getMemberType());
					System.out.println("Points : "+m.getMemberPoint());
					if(m.getMemberType().equalsIgnoreCase("Bronze"))
					{
						bronze.MemberCard();
					}
					else if(m.getMemberType().equalsIgnoreCase("Silver"))
					{
						silver.MemberCard();
					}
					else if(m.getMemberType().equalsIgnoreCase("Gold"))
					{
						gold.MemberCard();
					}
				}
			}
		}
	}
	public void customerMenu() {
		boolean isRun = true;
		int choice = 0;
		
		do {
			
			do {
				printCustomerMenu();
				try {
					choice = sc.nextInt();
				} catch (Exception e) {
					choice = 0;
				}
				sc.nextLine();
			} while (choice < 1 || choice > 3);
			System.out.println();
			switch(choice) {
				case 1:
					createTransaction();
					System.out.println("Press Enter to Continue...");
					sc.nextLine();
					break;
				case 2:
					viewTransaction();
					System.out.println("Press Enter to Continue...");
					sc.nextLine();
					break;
				case 3:
					isRun = false;
					break;
			}
			
		} while (isRun);
	}
	
	public Main() {
		boolean isRun = true;
		int choice = 0;
		
		do {
			
			do {
				printMenu();
				try {
					choice = sc.nextInt();
				} catch (Exception e) {
					choice = 0;
				}
				sc.nextLine();
			} while (choice < 1 || choice > 4);
			System.out.println();
			switch(choice) {
				case 1:
					staffMenu();
					break;
				case 2:
					customerMenu();
					break;
				case 3:
					MemberMenu();
					break;
				case 4:
					System.out.println("Thank You!");
					isRun = false;
					break;
			}
			
		} while (isRun);
	}

	public static void main(String[] args) {
		new Main();
	}

}
