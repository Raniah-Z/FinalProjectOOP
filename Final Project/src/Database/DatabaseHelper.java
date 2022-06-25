package Database;

public class DatabaseHelper {
	
	/* 
	 * class ini menggunakan Creational Design Pattern: Singleton Pattern
	 * agar class Connect hanya bisa mempunyai 1 instance saja dan
	 * menyediakan global access point agar instance tersebut bisa
	 * diakses secara global.
	 */
	
	private static Connect connection;
	
	public static Connect getConnection() {
		if (connection == null) {
			connection = new Connect();
		}
		return connection;
	}

}
