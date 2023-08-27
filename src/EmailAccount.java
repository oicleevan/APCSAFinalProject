import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class EmailAccount implements Serializable {
  private static final long serialVersionUID = 1L;

  transient static Scanner in = new Scanner(System.in);
  
  private String name;
  private String email_address;
  private String password;

  private static int num_accounts;

  private ArrayList<Email> emails;

  public EmailAccount(String name, String username, String pw) {
    this.name = name;
    this.email_address = username;
    this.password = pw;
    emails = new ArrayList<Email>();
    EmailUtils.email_accounts.add(this);
    updateSize();
    this.receiveEmail(new Email("This is a test message to show that the email system works!", this));
    Logging.info("New email account created, " + this);
  }

  public String getName() { return this.name; }
  public String getUsername() { return this.email_address; }
  public static int getNumAccounts() { return num_accounts; }

  public void setPassword(String pw) {
    this.password = pw;
  }

  final int NUM_OPTIONS = 5;

  public void menu() {
    while(true) {
      int options = this.options();

      if(options == NUM_OPTIONS)
        break;

      switch(options) {
        case 1:
          this.sendEmail();
          break;
        case 2:
          this.readEmails();
          break;
        case 3:
          System.out.println("There are " + EmailAccount.getNumAccounts() + " accounts created so far.");
          break;
        case 4:
          EmailUtils.printAllEmails(EmailUtils.email_accounts);
          break;
      }
    }
  }

  public int options() {
    System.out.println("Welcome, " + name + ".\n" +
                        "What would you like to do?\n" +
                        "    1. Send an email\n" +
                        "    2. Read your emails\n" +
                        "    3. Check number of accounts so far\n" +
                        "    4. List all available accounts\n" +
                        "    5. Logout");
    System.out.print("Input: ");

    return EmailUtils.getValidInt(1, NUM_OPTIONS);
  }

  public void sendEmail() {
    System.out.println("What is the username of the person you would like to send this email to?");
    EmailAccount recipient = null;
    do {
      System.out.print("Username: ");
      String recipient_user = in.nextLine();
      recipient = EmailUtils.accountExists(recipient_user);
  
      if(recipient == null) {
        System.out.println("Please enter a valid username!");
      }
    } while(recipient == null);

    System.out.println("What is the message you would like to send?");
    String message = in.nextLine();
    
    System.out.println("Ok, sending message to " + recipient.getName());
    Email email = new Email(message, this);
    recipient.receiveEmail(email);
    Logging.info("Email sent from " + this + " to " + recipient);

    System.out.println("Sent.");
    System.out.println(email);
    
    return;
  }

  public void receiveEmail(Email e) {
    emails.add(e);
  }

  public void readEmails() {
    System.out.println("You have " + emails.size() + " email(s).");
    
    if(emails.size() == 0) return;
    int i = 1;
    for(Email email : emails) {
      System.out.println("    Email #" + i + ": " + email.msgPreview() + ""); 
      i++;
    }

    while(true) {
      System.out.print("Select an email to read: ");
      
      System.out.println(
        emails.get(
          EmailUtils.getValidInt(1, (emails.size())) - 1
        )
      );

      System.out.println("\nWould you like to read another email?");
      System.out.print("Type yes, otherwise it will quit. ");
      if(!in.nextLine().equals("yes")) break;
    }
  }
  
  public boolean checkPassword(String string) {
    return string.equals(password);
  }

  public static void updateSize() {
    num_accounts = EmailUtils.email_accounts.size();
  }

  public void printInfo() {
    System.out.println("Name: " + name + 
                      "\nEmail address: " + email_address);
  }
  
  public String toString() {
    return this.email_address + "@" + EmailUtils.domain;
  }
}
