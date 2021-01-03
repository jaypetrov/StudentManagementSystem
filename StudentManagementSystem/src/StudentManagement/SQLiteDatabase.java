package StudentManagement;

import java.sql.*;
import javax.swing.*;

public class SQLiteDatabase {

	public static Connection ConnectDB() {

		try {
			Class.forName("org.sqlite.JDBC");
			Connection connect = DriverManager.getConnection("jdbc:sqlite:StudentDatabase.db");
			return connect;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database is NOT connected");
			return null;
		}

	}


}


//"jdbc:sqlite:C:\\Users\\Jason\\StudentManagement\\StudentManagement\\StudentDatabase.db");