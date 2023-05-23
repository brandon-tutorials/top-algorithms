import java.util.*;
import java.util.logging.Logger;
class Graph {
    private static Logger logger = Logger.getLogger(Graph.class.getName());
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;
    Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjacencyList[i] = new LinkedList<>();
    }
    void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }
    void BFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);
        while (queue.size() != 0) {
            startVertex = queue.poll();
            logger.info(startVertex+" ");
            Iterator<Integer> iterator = adjacencyList[startVertex].listIterator();
            while (iterator.hasNext()) {
                int nextVertex = iterator.next();
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                }
            }
        }
    }
}
public class Main{
    private static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        int vertices = 7;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(6, 3);
        logger.info("Breadth-First Traversal (starting from vertex 0):");
        graph.BFS(0);
    }
}