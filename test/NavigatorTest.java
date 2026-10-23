package com.aitu.navigation;

public final class NavigatorTest {
    public static void main(String[] args) {
        RouteRequest request = new RouteRequest("A", "B", 12.0);
        Navigator navigator = new Navigator(new CarStrategy());
        checkTime(28, navigator.planRoute(request).estimatedMinutes(), "Car route");

        navigator.setStrategy(new WalkStrategy());
        checkTime(159, navigator.planRoute(request).estimatedMinutes(), "Walking route");

        navigator.setStrategy(new CycleStrategy());
        checkTime(55, navigator.planRoute(request).estimatedMinutes(), "Cycling route");

        expectIllegalArgument(() -> new RouteRequest("A", "B", -1));
        expectNullPointer(() -> navigator.setStrategy(null));
        System.out.println("All tests passed.");
    }

    private static void checkTime(int expected, int actual, String testName) {
        if (expected != actual) {
            throw new AssertionError(testName + ": expected " + expected + ", got " + actual);
        }
    }

    private static void expectIllegalArgument(Runnable action) {
        try {
            action.run();
            throw new AssertionError("Expected IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            // Validation works as expected.
        }
    }

    private static void expectNullPointer(Runnable action) {
        try {
            action.run();
            throw new AssertionError("Expected NullPointerException");
        } catch (NullPointerException expected) {
            // Validation works as expected.
        }
    }
}
