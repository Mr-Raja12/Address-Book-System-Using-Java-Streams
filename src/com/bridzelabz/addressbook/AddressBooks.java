package com.bridzelabz.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Raja
 *
 */

public class AddressBooks {
	/**
	 * Hash map to provide multiple details of address bokk
	 */
	HashMap<String, List> books = new HashMap<>();
	AddressBookMain main = new AddressBookMain();
	Scanner input = new Scanner(System.in);

	public void addressBooksAdd() {
		/**
		 * To store unique person first name details
		 */
		int number = 1;
		while (number == 1) {
			System.out.println("1.Add Address Book");
			System.out.println("2.Exit Address book system");
			System.out.println();
			System.out.print("Enter choice : ");
			number = input.nextInt();
			if (number == 1) {
				System.out.print("Enter address book name : ");
				String name = input.next();
				if (books.containsKey(name) == false) {
					books.put(name, main.manageContactDetails());

				} else {
					System.out.println(name + " book is already exits");
				}
			} else {
				break;
			}
		}
		System.out.println(books);
		System.out.println("1.Search in city");
		System.out.println("2.Search in state");
		System.out.println("3.Search person");
		System.out.println("4.Number of persons in city");
		System.out.println("5.Number of persons in state");
		System.out.println("6.Exit");
		System.out.println();
		System.out.print("Enter option : ");
		int option = input.nextInt();
		while (option != 6) {
			switch (option) {
			case 1:
				System.out.print("Enter city name : ");
				String cityName = input.next();
				for (List contact : books.values()) {
					List<ContactDetails> list = contact;
					list.stream().filter(city -> city.getCity().equalsIgnoreCase(cityName))
							.forEach(x -> System.out.println(x));
				}
				break;
			case 2:
				System.out.print("Enter State name : ");
				String stateName = input.next();
				for (List contact : books.values()) {
					List<ContactDetails> list = contact;
					list.stream().filter(state -> state.getState().equalsIgnoreCase(stateName))
							.forEach(x -> System.out.println(x));
				}
				break;
			case 3:
				System.out.print("Enter person first name : ");
				String firstName = input.next();
				for (List contact : books.values()) {
					List<ContactDetails> list = contact;
					list.stream().filter(name -> name.getFirstName().equalsIgnoreCase(firstName))
							.forEach(x -> System.out.println(x));
				}
				break;
			case 4:
				System.out.print("Enter city name : ");
				String cityPersons = input.next();
				List<ContactDetails> listSizeInCity = new ArrayList<>();
				for (List contact : books.values()) {
					List<ContactDetails> list = contact;
					list.stream().filter(city -> city.getCity().equalsIgnoreCase(cityPersons))
							.forEach(x -> listSizeInCity.add(x));
				}
				System.out.println("Number of persons in city : " + listSizeInCity.size());
				break;
			case 5:
				System.out.print("Enter state name : ");
				String statePersons = input.next();
				List<ContactDetails> listSizeInState = new ArrayList<>();
				for (List contact : books.values()) {
					List<ContactDetails> list = contact;
					list.stream().filter(state -> state.getState().equalsIgnoreCase(statePersons))
							.forEach(x -> listSizeInState.add(x));
				}
				System.out.println("Number of persons in state : " + listSizeInState.size());
				break;
			default:
				System.out.println("Enter correct value");

			}
			System.out.println("1.Search in city");
			System.out.println("2.Search in state");
			System.out.println("3.Search person");
			System.out.println("4.Number of persons in city");
			System.out.println("5.Number of persons in state");
			System.out.println("6.Exit");
			System.out.print("Enter option : ");
			option = input.nextInt();
		}
	}

	public static void main(String[] args) {
		AddressBooks books = new AddressBooks();
		books.addressBooksAdd();
	}

}