# Assignment 5 — Strategy Pattern (Route Planning)

**Course:** Software Design Patterns  
**Language:** Java 17  
**Pattern:** Behavioral — Strategy  
**Topic:** Navigation / Route Planning (Option A)

## Overview
`Navigator` is the Context. It delegates the route time estimation to a `RouteStrategy` chosen by the Client (`Main`). `CarStrategy`, `WalkStrategy`, and `CycleStrategy` implement distinct estimation models. Strategies can be switched at runtime without adding if/switch statements to `Navigator`.

This is a **teaching simulation**, not a real map routing engine. The client supplies the route distance, and each algorithm estimates travel time with different assumptions (speed, traffic, crossings, or detours).

## Structure

```text
src/
  RouteRequest.java
  RoutePlan.java
  RouteStrategy.java
  CarStrategy.java
  WalkStrategy.java
  CycleStrategy.java
  Navigator.java
  Main.java
test/
  NavigatorTest.java
README.md
.gitignore
```

## Build and run (from project root)

Requires JDK 17 or newer.

```bash
New-Item -ItemType Directory -Force out | Out-Null
$javaFiles = @(Get-ChildItem .\src\*.java) + @(Get-ChildItem .\test\*.java)
javac --release 17 -d out $javaFiles.FullName
java -cp out Main
java -cp out NavigatorTest
```

In IntelliJ IDEA, open the folder as a project, set Project SDK to 17 or newer, mark src as Sources Root and test as Test Sources Root if needed, and run Main.

## Expected output

```text
Campus -> City Park (12.0 km)
Mode: Car | Time: 28 min
Details: Includes estimated traffic and parking time

Campus -> City Park (12.0 km)
Mode: Walking | Time: 159 min
Details: Includes extra time for pedestrian crossings

Campus -> City Park (12.0 km)
Mode: Cycling | Time: 55 min
Details: Includes bicycle-friendly detours and setup time
```

## Runtime switching

```java
Navigator navigator = new Navigator(new CarStrategy());
RoutePlan carPlan = navigator.planRoute(request);
navigator.setStrategy(new WalkStrategy());
RoutePlan walkPlan = navigator.planRoute(request);
```
