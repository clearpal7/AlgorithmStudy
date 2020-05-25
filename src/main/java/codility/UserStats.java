package codility;

import java.util.Optional;

public class UserStats {

    public Optional<Long> visitCount;

    public UserStats() {
        this.visitCount = Optional.of(3L);
    }

    public Optional<Long> getVisitCount() {
        return visitCount;
    }
}
