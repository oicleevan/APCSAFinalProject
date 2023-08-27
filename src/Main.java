import java.util.Scanner;

class Main {
  static Scanner in = new Scanner(System.in);
  static EmailAccount loggedIn = null;
  
  public static void main(String[] args) {
    EmailUtils.email_accounts = FileManagement.loadFromFile("data/save.txt"); // loads account data from file
    EmailAccount.updateSize();
    Runtime.getRuntime().addShutdownHook(new Thread() { // saves when program quits
      public void run() {
        FileManagement.saveObjectsToFile("data/save.txt", EmailUtils.email_accounts);
      }
    });

    clearScreen();

    startup();
  }

  public static void startup() {
    System.out.println("Welcome to " + EmailUtils.domain + "!");
    System.out.println("What would you like to do?");

    while(loggedIn == null) {
      System.out.println("    1. Create a new account"
                      + "\n    2. Log into existing account"
                      + "\n    3. Quit");
      
      System.out.print("Input: ");
      int input = EmailUtils.getValidInt(1, 3);

      if(input == 3) {
        System.out.println("Exiting program. Thank you for choosing " + EmailUtils.domain + ".");
        Logging.info("application closed");
        return;
      }

      switch(input) {
        case 1:
          loggedIn = EmailUtils.setup();
          break;
        case 2:
          loggedIn = login();
          break;
      }

      System.out.println("You are now logged in as " + loggedIn + ".");
      loggedIn.menu();

      loggedIn = null;
      System.out.println("\nAnything else?");
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
      Logging.info("someone attempted to log into" + e + " but failed the password check");
      return null;
    }

    Logging.info(e + " logged in");
    return e;
  }

  public static boolean passwordCorrect(EmailAccount e) {
    for(int i = 3; i > 0; i--) {
      System.out.println("You have " + i + " attempts remaining before the login will close.");
      System.out.print("Enter password: ");
      String pw = in.nextLine();

      if(e.checkPassword(pw)) {
        return true;
      } else {
        System.out.print("Incorrect password! ");
      }
    }
    System.out.println();
    return false;
  }
}
