import java.util.*;

class Main {
  static Scanner in = new Scanner(System.in);
  
  public static void main(String[] args) {
    startmenu();
  }

  public static void startmenu() {
    System.out.println("Welcome to " + EmailUtils.domain + "!");
    
    while(true) {
      System.out.println("What would you like to do?" + 
                        "\n    1. Create new account(s)" + 
                        "\n    2. Send an email" +
                        "\n    3. Read your emails" +
                        "\n    4. Check number of accounts so far" +
                        "\n    5. Quit");
      final int NUM_OPTIONS = 5;
      
      String input = "";
      int select = -1;
      do {
        System.out.print("Input: ");
        input = in.nextLine();

        if(EmailUtils.isNumeric(input)) {
          select = Integer.parseInt(input);
        }
  
        if(select < 1 || select > NUM_OPTIONS) {
          System.out.println("Please select a proper input!");
        }
      } while(select < 1 || select > NUM_OPTIONS);

      if(select == NUM_OPTIONS) {
        System.out.println("Exiting program. Thank you for choosing " + EmailUtils.domain + ".");
        break;
      }

      EmailAccount user;
      
      switch(select) {
        case 1:
          EmailUtils.setup();
          break;
        case 2:
          user = login();
          if(user == null) {
            System.out.println("Failed to login. Please select again and re-login.");
          } else {
            user.sendEmail();
          }
          break;
        case 3:
          user = login();
          if(user == null) {
            System.out.println("Failed to login. Please select again and re-login.");
          } else {
            user.readEmails();
          }
          break;
        case 4:
          System.out.println("There are " + EmailAccount.getNumAccounts() + " accounts created so far.");
          break;
      }
    }
  }

  public static EmailAccount login() {
    EmailAccount e = null;
    
    String user = "";
    do {
      System.out.print("Enter email username (or q to quit): ");
      user = in.nextLine();

      if(user.equals("q")) {
        System.out.println("Exiting...");
        return null;
      }
      
      e = EmailUtils.accountExists(user);  
      if(e == null) {
        System.out.println("Please enter a valid username (if your account does not exist, please create one from the menu)!");
      }
    } while(e == null);

    boolean password_correct = false;
    String pw = "";
    for(int i = 3; i >= 0; i--) {
      System.out.print("Enter password: ");
      pw = in.nextLine();

      if(pw.equals(e.getPassword())) {
        password_correct = true;
        break;
      } else {
        System.out.println("Incorrect password! You have " + i + " attempts remaining before the login will close.");
      }
    }

    if(!password_correct) {
      return null;
    }

    return e;
  }
}
