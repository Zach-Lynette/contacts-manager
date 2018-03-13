package util;
import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    public String getString() {
        return scanner.nextLine();
    }
    public Boolean yesNo() {
        String check = scanner.next();
//        The yesNo method should return true if the user enters y, yes, or variants thereof, and false otherwise.
        return check.equalsIgnoreCase("Y") || check.startsWith("y") || check.startsWith("Y");
    }
    public int getInt(){
        try{
            return Integer.valueOf(scanner.nextLine());
        } catch(NumberFormatException e){
            System.out.print("Not an integer! Try again. ");
            return getInt();
        } catch(Exception e){
            System.out.print("Something went wrong! Try again. ");
            return getInt();
        }
    }
    public int getInt(String prompt){
        System.out.print(prompt);
        return getInt();
    }
    public int getInt(int min, int max) {
//    The getInt(int min, int max) method should keep prompting the user for input until they give an integer within the min and max.
        int check = getInt();
        if(check < min || check > max) {
        System.out.print("Please enter an integer between " + min + " and " + max + ": ");
            return getInt(min, max);
        } else {
            return check;
        }
    }
    public int getInt(int min, int max, String prompt) {
        System.out.println(prompt);
        return getInt(min, max);
    }
    public double getDouble(){
        try{
            return Double.valueOf(scanner.nextLine());
        } catch(NumberFormatException e){
            System.out.print("Not a real number! Try again. ");
            return getDouble();
        } catch(Exception e){
            System.out.print("Something went wrong! Try again. ");
            return getDouble();
        }
    }
    public double getDouble(String prompt){
        System.out.print(prompt);
        return getDouble();
    }
    public double getDouble(double min, double max) {
//    The getDouble method should do the same thing, but with decimal numbers.
        System.out.print("Please enter any real number between " + min + " and " + max + ": ");
        double check = getDouble();
        if(check < min || check > max) {
            return getDouble(min, max);
        } else {
            return check;
        }
    }
    public double getDouble(double min, double max, String prompt) {
        System.out.println(prompt);
        return getDouble(min, max);
    }
    //With PROMPT parameter
    public String getString(String prompt) {
        System.out.print(prompt);
        return getString();
    }
    public Boolean yesNo(String prompt) {
        System.out.print(prompt);
        return yesNo();
    }
    public int getBinary(){
        System.out.print("Enter a binary number: ");
        try{
            return Integer.valueOf(scanner.nextLine(), 2);
        } catch(NumberFormatException e){
            System.out.print("Not an binary number! Try again. ");
            return getBinary();
        } catch(Exception e){
            System.out.print("Something went wrong! Try again. ");
            return getBinary();
        }
    }
    public int getHex(){
        System.out.print("Enter a hexidecimal number: ");
        try{
            return Integer.valueOf(scanner.nextLine(), 16);
        } catch(NumberFormatException e){
            System.out.print("Not an hexidecimal number! Try again. ");
            return getHex();
        } catch(Exception e){
            System.out.print("Something went wrong! Try again. ");
            return getHex();
        }
    }
}