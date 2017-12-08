import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private String driverClassName = "org.postgresql.Driver";
	private String connectionURL = "jdbc:postgresql://localhost:5432/Animal_Species";
	private String userName = "postgres";
	private String password = "root";

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(connectionURL, userName,
					password);
			if (connection != null)
				System.out.println("Connected Whith DB..........");
			else
				System.out.println("Not Connected Whith DB..........");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}

	public static void main(String[] args) {
		System.out.println(new DBConnection().getConnection());
	}
}