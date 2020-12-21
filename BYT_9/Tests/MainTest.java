import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.io.IOException;
import java.net.URLConnection;
import java.text.ParseException;


public class MainTest {


    private static Observer o1 = null;
    private static Observer o2 = null;
    private static Observer o3 = null;
    private static Observer o4 = null;

    static {
        try {
            o1 = new Observer("http://www.pja.edu.pl/");
            o2 = new Observer("http://www.tvn24.pl/");
            o3 = new Observer("http://www.twitter.com/");
            o4 = new Observer("http://www.reddit.com/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final Monitor monitor = new Monitor();
    private final Memento memento = new Memento();

    @Test
    public void monitorTest() throws IOException, ParseException {
        // run monitoring

        monitor.registerObserver(o1);
        monitor.registerObserver(o2);
        monitor.registerObserver(o3);
        monitor.registerObserver(o4);
        monitor.monitor();

        // memento
        memento.writeToFile(monitor);
        Monitor m = memento.restore();
        Assert.assertEquals(monitor, m);

    }

}
