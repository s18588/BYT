import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation_Subtract extends Operation {


    public Operation_Subtract(Operation successor) {
        super(successor);
    }

    @Override
    public String handle(String text) {
        System.out.println("Handling subtract");
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {

            if (matcher.group(2).contains("-")) {
                String result = String.valueOf(Double.parseDouble(matcher.group(1))-Double.parseDouble(matcher.group(3)));
                return result;
            }

            else if (successor != null) {
                return successor.handle(text);
            }
            else {
                System.out.println("Operation not supported");
                return null;
            }
        }

        return null;
    }
}
