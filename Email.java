public class Email {
  private String message;
  private EmailAccount sender;
  private EmailAccount recipient;
  
  public Email(String message, EmailAccount sender) {
    this.message = message;
    this.sender = sender;
  }

  public String msgPreview() {
    String[] arr = message.split("\\s+");
    int num_words = 3;

    String preview = "";
    for(int i = 0; i < num_words; i++) {
      preview += (arr[i] + " ");
    }
    preview += "...";
    return preview;
  }
  
  public String toString() {
    String formatted = "From: " + sender.getName() + " (" + sender + ")" +
      "\nMessage:\n    " + message;
    return formatted;
  }
}