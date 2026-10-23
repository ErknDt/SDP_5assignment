import java.util.Objects;

public final class Navigator {
    private RouteStrategy strategy;

    public Navigator(RouteStrategy initialStrategy) {
        setStrategy(initialStrategy);
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Strategy must not be null");
    }

    public RoutePlan planRoute(RouteRequest request) {
        return strategy.calculateRoute(request);
    }
}
