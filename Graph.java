package Graphs;

import java.util.*;

import java.util.*;

class Graph {
    private Map<String, List<String>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(String source, String destination) {
        adjacencyList.get(source).add(destination);
    }

    public void bfs(String startVertex) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            String currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (String neighbor : adjacencyList.get(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public void dfs(String startVertex) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            String currentVertex = stack.pop();

            if (!visited.contains(currentVertex)) {
                System.out.print(currentVertex + " ");
                visited.add(currentVertex);

                for (String neighbor : adjacencyList.get(currentVertex)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public List<String> shortestPathBFS(String startVertex, String endVertex) {
        Queue<String> queue = new LinkedList<>();
        Map<String, String> parentMap = new HashMap<>();

        queue.add(startVertex);
        parentMap.put(startVertex, null);

        while (!queue.isEmpty()) {
            String currentVertex = queue.poll();

            if (currentVertex.equals(endVertex)) {
                return constructPath(parentMap, startVertex, endVertex);
            }

            for (String neighbor : adjacencyList.get(currentVertex)) {
                if (!parentMap.containsKey(neighbor)) {
                    queue.add(neighbor);
                    parentMap.put(neighbor, currentVertex);
                }
            }
        }

        return null; // No path found
    }

    private List<String> constructPath(Map<String, String> parentMap, String startVertex, String endVertex) {
        List<String> path = new ArrayList<>();
        String currentVertex = endVertex;

        while (currentVertex != null) {
            path.add(currentVertex);
            currentVertex = parentMap.get(currentVertex);
        }

        Collections.reverse(path);
        return path;
    }
}