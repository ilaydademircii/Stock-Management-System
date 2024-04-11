package workshop2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static DatabaseConnection instance;
	private String username = "root";
	private String password = "zidily";
	private String dbName = "firma";
	private String host = "localhost";
	private int port = 3306;
	private Connection conn = null;

	// veritabanı bağlantısını tek defa yapıp tüm projede onu paylaşarak kullanmak
	// için
	public static DatabaseConnection getInstance() {
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}

	public Connection getConnection() {
		if (conn == null) {
			// Bağlantı oluşturulmamışsa, yeni bir bağlantı oluşturun
			String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useUnicode=true&characterEncoding=utf8";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, username, password);
				System.out.println("Yeni bağlantı oluşturuldu.");
			} catch (ClassNotFoundException e) {
				System.out.println("Driver bulunamadi");
			} catch (SQLException e) {
				System.out.println("Baglanti basarisiz.");
				e.printStackTrace();
			}
		}
		return conn;
	}

	public DatabaseConnection() {

		// jdbc:mysql://localhost:3306/firma
		String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useUnicode=true&characterEncoding=utf8";
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Driver bulunamadi");
		}

		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Baglanti basarili.");
		} catch (SQLException e) {
			System.out.println("Baglanti basarisiz.");
			e.printStackTrace();

		}
	}
}
