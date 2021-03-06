import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class AnimalDetails {

	public static void list() {

		Connection connection = new DBConnection().getConnection();
		if (connection != null) {
			try {
				String selectSQL = "select * from animal_details order by animal_details_id";
				PreparedStatement statement = connection
						.prepareStatement(selectSQL);

				ResultSet set = statement.executeQuery();

				while (set.next()) {
					int animal_details_id = set.getInt("animal_details_id");
					int population = set.getInt("population");
					int animal_id = set.getInt("animal_id");
					int city_id = set.getInt("city_id");

					System.out.println("Animal Details Id : "
							+ animal_details_id + " population : " + population
							+ " and Animal Id : " + animal_id
							+ " and City Id : " + city_id);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public static boolean insert() {
		Connection connection = new DBConnection().getConnection();
		if (connection != null) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter population: ");
				int pop = sc.nextInt();
				System.out.println("Enter Animal Id: ");
				int aid = sc.nextInt();
				System.out.println("Enter City Id: ");
				int cityid = sc.nextInt();
				String insertSQL = "insert into animal_details(population,animal_id, city_id) values (?,?.?)";
				PreparedStatement statement = connection
						.prepareStatement(insertSQL);

				statement.setInt(1, pop);
				statement.setInt(2, aid);
				statement.setInt(3, cityid);
				int rowAffected = statement.executeUpdate();

				if (rowAffected > 0)
					return true;
				else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}

	public static boolean delete() {
		Connection connection = new DBConnection().getConnection();
		if (connection != null) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Animal Details Id: ");
				int adid = sc.nextInt();
				String deleteSQL = "delete from animal_details where animal_detail_id=?";
				PreparedStatement statement = connection
						.prepareStatement(deleteSQL);

				statement.setInt(1, adid);

				int rowAffected = statement.executeUpdate();

				if (rowAffected > 0)
					return true;
				else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}

	public static boolean update() {
		Connection connection = new DBConnection().getConnection();
		if (connection != null) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter population: ");
				int pop = sc.nextInt();
				System.out.println("Enter Animal Id: ");
				int aid = sc.nextInt();
				System.out.println("Enter city Id: ");
				int cityid = sc.nextInt();
				String updateSQL = "update animal_details set population=? where animal_id=? and city_id = ?";
				PreparedStatement statement = connection
						.prepareStatement(updateSQL);

				statement.setInt(1, pop);
				statement.setInt(2, aid);
				statement.setInt(3, cityid);

				int rowAffected = statement.executeUpdate();

				if (rowAffected > 0)
					return true;
				else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}
}
