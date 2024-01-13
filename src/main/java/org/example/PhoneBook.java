package org.example;

import org.example.services.MyContacts;
import java.util.List;
import java.util.Scanner;


public class PhoneBook {
    public static void main(String[] args) {
    MyContacts myContacts = new MyContacts();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Contacts: \n");
        boolean continueAdding = true;
        while (continueAdding) {
            System.out.println("1: Create new contact \n" +
                    "2: Search contacts \n3: Delete contact \n" +
                    "4: View all contacts \n" +
                    "5: Exit");
            System.out.print("Please select your choice: ");
            byte firstChoice = scanner.nextByte();

//      1: CREATE NEW CONTACT:
            if (firstChoice == 1) {
                System.out.print("Enter phone number: ");

                Scanner scanner1 = new Scanner(System.in);
                String numb = scanner1.nextLine();

                System.out.print("Enter contact name: ");
                String name = scanner1.nextLine();

//            input method to save contacts
                myContacts.addNumber(name, numb);


                // utilise the following next
                System.out.println("Contact saved! \nName: " + name + "\nNumber: " + numb);
                System.out.println("\n");
                System.out.println("1: Main Menu \n2: Quit");

                byte option = scanner1.nextByte();
                if (option == 1) {
                    continue;
                } else if (option == 2) {
                    return;
                }

//      2: SEARCH CONTACTS:
            } else if (firstChoice == 2) {
                System.out.print("Search for contact name: ");

                Scanner scanner1 = new Scanner(System.in);
                String contactName = scanner1.nextLine();
                System.out.println("Searching for " + contactName + ", please wait...");
                System.out.println("\n");

//            input method to search for contacts
                List<String> contactsNumber = myContacts.findNumber(contactName);
                System.out.println("Contact Details: \nName: " + contactName + "\nPhone number: " + contactsNumber);
                System.out.println("1: Main Menu \n2: Quit");

                byte option = scanner1.nextByte();
                if (option == 1) {
                    continue;
                } else if (option == 2) {
                    return;
                }

//      3: DELETE CONTACTS:
            } else if (firstChoice == 3) {
                System.out.print("Enter contact name: ");
                Scanner scanner1 = new Scanner(System.in);
                String contactToDelete = scanner1.nextLine();
                List<String> contactsNumber = myContacts.findNumber(contactToDelete);
                System.out.println("There are " + contactsNumber.size() +
                        " numbers saved under the name " +
                        contactToDelete + ": \n" + contactsNumber);
                System.out.println("1: Select number to delete \n2: Delete all");

//           3a: DELETE SINGLE PHONE NUMBER FROM CONTACT
                byte option = scanner1.nextByte();
                if (option == 1) {
                    System.out.print("Input number to delete: ");
                    Scanner scanner2 = new Scanner(System.in);
                    String numberToDelete = scanner2.nextLine();
                    System.out.println("Are you sure you want to delete " + numberToDelete + "?\n");
                    System.out.println("1: Yes \n2: No");
                    byte deleteChoice = scanner1.nextByte();
                    if (deleteChoice == 1) {
                        myContacts.deleteNumber(contactToDelete, numberToDelete);
                        System.out.println("Number deleted!");
                        System.out.println("1: Main Menu \n2: Quit");

                        byte returnOptions = scanner1.nextByte();
                        if (returnOptions == 1) {
                            continue;
                        } else if (returnOptions == 2) {
                            return;
                        }
                    } else if (deleteChoice == 2) {
                        System.out.println("Operation cancelled!");
                        continue;
                    }
                } else if (option == 2) {                       // 3b: DELETE THE CONTACT ITSELF
                    System.out.println("Are you sure you want to delete contact '" + contactToDelete + "'");
                    System.out.println("1: Yes \n2: No");
                    byte deleteChoice = scanner1.nextByte();
                    if (deleteChoice == 1) {
                        myContacts.deleteContact(contactToDelete);
                        System.out.println("Contact deleted!");
                        System.out.println("1: Main Menu \n2: Quit");
                        byte returnOptions = scanner1.nextByte();
                        if (returnOptions == 1) {
                            continue;
                        } else if (returnOptions == 2) {
                            return;
                        }

                    } else if (deleteChoice == 2) {
                        System.out.println("Operation cancelled!");
                        continue;

                    }
                }
            } else if (firstChoice == 4) {
                System.out.println("All Contacts");
                System.out.println("\n");
                System.out.println(myContacts);

            } else if (firstChoice == 5) {
                return;

            }

        }
    }
}
