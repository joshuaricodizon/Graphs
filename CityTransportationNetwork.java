package Graphs;

import java.util.List;

public class CityTransportationNetwork {
    public static void main(String[] args) {
        Graph cityGraph = new Graph();

        // Adding vertices
        cityGraph.addVertex("A");
        cityGraph.addVertex("B");
        cityGraph.addVertex("C");
        cityGraph.addVertex("D");
        cityGraph.addVertex("E");
        cityGraph.addVertex("F");
        cityGraph.addVertex("G");
        cityGraph.addVertex("H");
        cityGraph.addVertex("I");
        cityGraph.addVertex("J");

        // Adding edges
        cityGraph.addEdge("A", "B");
        cityGraph.addEdge("A", "C");
        cityGraph.addEdge("B", "D");
        cityGraph.addEdge("B", "E");
        cityGraph.addEdge("C", "F");
        cityGraph.addEdge("C", "G");
        cityGraph.addEdge("D", "H");
        cityGraph.addEdge("E", "I");
        cityGraph.addEdge("F", "J");
        cityGraph.addEdge("G", "J");
        cityGraph.addEdge("H", "J");
        cityGraph.addEdge("I", "J");

        // BFS traversal
        System.out.println("BFS Traversal:");
        cityGraph.bfs("A");
        System.out.println();

        // DFS traversal
        System.out.println("\nDFS Traversal:");
        cityGraph.dfs("A");
        System.out.println();

        // Shortest path using BFS
        String start = "A";
        String end = "J";
        System.out.println("\nShortest Path from " + start + " to " + end + ":");
        List<String> shortestPath = cityGraph.shortestPathBFS(start, end);

        if (shortestPath != null) {
            System.out.println(String.join(" -> ", shortestPath));
        } else {
            System.out.println("No path found.");
        }
    }
}