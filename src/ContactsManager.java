import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import util.FileHelper;

public class ContactsManager {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
//        addContact();
//        viewContacts();
//        searchContact();
        deleteContact();
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
        List<String> list = FileHelper.slurp("contacts.txt");
        for (int i = 0; i < list.size(); i += 1) {
            System.out.println(list.get(i));
        }
    }
    public static void addContact(){
        System.out.println("Please enter the contact name:");
        String name = scan.nextLine();
        System.out.println("Please enter the 10-digit contact phone number:");
        String phoneNumber = scan.nextLine();
        List<String> contact = Arrays.asList(name + " | " + phoneNumber);
        FileHelper.spit("contacts.txt", contact, true);
    }
    public static void searchContact(){
        System.out.println("Enter contact name to search:");
        String name = scan.nextLine();
        System.out.println("  Name  | Phone number");
        System.out.println("-----------------------");
        for (String line: FileHelper.slurp("contacts.txt")){
            if (line.toLowerCase().contains(name.toLowerCase())){
                System.out.println(line);
            }
        }

    }
    public static void deleteContact(){
        List <String> searchResults = new ArrayList<>();
        List<String> newList = new ArrayList<>();
        System.out.println("Enter contact name to delete:");
        String name = scan.nextLine();
        List<String> list = FileHelper.slurp("contacts.txt");
        for (int i = 0; i < list.size(); i += 1) {
            if (list.get(i).toLowerCase().contains(name.toLowerCase())) {
                searchResults.add(list.get(i));
            }
        }
        if(searchResults.size() == 1){
            for (int i = 0; i < list.size(); i += 1) {
                if (list.get(i).toLowerCase().contains(name.toLowerCase())) {
                    continue;
                }
                newList.add(list.get(i));
            }
            FileHelper.spit("contacts.txt", newList);
        }
//        System.out.println("  Name  | Phone number");
//        System.out.println("-----------------------");

    }



}
