import java.io.Serializable;

public class Email implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private String message;
  private EmailAccount sender;
  
  public Email(String message, EmailAccount sender) {
    this.message = message;
    this.sender = sender;
  }

  public String msgPreview() {
    String[] arr = message.split("\\s+");

    int num_words;
    if(arr.length < 3) {
      num_words = arr.length;
    } else {
      num_words = 3;
    }
    
    String preview = "";
    for(int i = 0; i < num_words; i++) {
      preview += (arr[i]) + " ";
    }
    preview += "...";
    return preview;
  }

  public String toString() {
    return 
      "From: " + sender.getName() + " (" + sender + ")" +
      "\nMessage:\n    " + message;
  }
}