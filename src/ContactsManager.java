import java.util.Scanner;
import util.FileHelper;

public class ContactsManager {
    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        viewContacts();
//        do {
//            System.out.println("1. View contact");
//            System.out.println("2. Add a new contact.");
//            System.out.println("3. Search a contact by name");
//            System.out.println("4. Delete an existing contact.");
//            System.out.println("5. Exit");
//            System.out.println("Enter an option (1, 2, 3, 4 or 5):");
//
//
//        }
//        while(){};
    }

    public static void viewContacts(){
        System.out.println("  Name  | Phone number");
        System.out.println("-----------------------");
        FileHelper.slurp("contacts.txt");
    }



}
