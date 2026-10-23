import java.util.Objects;

public final class CycleStrategy implements RouteStrategy {
    private static final double SPEED_KM_H = 15.0;
    private static final double DETOUR_MULTIPLIER = 1.10;
    private static final int BIKE_SETUP_MINUTES = 2;

    @Override
    public RoutePlan calculateRoute(RouteRequest request) {
        Objects.requireNonNull(request, "Route request must not be null");
        double cyclingMinutes = request.distanceKm() / SPEED_KM_H * 60;
        int totalMinutes = (int) Math.ceil(cyclingMinutes * DETOUR_MULTIPLIER + BIKE_SETUP_MINUTES);
        return new RoutePlan("Cycling", totalMinutes, "Includes bicycle-friendly detours and setup time");
    }
}
