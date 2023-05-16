import java.util.*;

public class EmailAccount {
  static Scanner in = new Scanner(System.in);
  
  private String name;
  private String email_address;
  private String password;
  private int id;

  private static int num_accounts;

  private ArrayList<Email> emails;
  
  public EmailAccount(String name, String username, String pw, int id) {
    this.name = name;
    this.email_address = username;
    this.password = pw;
    this.id = id;
    num_accounts++;
    emails = new ArrayList<Email>();
  }

  public EmailAccount(String name, String username, String pw) {
    this.name = name;
    this.email_address = username;
    this.password = pw;
    num_accounts++;
    this.id = num_accounts;
    emails = new ArrayList<Email>();
  }

  public String getName() { return this.name; }
  public String getUsername() { return this.email_address; }
  public int getId() { return this.id; }
  public String getPassword() { return this.password; }
  public static int getNumAccounts() { return num_accounts; }

  public void sendEmail() {
    System.out.println("What is the username of the person you would like to send this email to?");
    EmailAccount recipient = null;
    do {
      System.out.print("Username: ");
      String recipiant_user = in.nextLine();
      recipient = EmailUtils.accountExists(recipiant_user);
  
      if(recipient == null) {
        System.out.println("Please enter a valid username!");
      }
    } while(recipient == null);

    System.out.println("What is the message you would like to send?");
    String message = in.nextLine();
    
    System.out.println("Ok, sending message from to" + recipient.getName());
    Email email = new Email(message, this);
    recipient.receiveEmail(email);
    
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
      System.out.println("Email #" + i + ": " + email.msgPreview() + ""); 
      i++;
    }

    while(true) {
      System.out.print("Select an email to read: ");
      
      System.out.println(
        emails.get(
          (EmailUtils.getValidInt(1, (emails.size())) - 1
        )
      ));

      System.out.println("\nWould you like to read another email?");
      System.out.print("Type yes, otherwise it will quit. ");
      if(!in.nextLine().equals("yes")) break;
    }
  }
  
  public void printInfo() {
    System.out.println("Name: " + name + 
                      "\nEmail address: " + email_address + 
                      "\nID: " + id);
  }
  
  public String toString() {
    return this.email_address + "@" + EmailUtils.domain;
  }
}
