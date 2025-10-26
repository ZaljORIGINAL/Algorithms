package ru.zalj.algorithms.search.dijkstra;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Алгоритм Дейкстры - Dijkstra
 */
public class DijkstraSearch {

    /**
     * Описывает отношение
     */
    private final Map<Integer, List<Integer>> graph;
    private final Map<Integer, Node> nodes;
    private final Map<Integer, Edge> edges;

    public DijkstraSearch(Map<Integer, Node> nodes, Map<Integer, Edge> edges, Map<Integer, List<Integer>> graph) {
        this.graph = graph;
        this.nodes = nodes;
        this.edges = edges;
    }

    public static DijkstraSearch getInstance(List<String> nodeLines, List<String> edgeLines) {
        Map<Integer, Node> nodes = parseNodes(nodeLines);
        Map<Integer, Edge> edges = parseEdges(edgeLines);
        Map<Integer, List<Integer>> graph = buildGraph(edges);

        return new DijkstraSearch(nodes, edges, graph);
    }

    private static Map<Integer, Node> parseNodes(List<String> nodeLines) {
        Map<Integer, Node> nodes = new HashMap<>();
        Pattern pattern = Pattern.compile("(\\d+):\\s*\\(([\\d.]+),\\s*([\\d.]+)\\)");

        for (String line : nodeLines) {
            Matcher matcher = pattern.matcher(line.trim());
            matcher.matches(); // Всегда верный формат
            int id = Integer.parseInt(matcher.group(1));
            double x = Double.parseDouble(matcher.group(2));
            double y = Double.parseDouble(matcher.group(3));
            nodes.put(id, new Node(id, x, y));
        }
        return nodes;
    }

    private static Map<Integer, Edge> parseEdges(List<String> edgeLines) {
        Map<Integer, Edge> edges = new HashMap<>();
        int edgeIdCounter = 1;
        Pattern pattern = Pattern.compile("(\\d+)-\\s*\\(([\\d.]+)\\)\\s*-(\\d+)");

        for (String line : edgeLines) {
            Matcher matcher = pattern.matcher(line.trim());
            matcher.matches(); // Всегда верный формат

            int from = Integer.parseInt(matcher.group(1));
            double weight = Double.parseDouble(matcher.group(2));
            int to = Integer.parseInt(matcher.group(3));

            // Добавляем ребро в обе стороны
            edges.put(edgeIdCounter, new Edge(edgeIdCounter, from, to, weight));
            edgeIdCounter++;
            edges.put(edgeIdCounter, new Edge(edgeIdCounter, to, from, weight));
            edgeIdCounter++;
        }
        return edges;
    }

    private static Map<Integer, List<Integer>> buildGraph(Map<Integer, Edge> edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (Edge edge : edges.values()) {
            graph.computeIfAbsent(edge.startId(), k -> new ArrayList<>()).add(edge.id());
        }

        return graph;
    }

    public String search(int startNodeId, int finishNodeId) {
        PathCollector pathCollector = new PathCollector();
        pathCollector.push(PathVector.buildStart(nodes.get(startNodeId)));

        while (true) {
            if (pathCollector.checkFinish(finishNodeId)) {
                return pathCollector.printPathToNode(finishNodeId);
            }
            PathVector optimal = pathCollector.getOptimalVector();
            for (Integer edgeId : graph.get(optimal.finishNodeId())) {
                Edge edge = edges.get(edgeId);
                pathCollector.push(PathVector.buildModifyVector(optimal, edge));
            }
        }
    }
}
