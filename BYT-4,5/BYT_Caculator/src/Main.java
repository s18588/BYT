import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final Operation operation1 = new Operation_Add(null);
    public static final Operation operation2 = new Operation_Divide(operation1);
    public static final Operation operation3 = new Operation_Multiply(operation2);
    public static final Operation operation4 = new Operation_Subtract(operation3);

    public static void main(String[] args) {
        String REGEX = "(\\d*)\\s*(\\W?)\\s*(\\d*)";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher("2+4");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
        System.out.println(operation4.handle("2*4"));
        System.out.println(operation4.handle("2+4"));
        System.out.println(operation4.handle("2/4"));
        System.out.println(operation4.handle("2-4"));
    }
}
