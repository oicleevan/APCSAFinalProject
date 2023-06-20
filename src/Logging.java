import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logging {
    public static void logToFile(String s) {
        File log = FileManagement.createValidFile(
            "data/logs/" + DateTimeFormatter.ofPattern("yyyy_MM_dd").format(LocalDateTime.now()) + ".log"
        );

        try {
            FileWriter writer = new FileWriter(log, true);
            writer.write(s);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void info(String s) {
        logToFile(formatString(s, "INFO"));
    }

    public static void warn(String s) {
        String format = formatString(s, "WARN");
        logToFile(format);
        System.out.println(format);
    }

    public static String formatString(String s, String type) {
        return "[" + type + " (" + DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now())
            + ")] " + s + "\n";
    }
}
