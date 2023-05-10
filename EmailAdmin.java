public class EmailAdmin extends EmailAccount {
  private String admin_password = "admin";

  private int admin_id;
  private static int num_admins;

  public EmailAdmin(String name, String username, String password, int id) {
    super(name, username, password, id);
    num_admins++;
    admin_id = getNumAccounts();
  }

  public EmailAdmin(String name, String username, String password) {
    super(name, username, password);
    num_admins++;
    admin_id = getNumAccounts();
  }

  public int getAdminId() { return this.admin_id; }
  
  public void printInfo() {
    super.printInfo();
    System.out.println("Admin ID: " + admin_id);
  }
}
