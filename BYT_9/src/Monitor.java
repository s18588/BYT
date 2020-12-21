import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.sun.webkit.network.URLs.newURL;

public class Monitor {

    private static final HashMap<Observer, Date> observers = new HashMap<>();

    public static void registerObserver(Observer observer) {
        if (!observers.containsKey(observer.getUrl())) {
            observers.put(observer, observer.getLastModified());
            System.out.printf("Observer %s registered, last modified %s.\n", observer.getUrl(),observer.getLastModified());
        } else {
            observers.replace(observer,observer.getLastModified());
            System.out.printf("Observer %s registered.\n", observer.getUrl());
        }
    }

    public static void checkUrls() throws IOException {
        for (var observer : observers.keySet()) {
            System.out.printf("Checking %s.\n",observer.getUrl());
            Date currentModified = observers.get(observer);
            observer.refresh();
            if (!observer.getLastModified().after(currentModified)) {
                observer.setLastModified(currentModified);
                System.out.println(observer.getUrl() + " was not modified.");
            } else {
                System.out.println(observer.getUrl() + " was modified, new date = " + observer.getLastModified());
            }
        }
    }

    public static void monitor() throws IOException {
        var counter = 2;
        while (counter>=0) {
            checkUrls();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter--;
        }
    }

    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (var observer : observers.keySet()) {
            sb.append(observer.serialize());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static HashMap<Observer, Date> getObservers() {
        return observers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monitor)) return false;

        Monitor myData = (Monitor) o;

        if(!myData.getObservers().keySet().equals(observers.keySet())) return false;
        return true;
    }

}

