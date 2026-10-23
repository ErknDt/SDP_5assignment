public final class Main {
    public static void main(String[] args) {
        // The 12 km distance is illustrative, not calculated from an actual map.
        RouteRequest request = new RouteRequest("Campus", "City Park", 12.0);
        Navigator navigator = new Navigator(new CarStrategy());
        printRoute(navigator, request);

        navigator.setStrategy(new WalkStrategy());
        printRoute(navigator, request);

        navigator.setStrategy(new CycleStrategy());
        printRoute(navigator, request);
    }

    private static void printRoute(Navigator navigator, RouteRequest request) {
        RoutePlan plan = navigator.planRoute(request);
        System.out.printf("%s -> %s (%.1f km)%n", request.origin(), request.destination(), request.distanceKm());
        System.out.printf("Mode: %s | Time: %d min%n", plan.transportMode(), plan.estimatedMinutes());
        System.out.println("Details: " + plan.description());
        System.out.println();
    }
}
