import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class InnogyCar {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final int id;
    int mileage;
    LocalDateTime creationDate = LocalDateTime.now();
    LocalDateTime lastUsedDate;

    public InnogyCar() {
        id=counter.incrementAndGet();
        this.mileage = 0;
        lastUsedDate = null;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setLastUsedDate(LocalDateTime lastUsedDate) {
        this.lastUsedDate = lastUsedDate;
    }

    public int getId() {
        return id;
    }
}
