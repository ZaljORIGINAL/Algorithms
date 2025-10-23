package ru.zalj.algorithms.search;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Поиск в ширину - Breadth-First Search
 * */
public class BreadthFirstSearch {
    private final Map<Integer, List<Integer>> graph;

    public BreadthFirstSearch(Map<Integer, List<Integer>> graph) {
        this.graph = graph;
    }

    public static BreadthFirstSearch getInstance(List<String> source) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (String s : source) {
            String[] parts = s.split("-");
            graph.computeIfAbsent(Integer.valueOf(parts[0]), (k) -> new ArrayList<>())
                    .add(Integer.valueOf(parts[1]));
        }
        return new BreadthFirstSearch(graph);
    }

    public String contains(Integer v) {
        Deque<List<Integer>> variants = new ArrayDeque<>();
        List<Integer> visited = new ArrayList<>();

        // Определение первого элемента
        Integer nodeId = graph.keySet().stream().min(Integer::compareTo).get();
        List<Integer> path = new ArrayList<>();
        path.add(nodeId);
        variants.push(path);
        visited.add(nodeId);

        // Поиск будет происходить до тех пор, пока алгоритм не
        // захочет произвести поиск за пределам вершины
        while (!variants.isEmpty()) {
            path = variants.pop();
            nodeId = path.getLast();
            // Проверка рассматриваемого элемента
            if (nodeId.equals(v)) {
                return Arrays.stream(path.toArray()).map(Object::toString).collect(Collectors.joining("-"));
            }

            // Получение следующий вариационных путей для движения
            List<Integer> nodes = graph.get(nodeId);
            if (nodes != null && !nodes.isEmpty()) {
                for (Integer node : nodes) {
                    if (visited.contains(node)) {
                        continue;
                    }
                    visited.add(node);
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(node);
                    variants.push(newPath);
                }
            }
        }

        return null;
    }
}
