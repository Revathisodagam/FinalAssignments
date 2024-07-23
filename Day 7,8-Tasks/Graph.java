package NonLinearTasks;

import java.util.*;


public class Graph {
	private Map<Integer, List<Integer>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addVertex(int v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    public void removeVertex(int v) {
        adjList.values().forEach(list -> list.remove(Integer.valueOf(v)));
        adjList.remove(v);
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void removeEdge(int u, int v) {
        adjList.get(u).remove(Integer.valueOf(v));
        adjList.get(v).remove(Integer.valueOf(u));
    }

    public boolean hasVertex(int v) {
        return adjList.containsKey(v);
    }

    public boolean hasEdge(int u, int v) {
        if (!adjList.containsKey(u) || !adjList.containsKey(v)) {
            return false;
        }
        return adjList.get(u).contains(v) && adjList.get(v).contains(u);
    }

    public List<Integer> dfs(int start) {
        List<Integer> visited = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        dfsRecursive(start, visited, seen);
        return visited;
    }

    private void dfsRecursive(int v, List<Integer> visited, Set<Integer> seen) {
        visited.add(v);
        seen.add(v);
        for (int neighbor : adjList.get(v)) {
            if (!seen.contains(neighbor)) {
                dfsRecursive(neighbor, visited, seen);
            }
        }
    }
    public List<Integer> bfs(int startVertex) {
        List<Integer> visited = new ArrayList<>();
        Set<Integer> visitedSet = new HashSet<>();
        LinkedList queue = new LinkedList();
        queue.add(startVertex);
        visitedSet.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = (int) queue.poll();
            visited.add(vertex);
            Map<Integer, List<Integer>> adjacencyList = null;
			for (int neighbor : adjacencyList.get(vertex)) {
                if (!visitedSet.contains(neighbor)) {
                    queue.add(neighbor);
                    visitedSet.add(neighbor);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Vertex 2 exists: " + graph.hasVertex(2));
        System.out.println("Edge (1, 2) exists: " + graph.hasEdge(1, 2));

        System.out.println("DFS traversal:");
        List<Integer> dfsResult = graph.dfs(0);
        System.out.println(dfsResult);

        System.out.println("BFS traversal:");
        List<Integer> bfsResult = graph.bfs(0);
        System.out.println(bfsResult);

        graph.removeVertex(2);
        graph.removeEdge(1, 2);

        System.out.println("Vertex 2 exists: " + graph.hasVertex(2));
        System.out.println("Edge (1, 2) exists: " + graph.hasEdge(1, 2));
    }
}
	
