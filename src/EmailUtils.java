import java.util.ArrayList;
import java.util.Scanner;

public class EmailUtils {
  public static String domain = "evan.gov.edu";

  private static Scanner in = new Scanner(System.in);
  public static ArrayList<EmailAccount> email_accounts;
  
  public static EmailAccount setup() {
    System.out.println("Welcome to the Email setup utility.");
    System.out.print("Your account's username: ");
    String username = getValidUsername();

    System.out.print("Your name: ");
    String name = getValidName();

    System.out.print("Password: ");
    String password = getValidPassword();

    return new EmailAccount(name, username, password);
  }

  public static void printAllEmails(ArrayList<EmailAccount> emails) {
    System.out.println("All existing emails: ");
    for(EmailAccount e : emails) {
      System.out.println("    " + e.getName() + " (" + e + ")");
    }
    System.out.println();
  }

  public static EmailAccount accountExists(String username) {
    for(EmailAccount acc : email_accounts) {
      if(acc.getUsername().equals(username.toLowerCase()))
        return acc;
    }

    return null;
  }

  public static boolean checkPassword(String pw, int it) {
    String input = in.nextLine();
    if(!input.equals(pw)) {
      if(it > 0) return false;
      
      System.out.print("Passwords do not match." + 
                       "\nOne more try: ");
      return checkPassword(pw, it+1);
    }

    return true;
  }
  
  public static int getValidInt(int from, int to) {
    String input = in.nextLine();
    int int_value = -1;
    
    try {
      int_value = Integer.parseInt(input); 
    } catch(NumberFormatException e) { }

    if((int_value >= from) && (int_value <= to)) {
      return int_value;
    }
    
    System.out.print("Please enter a number from " + from + " to " + to + ": ");
    return getValidInt(from, to);
  }

  public static String getValidName() {
    String input = in.nextLine();
    if(input.equals("") || input.equals(" ")) {
      System.out.print("Please add your name: ");
      return getValidName();
    } else {
      return input;
    }
  }

  public static String getValidPassword() {
    String input = in.nextLine();
    if(!stringHasNoSpaces(input)) {
      System.out.print("Please enter a password without spaces: ");
      return getValidPassword();
    }

    System.out.print("Confirm password: ");
    if(!checkPassword(input, 0)) {
      System.out.println("Failed to confirm, please re-enter your password: ");
      return getValidPassword();
    }
    
    return input;
  }
  
  public static String getValidUsername() {
    String input = in.nextLine();
    
    if(!stringHasNoSpaces(input)) {
      System.out.print("Please enter a valid string: ");
      return getValidUsername();
    }

    if(accountExists(input) != null) {
      System.out.print("Username already exists!\nPlease enter a new username: ");
      return getValidUsername();
    }

    return input;
  }
  
  public static boolean stringHasNoSpaces(String string) {
    for(int i = 0; i < string.length() - 1; i++) {
      if(string.substring(i, i+1).equals(" ")) {
        return false;
      }
    }

    return true;
  }
}
