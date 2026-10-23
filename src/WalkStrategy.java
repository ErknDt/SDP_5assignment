import java.util.Objects;

public final class WalkStrategy implements RouteStrategy {
    private static final double SPEED_KM_H = 5.0;
    private static final double CROSSING_MULTIPLIER = 1.10;

    @Override
    public RoutePlan calculateRoute(RouteRequest request) {
        Objects.requireNonNull(request, "Route request must not be null");
        double walkingMinutes = request.distanceKm() / SPEED_KM_H * 60;
        int totalMinutes = (int) Math.ceil(walkingMinutes * CROSSING_MULTIPLIER);
        return new RoutePlan("Walking", totalMinutes, "Includes extra time for pedestrian crossings");
    }
}
