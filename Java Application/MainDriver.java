import java.util.Scanner;

class MainClass {

	void animal(Animal a) {
		Scanner sc = new Scanner(System.in);
		System.out
				.println("----------------------------------------------------------------------------------------------");
		System.out.println("1.Insert");
		System.out.println("2.Update");
		System.out.println("3.Delete");
		System.out.println("4.Exit");
		System.out.println("\nWhich Action You want to Perform?(1-4)");
		System.out
				.println("----------------------------------------------------------------------------------------------");
		int action_choice = sc.nextInt();

		switch (action_choice) {
		case 1:
			a.insert();
			break;
		case 2:
			a.update();
			break;
		case 3:
			a.delete();
			break;
		case 4:
			break;
		default:
			System.out.println("Wrong Choice");
		}
	}

	void animalDetails(AnimalDetails ad) {
		Scanner sc = new Scanner(System.in);
		System.out
				.println("----------------------------------------------------------------------------------------------");
		System.out.println("1.Insert");
		System.out.println("2.Update");
		System.out.println("3.Delete");
		System.out.println("4.Exit");
		System.out.println("\nWhich Action You want to Perform?(1-4)");
		System.out
				.println("----------------------------------------------------------------------------------------------");
		int action_choice = sc.nextInt();

		switch (action_choice) {
		case 1:
			ad.insert();
			break;
		case 2:
			ad.update();
			break;
		case 3:
			ad.delete();
			break;
		case 4:
			break;
		default:
			System.out.println("Wrong Choice");
		}
	}

	void state(State s) {
		Scanner sc = new Scanner(System.in);
		System.out
				.println("----------------------------------------------------------------------------------------------");
		System.out.println("1.Insert");
		System.out.println("2.Update");
		System.out.println("3.Delete");
		System.out.println("4.Exit");
		System.out.println("\nWhich Action You want to Perform?(1-4)");
		System.out
				.println("----------------------------------------------------------------------------------------------");
		int action_choice = sc.nextInt();

		switch (action_choice) {
		case 1:
			s.insert();
			break;
		case 2:
			s.update();
			break;
		case 3:
			s.delete();
			break;
		case 4:
			break;
		default:
			System.out.println("Wrong Choice");
		}
	}

	void city(City c) {
		Scanner sc = new Scanner(System.in);
		System.out
				.println("----------------------------------------------------------------------------------------------");
		System.out.println("1.Insert");
		System.out.println("2.Update");
		System.out.println("3.Delete");
		System.out.println("4.Exit");
		System.out.println("\nWhich Action You want to Perform?(1-4)");
		System.out
				.println("----------------------------------------------------------------------------------------------");
		int action_choice = sc.nextInt();

		switch (action_choice) {
		case 1:
			c.insert();
			break;
		case 2:
			c.update();
			break;
		case 3:
			c.delete();
			break;
		case 4:
			break;
		default:
			System.out.println("Wrong Choice");
		}
	}

	void category(Category cat) {
		Scanner sc = new Scanner(System.in);
		System.out
				.println("----------------------------------------------------------------------------------------------");
		System.out.println("1.Insert");
		System.out.println("2.Update");
		System.out.println("3.Delete");
		System.out.println("4.Exit");
		System.out.println("\nWhich Action You want to Perform?(1-4)");
		System.out
				.println("----------------------------------------------------------------------------------------------");
		int action_choice = sc.nextInt();

		switch (action_choice) {
		case 1:
			cat.insert();
			break;
		case 2:
			cat.update();
			break;
		case 3:
			cat.delete();
			break;
		case 4:
			break;
		default:
			System.out.println("Wrong Choice");
		}
	}

	void subCategory(SubCategory scat) {
		Scanner sc = new Scanner(System.in);
		System.out
				.println("----------------------------------------------------------------------------------------------");
		System.out.println("1.Insert");
		System.out.println("2.Update");
		System.out.println("3.Delete");
		System.out.println("4.Exit");
		System.out.println("\nWhich Action You want to Perform?(1-4)");
		System.out
				.println("----------------------------------------------------------------------------------------------");
		int action_choice = sc.nextInt();

		switch (action_choice) {
		case 1:
			scat.insert();
			break;
		case 2:
			scat.update();
			break;
		case 3:
			scat.delete();
			break;
		case 4:
			break;
		default:
			System.out.println("Wrong Choice");
		}
	}
	
	void complexQueries(){
		Scanner sc = new Scanner(System.in);
		System.out
		.println("----------------------------------------------------------------------------------------------");
		System.out.println("1. List all the states in which the population of 'Invertebrates' is more than all the states of south india.(sc)");
		System.out.println("2. Name all the animals whose name length is minimum of all or maximum of all.(c)");
		System.out.println("3. Find the name of the state having highest Endangered Reptiles.(c)");
		System.out.println("4. Find the population of 'Harlen' bird in Surat.");
		System.out.println("5. Find the population of Critically Endangered Amphibians in all the states.(c)");
		System.out.println("6. Exit.");
		System.out
		.println("----------------------------------------------------------------------------------------------");
		System.out.println("Enter Choice: ");
		int ch = sc.nextInt();
		ComplexQueries cq = new ComplexQueries();
		
		switch(ch){
			case 1:
				cq.list1();
				break;
			case 2:
				cq.list2();
				break;
			case 3:
				cq.list3();
				break;
			case 4:
				cq.list4();
				break;
			case 5:
				cq.list5();
				break;
			default:
				System.out.println("Wrong Choice.");
				break;
			
		}
		
	}
}

public class MainDriver {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out
				.println("----------------------------------------------------------------------------------------------");
		System.out
				.println("                         Welcome To The Animal Repositery System                              ");
		System.out
				.println("----------------------------------------------------------------------------------------------");
		while (true) {
			System.out.println("\nList Of tables:-");
			System.out.println("1.Animal");
			System.out.println("2.Category");
			System.out.println("3.Sub_Category");
			System.out.println("4.Animal_details");
			System.out.println("5.State");
			System.out.println("6.City");
			System.out.println("7.Complex Queries");
			System.out.println("8.Exit");
			System.out.println("Enter your Choice(1-8)");

			int table_choice = sc.nextInt();
			MainClass mc = new MainClass();
			switch (table_choice) {
			case 1:
				Animal a = new Animal();				
				mc.animal(a);
				break;
			case 2:
				Category c = new Category();
				mc.category(c);
				break;
			case 3:
				SubCategory scat = new SubCategory();
				mc.subCategory(scat);
				break;
			case 4:
				AnimalDetails ad = new AnimalDetails();
				mc.animalDetails(ad);
				break;
			case 5:
				State s = new State();
				mc.state(s);
				break;
			case 6:
				City cit = new City();
				mc.city(cit);
				break;
			case 7:
				mc.complexQueries();
				break;
			case 8:
				System.exit(0);
				break;

			default:
				System.out.println("Wrong Choice!!");
				;
			}
		}

	} // end of While loop

}