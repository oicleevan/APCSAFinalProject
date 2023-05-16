import java.util.*;

public class EmailUtils {
  public static String domain = "evan.gov.edu";
  public static ArrayList<EmailAccount> email_accounts = new ArrayList<>();

  private static Scanner in = new Scanner(System.in);
  
  public static void setup() {
    System.out.println("Welcome to the Email setup utility.");
    while(true) {
      System.out.print("Your name: ");
      String name = getValidName();

      System.out.print("Username: ");
      String username = getValidUsername();

      System.out.print("Password: ");
      String password = getValidPassword();
      
      System.out.print("Would you like a custom id number? [Y/N]: ");
      String t = getValidYNInput();

      EmailAccount e;
      if(t.equals("Y")) {
        System.out.print("Ok, what would you like your id number to be?: ");
        int id = getValidInt(1, Integer.MAX_VALUE);
        
        System.out.println("Ok, setting up your account now...");
        e = new EmailAccount(name, username, password, id);
      } else {
        System.out.println("Ok, setting up your account now...");
        e = new EmailAccount(name, username, password);
      }
      email_accounts.add(e);
      
      System.out.println("Your email account has been created.");
      e.printInfo();

      System.out.println("If you would like to create another account, type \'yes\'.\nOtherwise, the setup will conclude.");
      if(!in.nextLine().equals("yes")) break;
    }
    
    System.out.println("Thank you for choosing " + domain + "!");
  }

  public static EmailAccount accountExists(String username) {
    for(EmailAccount acc : email_accounts) {
      if(acc.getUsername().equals(username))
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
  
  public static int getValidInt(int min, int max) {
    String input = in.nextLine();
    int int_value = -1;
    
    try {
      int_value = Integer.parseInt(input); 
    } catch(NumberFormatException e) { }

    if((int_value >= min) && (int_value <= max)) {
      return int_value;
    }
    
    System.out.print("Please enter an number between " + min + " and " + max + ": ");
    return getValidInt(min, max);
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

    for(EmailAccount email : email_accounts) {
      if(email.getUsername().equals(input)) {
        System.out.print("Username already exists!\nPlease enter a new username: ");
        return getValidUsername();
      }
    }

    return input;
  }
  
  public static String getValidYNInput() {
    String input = in.nextLine().toUpperCase();
    if(input.equals("Y") || input.equals("N")) {
      return input;
    } else {
      System.out.print("Please enter Y or N: ");
      return getValidYNInput();
    }
  }

  public static boolean isNumeric(String string) {
    int value;
    if(string == null || string.equals("")) {
      return false;
    }

    try {
      value = Integer.parseInt(string);
      return true;
    } catch(Exception e) {}
    
    return false;
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
