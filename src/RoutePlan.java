import java.util.Objects;

public record RoutePlan(String transportMode, int estimatedMinutes, String description) {
    public RoutePlan {
        Objects.requireNonNull(transportMode, "Transport mode must not be null");
        Objects.requireNonNull(description, "Description must not be null");
        if (transportMode.isBlank() || description.isBlank() || estimatedMinutes <= 0) {
            throw new IllegalArgumentException("Invalid route plan");
        }
    }
}
