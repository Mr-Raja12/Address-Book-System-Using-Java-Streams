package com.bridzelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

	public List manageContactDetails() {
        AddressBook book = new AddressBook();
        int option;
        do {
            System.out.println("Welcome to Address Book");
            Scanner input = new Scanner(System.in);
            System.out.println("1.Add contact details  2.print contact details  3.Edit contact details  4.Delete contact details");
            System.out.print("Select a option : ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.print("How many address book wants to create  : ");
                    int number = input.nextInt();
                    for (int i = 1; i <= number; i++) {
                        System.out.println("Enter " + i + " contact details : ");
                        book.addContactDetails();
                    }
                    break;
                case 2:
                    book.printContactDetails();
                    break;
                case 3:
                    book.editContactDetails();
                    break;
                case 4:
                    book.deleteContactDetails();
                    break;
                default:
                    System.out.println("Enter valid details");
                    break;
            }
            System.out.println("1.Don't Exit  2.Exit ");
            System.out.print("Enter the Choice : ");
            option = input.nextInt();

        } while (option == 1);
        return book.listOfContacts;
    }

}
