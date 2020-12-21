import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Memento {

    public static final String file = "data.txt";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");

    public void writeToFile(Monitor monitor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(file)))) {
            writer.write(monitor.serialize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Monitor restore() throws ParseException {
        Monitor monitor = new Monitor();
        String url;
        Date lastModified;
        String line;
        try (Scanner reader  = new Scanner(new FileReader("data.txt"))) {
            line = reader.nextLine();
            while (line != null) {
                url = reader.nextLine();
                System.out.println(url);
                URL url1 = new URL(url);
                monitor.registerObserver(new Observer(url1.toString()));
                lastModified = DATE_FORMAT.parse(reader.nextLine());
                System.out.println(lastModified);
                if(!reader.hasNext()) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return monitor;
    }
}
