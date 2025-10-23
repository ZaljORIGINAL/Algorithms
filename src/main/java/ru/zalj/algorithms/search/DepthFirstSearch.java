package ru.zalj.algorithms.search;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Поиск в глубину - Depth-First Search
 */
public class DepthFirstSearch {
    private final Map<Integer, List<Integer>> graph;

    public DepthFirstSearch(Map<Integer, List<Integer>> graph) {
        this.graph = graph;
    }

    public static DepthFirstSearch getInstance(List<String> source) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (String s : source) {
            String[] parts = s.split("-");
            graph.computeIfAbsent(Integer.valueOf(parts[0]), (k) -> new ArrayList<>())
                    .add(Integer.valueOf(parts[1]));
        }
        return new DepthFirstSearch(graph);
    }

    public String contains(Integer v) {
        Stack<Integer> path = new Stack<>();
        List<Integer> visited = new ArrayList<>();

        // Определение первого элемента
        Integer nodeId = graph.keySet().stream().min(Integer::compareTo).get();
        path.push(nodeId);
        visited.add(nodeId);

        // Поиск будет происходить до тех пор, пока алгоритм не
        // захочет произвести поиск за пределам вершины
        while (!path.isEmpty()) {
            // Проверка рассматриваемого элемента
            if (nodeId.equals(v)) {
                return Arrays.stream(path.toArray()).map(Object::toString).collect(Collectors.joining("-"));
            }

            // Получение следующего элемента в глубину для рассмотрения
            List<Integer> nodes = graph.get(nodeId);
            Optional<Integer> nextId = nodes == null || nodes.isEmpty() ?
                    Optional.empty() :
                    nodes.stream().filter(i -> !visited.contains(i))
                            .findFirst();
            // Найден элемент "глубже" для рассмотрения
            if (nextId.isPresent()) {
                // Регистрируем новый элемент для проверки
                nodeId = nextId.get();
                path.push(nodeId);
                visited.add(nodeId);
            } else {
                // Возвращаемся к предыдущему элементу
                path.pop();
                nodeId = path.peek();
            }
        }

        return null;
    }
}
