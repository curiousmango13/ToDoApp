package ToDo_Maven.Hibernate;

public class Menu {
	// method displaying an original greeting
	public static void mainMenuWelcome(String[] args) {
		System.out.println("\nHello! \nThis is a MAIN MENU");
		System.out.println("*********************************************");
		System.out.println("Please let me know what would you like to do:");

	}

	// method displaying available operations
	public static void menuNextRound(String[] args) {

		System.out.println("\n");
		// System.out.println("Please let me know if there is anything else you would
		// like to do:");
		System.out.println("1: Display Your To-Do List");
		System.out.println("2: Add New Task");
		System.out.println("3: Remove task from the list");
		System.out.println("4: Exit");
		System.out.println("\n");
		System.out.print("Please enter 1-4: ");
	}
}
