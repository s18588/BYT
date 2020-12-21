import com.sun.webkit.network.URLs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import static com.sun.webkit.network.URLs.newURL;

public class Observer {

    private Date lastModified;
    private final String url;
    

    public Observer(String url) throws IOException {
        this.url = url;
        URL address = URLs.newURL(url);
        URLConnection connect = address.openConnection();
        long longtime = connect.getLastModified();
        Date modifiedDate = new Date(longtime);
        this.lastModified = modifiedDate;
    }


    public void refresh() throws IOException {
        URL address = newURL(url);
        URLConnection connect = address.openConnection();
        var longtime = connect.getLastModified();
        Date modifiedDate = new Date(longtime);
        this.lastModified=modifiedDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Observer url: " + url + ", lastModified: " + lastModified;
    }

    public String serialize() {
        return url + "\n" + lastModified;
    }
}
