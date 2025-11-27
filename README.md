# Software Testing Project - Mutation Testing

This project is a Java-based implementation of various algorithms and integration components, designed for comprehensive software testing, specifically focusing on Mutation Testing using PIT.

## Project Overview

The project contains a collection of algorithms (Graph, Math, Searching, Sorting, String) and integration components. It is configured with JUnit 5 for unit testing and PIT for mutation testing.

## Features

### Algorithms (`com.testing.algo`)

*   **Graph**: BFS, DFS, Dijkstra, Graph implementation.
*   **Math**: Matrix Operations, Number Theory.
*   **Searching**: Binary Search, Jump Search, Linear Search.
*   **Sorting**: Bubble, Heap, Insertion, Merge, Quick, Selection Sort, and a Sorting Context.
*   **String**: Pattern Matching, String Manipulation.

### Integration (`com.testing.integration`)

*   **AlgorithmOrchestrator**: Orchestrates the execution of multiple algorithms.
*   **DataPipeline**: Manages data flow between components.

## Requirements

*   Java 17
*   Maven 3.x

## Build & Test

To build the project and run unit tests:

```bash
mvn clean test
```

## Mutation Testing

This project uses **PIT (Pitest)** for mutation testing.

### Configuration

*   **Target Classes**: `com.testing.*`
*   **Target Tests**: `com.testing.*`
*   **Mutators**:
    *   **Unit Level**: `CONDITIONALS_BOUNDARY`, `MATH`, `PRIMITIVE_RETURNS`,`NEGATE_CONDITIONALS`
    *   **Integration Level**: `NON_VOID_METHOD_CALLS`, `VOID_METHOD_CALLS`,`CONSTRUCTOR_CALLS`

### Running Mutation Tests

To run mutation tests and generate the report:

```bash
mvn org.pitest:pitest-maven:mutationCoverage
```

The HTML report will be generated in `target/pit-reports/`.

## Contributors

*   **IMT2022058 Ketan Ghungralekar**:
    *   **Algorithms**: Graph (BFS, DFS, Dijkstra), Sorting (Bubble, Heap, Insertion, Merge, Quick, Selection).
    *   **Integration**: AlgorithmOrchestrator.
    *   **Testing**: Mutation Testing configuration and analysis.

*   **IMT2022068 Prratham Chawdhry**:
    *   **Algorithms**: Searching (Binary, Jump, Linear), String (Pattern Matching, String Manipulator), Math (Matrix, Number Theory).
    *   **Integration**: DataPipeline.
    *   **Testing**: Mutation Testing configuration and analysis.

**Note**: Both contributors worked jointly on the project report.
