package ToDo_Maven.Hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		Record r = new Record();
		// variable to store user's choice of operations.
		int choice = 0;

		// method that displays original greeting
		Menu.mainMenuWelcome(args);

		// loop to keep menu running
		do {
			// displaying available options
			Menu.menuNextRound(args);
			// scanning user input
			Scanner input = new Scanner(System.in);

			// storing input into a variable
			choice = input.nextInt();

			System.out.println("You choice is : " + choice);
			System.out.println("Please hit ENTER to continue...");

			// performing operation based on the choice
			if (choice == 1) {

				System.out.println("Displaying your to-do list: ");
				try {
					displayTable();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Please let me know if there is anything else you would like to do:");
			} else if (choice == 2) {

				try {
					addToDB(r);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Task was added to database as requested");
				System.out.println("\n");
				System.out.println("Please let me know if there is anything else you would like to do:");
			} else if (choice == 3) {

				try {
					removeFromDB(r);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Your list have been updated");
				System.out.println("\n");
				System.out.println("Please let me know if there is anything else you would like to do:");
			} else if (choice == 4) {
				System.out.println("\n");
				System.out.println("EXIT");
				System.out.println("Thank You and Good Bye");
				break;
			} else {
				System.out.println("\n");
				System.out.println("Please check your input and try again");

			}

		} while (choice != 4);

	}

	private static int removeFromDB(Record r) {

		Scanner input = new Scanner(System.in);

		do {

			String task = input.nextLine();
			System.out.println("Please type in the task You would like to remove HERE: ");

			r.setId(Record.id--);

			if ((input.next() == Record.task)) {
				r.setTask(null);
			} else {
				System.out.println("Task was not found. Please try again");
			}
		} while (!(input.next() == Record.task));

		System.out.println("Task " + Record.task + "was successfully removed from Your to-do list");

		System.out.println("Task was successfully added to Your to-do list");

		Configuration con = new Configuration().configure().addAnnotatedClass(Record.class);
		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(r);

		return Record.id;
	}

	private static void displayTable() {
		Configuration con = new Configuration().configure().addAnnotatedClass(Record.class);
		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = null;

		tx = session.beginTransaction();
		List Tasks = session.createQuery("FROM Record").list();
		for (Iterator iterator1 = Tasks.iterator(); iterator1.hasNext();) {
			Record record = (Record) iterator1.next();
			System.out.print("ID: " + Record.getId());
			System.out.print(" Task: " + Record.getTask());
		}

		tx.commit();
		session.close();

	}

	private static int addToDB(Record r) {

		Scanner input = new Scanner(System.in);

		String task = input.nextLine();
		System.out.println("Please type in the task You would like to add HERE: ");
		r.setId(Record.id++);
		r.setTask(input.next());

		System.out.println("Task " + Record.task + " was successfully added to Your to-do list");

		Configuration con = new Configuration().configure().addAnnotatedClass(Record.class);
		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(r);

		return Record.id;

	}

}
