import java.util.Objects;

public final class CarStrategy implements RouteStrategy {
    private static final double SPEED_KM_H = 40.0;
    private static final double TRAFFIC_MULTIPLIER = 1.25;
    private static final int PARKING_MINUTES = 5;

    @Override
    public RoutePlan calculateRoute(RouteRequest request) {
        Objects.requireNonNull(request, "Route request must not be null");
        double drivingMinutes = request.distanceKm() / SPEED_KM_H * 60;
        int totalMinutes = (int) Math.ceil(drivingMinutes * TRAFFIC_MULTIPLIER + PARKING_MINUTES);
        return new RoutePlan("Car", totalMinutes, "Includes estimated traffic and parking time");
    }
}
