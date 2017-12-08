import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ComplexQueries {
	void list1() {
		Connection connection = new DBConnection().getConnection();
		if (connection != null) {
			try {
				String selectSQL = "select sum(population), state_name from animal a, animal_details d, city c, state s, main_category m, category ca, sub_category sc where a.animal_id = d.animal_id and a.main_category_id = m.main_category_id and  d.city_id = c.city_id and c.state_id = s.state_id and m.category_id = ca.category_id and m.sub_category_id = sc.sub_category_id and sc.sub_category_name = 'Invertebrates' group by state_name having sum(population) > ALL  (select sum(population) from animal a, animal_details d, city c, state s, main_category m, category ca, sub_category sc where a.animal_id = d.animal_id and a.main_category_id = m.main_category_id and  d.city_id = c.city_id and c.state_id = s.state_id and m.category_id = ca.category_id and m.sub_category_id = sc.sub_category_id and sc.sub_category_name = 'Invertebrates' and s.state_name IN ('Andhra Pradesh','Karnataka','Kerala','Tamil Nadu','Telangana') group by state_name )";
				PreparedStatement statement = connection
						.prepareStatement(selectSQL);

				ResultSet set = statement.executeQuery();

				while (set.next()) {
					int sum = set.getInt("sum");
					String stateName = set.getString("state_name");
					System.out.println("Population: " + sum
							+ " and State Name : " + stateName);
				}
				System.out.println("Query return successfully.");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	void list2() {
		Connection connection = new DBConnection().getConnection();
		if (connection != null) {
			try {
				String selectSQL = "select name from animal where  char_length(name) = (select max(char_length(name)) from animal) or char_length(name) =(select min(char_length(name)) from animal) order by char_length(name)";
				PreparedStatement statement = connection
						.prepareStatement(selectSQL);

				ResultSet set = statement.executeQuery();

				while (set.next()) {
					String name = set.getString("name");
					System.out.println("Name: " + name);
				}
				System.out.println("Query return successfully.");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	void list3() {
		Connection connection = new DBConnection().getConnection();
		if (connection != null) {
			try {
				String selectSQL = "select s.state_name, population, ca.category_name, sc.sub_category_name  from animal a, animal_details d, city c, state s, main_category m, category ca, sub_category sc where a.animal_id = d.animal_id and a.main_category_id = m.main_category_id and  d.city_id = c.city_id and c.state_id = s.state_id and m.category_id = ca.category_id and m.sub_category_id = sc.sub_category_id and ca.category_name = 'Endangered' and sc.sub_category_name = 'Reptiles' and population =  ( select max(population) from animal a, animal_details d, city c, state s, main_category m, category ca, sub_category sc where a.animal_id = d.animal_id and a.main_category_id = m.main_category_id and  d.city_id = c.city_id and c.state_id = s.state_id and m.category_id = ca.category_id and m.sub_category_id = sc.sub_category_id and ca.category_name = 'Endangered' and sc.sub_category_name = 'Reptiles' )";
				PreparedStatement statement = connection
						.prepareStatement(selectSQL);

				ResultSet set = statement.executeQuery();

				while (set.next()) {
					String stateName = set.getString("state_name");
					int population = set.getInt("population");
					String categoryName = set.getString("category_name");
					String subCategoryName = set.getString("sub_category_name");
					System.out.println("State Name: " + stateName
							+ " Population: " + population + " Category Name: "
							+ categoryName + " Sub Category Name"
							+ subCategoryName);
				}
				System.out.println("Query return successfully.");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	void list4() {
		Connection connection = new DBConnection().getConnection();
		if (connection != null) {
			try {
				String selectSQL = "select name, population from animal a, animal_details d, city c where a.animal_id = d.animal_id and d.city_id = c.city_id and c.city_name = 'Surat' and a.name = 'Harlen'";
				PreparedStatement statement = connection
						.prepareStatement(selectSQL);

				ResultSet set = statement.executeQuery();

				while (set.next()) {
					String name = set.getString("name");
					int population = set.getInt("population");
					System.out.println("Name: " + name + " Population: "
							+ population);
				}
				System.out.println("Query return successfully.");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	void list5() {
		Connection connection = new DBConnection().getConnection();
		if (connection != null) {
			try {
				String selectSQL = "select s.state_name, population from animal a, animal_details d, city c, state s, main_category m, category ca, sub_category sc where a.animal_id = d.animal_id and a.main_category_id = m.main_category_id and  d.city_id = c.city_id and c.state_id = s.state_id and m.category_id = ca.category_id and m.sub_category_id = sc.sub_category_id and ca.category_name = 'Critically Endangered' and sc.sub_category_name = 'Amphibians'";
				PreparedStatement statement = connection
						.prepareStatement(selectSQL);

				ResultSet set = statement.executeQuery();

				while (set.next()) {
					String stateName = set.getString("state_name");
					int population = set.getInt("population");
					System.out.println("Name: " + stateName + " Population: "
							+ population);
				}
				System.out.println("Query return successfully.");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
