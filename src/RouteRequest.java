import java.util.Objects;

public record RouteRequest(String origin, String destination, double distanceKm) {
    public RouteRequest {
        Objects.requireNonNull(origin, "Origin must not be null");
        Objects.requireNonNull(destination, "Destination must not be null");
        if (origin.isBlank() || destination.isBlank()) {
            throw new IllegalArgumentException("Origin and destination must not be blank");
        }
        if (!Double.isFinite(distanceKm) || distanceKm <= 0) {
            throw new IllegalArgumentException("Distance must be a positive, finite number");
        }
    }
}
