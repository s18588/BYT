import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pool {

    private static List<InnogyCar> available = new ArrayList<InnogyCar>();
    private static List<InnogyCar> inUse = new ArrayList<InnogyCar>();

    public InnogyCar create() {
        return new InnogyCar();
    }

    public InnogyCar checkOut() {

        if (available.isEmpty()) {
            available.add(create());
        }
        InnogyCar instance = available.iterator().next();
        available.remove(instance);
        inUse.add(instance);
        return instance;
    }

    public void checkIn(InnogyCar innogyCar) {
        inUse.remove(innogyCar);
        innogyCar.setMileage(innogyCar.mileage+50);
        innogyCar.setLastUsedDate(LocalDateTime.now());
        available.add(innogyCar);
    }
}
