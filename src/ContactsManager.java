import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import util.FileHelper;
import util.Input;

public class ContactsManager {
    public static Scanner scan = new Scanner(System.in);
    private static Input input = new Input();
    public static void main(String[] args) {
            int option;
        do {
            System.out.println("----------------------------------------");
            System.out.println("Contact Manager");
            System.out.println("----------------------------------------");
            System.out.println("1. View contact list");
            System.out.println("2. Add a new contact");
            System.out.println("3. Search a contact by name");
            System.out.println("4. Delete an existing contact");
            System.out.println("5. Exit");
            System.out.println("Enter an option:");
            option = input.getInt(1, 5);
            switch (option){
                case 1:
                    viewContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        while(option != 5);
    }

    public static void viewContacts(){
        System.out.println("          Name  | Phone number");
        System.out.println("---------------------------------------");
        List<String> list = FileHelper.slurp("contacts.txt");
        for (int i = 0; i < list.size(); i += 1) {
            System.out.println(list.get(i));
        }
    }
    public static void addContact(){
        System.out.println("Please enter the contact name:");
        String name = scan.nextLine();
        System.out.println("Please enter the contact phone-number:");
        String phoneNumber = scan.nextLine();
        if (phoneNumber.length() == 7){
            phoneNumber= phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3);
        }else if (phoneNumber.length() == 10){
            phoneNumber = "(" +phoneNumber.substring(0,3) + ") " + phoneNumber.substring(3,6) + "-" + phoneNumber.substring(6);
        }
        List<String> contact = Arrays.asList(String.format("%15s | %13s", name, phoneNumber));
        FileHelper.spit("contacts.txt", contact, true);
    }
    public static void searchContact(){
        System.out.println("Enter contact name to search:");
        String name = scan.nextLine();
        System.out.println("  Name  | Phone number");
        System.out.println("-----------------------");
        int count = 0;
        for (String line: FileHelper.slurp("contacts.txt")){
            if (line.toLowerCase().contains(name.toLowerCase())){
                System.out.println(line);
                count++;
            }
        }
        if (count == 0){
            System.out.println("Sorry, that contact does not exist.");
            System.out.println("Would you like to add contact?");
            if (input.yesNo()){
                addContact();
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
            addToList(list, newList, name);
        }else if (searchResults.size() > 1){
            System.out.println(searchResults);
            System.out.println("Please be more specific...");
            name = scan.nextLine();
            addToList(list, newList, name);
        } else {
            System.out.println("No contact by that name.");
            newList = list;
        }
        FileHelper.spit("contacts.txt", newList);
    }

    public static void addToList(List<String> oldList, List<String> newList, String name){
        for (int i = 0; i < oldList.size(); i += 1) {
            if (oldList.get(i).toLowerCase().contains(name.toLowerCase())) {
                continue;
            }
            newList.add(oldList.get(i));
        }
    }
}
