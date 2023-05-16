import java.util.Scanner;

public class EmailAdmin extends EmailAccount {
  private static String admin_password = "admin";

  private int admin_id;
  private static int num_admins;

  public EmailAdmin(String name, String username, String password) {
    super(name, username, password);
    num_admins++;
    this.admin_id = num_admins;
  }

  public EmailAccount deleteAccount(String username) { // will return email removed, if needed for whatever reason
    EmailAccount email = EmailUtils.accountExists(username);
    if(email == null) {
      System.out.println("An email account does not exist with this username.");
      return email; // aka null
    }

    EmailUtils.email_accounts.remove(email);
    return email;
  }

  public void changeAccountPassword(String username, String password) {
    EmailAccount email = EmailUtils.accountExists(username);
    if(email == null) {
      System.out.println("An email account does not exist with this username.");
      return;
    }

    email.setPassword(password);
  }

  public static boolean checkAdminValid() {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter admin password: ");
    String input = in.nextLine();

    boolean correct = input.equals(admin_password);
    if(correct) {
      System.out.println("Thank you.");
    } else {
      System.out.println("Incorrect.");
    }
    return correct; 
  }
  
  public void printInfo() {
    super.printInfo();
    System.out.println("This account is an admin (#" + admin_id + ").");
  }
}
