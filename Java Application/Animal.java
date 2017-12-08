import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class Animal {


//	public static void list() {
//
//		Connection connection = new DBConnection().getConnection();
//		if (connection != null) {
//			try {
//				String selectSQL = "select * from animal order by animal_id";
//				PreparedStatement statement = connection
//						.prepareStatement(selectSQL);
//
//				ResultSet set = statement.executeQuery();
//
//				while (set.next()) {
//					int animal_id = set.getInt("animal_id");
//					String animal_name = set.getString("animal_name");
//					String height = set.getString("height");
//					int weight = set.getInt("weight");
//					String sci_name = set.getString("sci_name");
//					int life_span = set.getInt("life_span");
//					int age = set.getInt("age");
//					String color = set.getString("color");
//					int main_cat_id = set.getInt("main_category_id");
//					String gender = set.getString("gender");
//
//					System.out.println("Animal Id : " + animal_id
//							+ " and Animal Name : " + animal_name
//							+ " and height: " + height
//							+ " and weight: " + weight
//							+ " and sci_name: " + sci_name
//							+ " life_span: " + life_span
//							+ " and age: " + age
//							+ " and color: " + color
//							+ " and main_cat_id: " + main_cat_id
//							+ " and gender: " + gender);
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//		}
//	}

	public static boolean insert() {
		Connection connection = new DBConnection().getConnection();
		if (connection != null) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Animal Name: ");
				String name = sc.nextLine();
				System.out.println("Enter Animal height: ");
				int height = sc.nextInt();
				System.out.println("Enter Animal weight: ");
				int weight = sc.nextInt();
				System.out.println("Enter Animal Scientific Name: ");
				String sci_name = sc.nextLine();
				System.out.println("Enter Animal life span: ");
				int life_span = sc.nextInt();
				System.out.println("Enter Animal age: ");
				int age = sc.nextInt();
				System.out.println("Enter Animal color: ");
				String color = sc.nextLine();
				System.out.println("Enter Main Category Id: ");
				int mcatid = sc.nextInt();
				System.out.println("Enter Animal gender: ");
				String gender = sc.nextLine();
				String insertSQL = "insert into animal(name,height,weight,sci_name,life_span,age,color,main_category_id,gender) "
						+ "values (?,?,?,?,?,?,?,?,?)";
				PreparedStatement statement = connection
						.prepareStatement(insertSQL);

				statement.setInt(2, height);
				statement.setInt(3, weight);
				statement.setInt(5, life_span);
				statement.setInt(6, age);
				statement.setInt(8, mcatid);
				statement.setString(1, name);
				statement.setString(4, sci_name);
				statement.setString(7, color);
				statement.setString(9, gender);

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
				System.out.println("Enter Animal Id: ");
				int aid = sc.nextInt();
				String deleteSQL = "delete from animal where animal_id=?";
				PreparedStatement statement = connection
						.prepareStatement(deleteSQL);

				statement.setInt(1, aid);

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
				System.out.println("Enter Animal Id: ");
				int aid = sc.nextInt();
				System.out.println("Enter Animal Name: ");
				String name = sc.nextLine();
				String updateSQL = "update state set name=? where animal_id=?";
				PreparedStatement statement = connection
						.prepareStatement(updateSQL);

				statement.setString(1, name);
				statement.setInt(2, aid);

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
