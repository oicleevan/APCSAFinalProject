import java.util.Scanner;

class Main {
  static Scanner in = new Scanner(System.in);
  
  public static void main(String[] args) {
    EmailUtils.email_accounts = FileManagement.loadFromFile("data/save.txt");
    EmailAccount.updateSize();
    Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        FileManagement.saveObjectsToFile("data/save.txt", EmailUtils.email_accounts);
      }
    });

    clearScreen();
    startmenu();
  }

  public static void startmenu() {
    System.out.println("Welcome to " + EmailUtils.domain + "!");
    
    while(true) {
      System.out.println("What would you like to do? Note that to send or read emails, you must create an account beforehand." + 
                        "\n    1. Create new account(s)" + 
                        "\n    2. Send an email" +
                        "\n    3. Read your emails" +
                        "\n    4. Check number of accounts so far" +
                        "\n    5. List all existing accounts" + 
                        "\n    6. Quit");
      final int NUM_OPTIONS = 6;

      System.out.print("Input: ");
      int select = EmailUtils.getValidInt(1, NUM_OPTIONS);

      if(select == NUM_OPTIONS) {
        System.out.println("Exiting program. Thank you for choosing " + EmailUtils.domain + ".");
        break;
      }

      clearScreen();
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
        case 5:
          EmailUtils.printAllEmails(EmailUtils.email_accounts);
      }
    }
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");  
    System.out.flush();
  }

  public static EmailAccount login() {
    EmailAccount e = null;
    do {
      System.out.print("Enter email username (or q to quit): ");
      String user = in.nextLine();

      if(user.equals("q")) {
        System.out.println("Exiting...");
        return null;
      }
      
      e = EmailUtils.accountExists(user);  
      if(e == null) {
        System.out.println("Please enter a valid username (if your account does not exist, please create one from the menu)!");
      }
    } while(e == null);

    if(!passwordCorrect(e)) {
      return null;
    }

    return e;
  }

  public static boolean passwordCorrect(EmailAccount e) {
    for(int i = 3; i >= 0; i--) {
      System.out.print("Enter password: ");
      String pw = in.nextLine();

      if(pw.equals(e.getPassword())) {
        return true;
      } else {
        System.out.println("Incorrect password! You have " + i + " attempts remaining before the login will close.");
      }
    }

    return false;
  }
}
