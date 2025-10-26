package ru.zalj.algorithms.search.dijkstra;

import java.util.*;

public class PathCollector {

    /**
     * Описывает связь КОНЕЧНАЯ ТОЧКА : РЕБРЕ ЧЕРЕЗ КОТОРОЕ БЫЛО ДОСТИГНУТО
     */
    private final Map<Integer, PathVector> vectors;
    private final Queue<PathVector> optimalVectors;

    public PathCollector() {
        vectors = new HashMap<>();
        optimalVectors = new PriorityQueue<>();
    }

    public boolean checkFinish(int finishNodeId) {
        return vectors.containsKey(finishNodeId)
                && vectors.get(finishNodeId).weight() < optimalVectors.peek().weight();
    }

    public void push(PathVector newVector) {
        // Проверка наличия существующего пути до точки
        PathVector vector = vectors.get(newVector.finishNodeId());
        if (vector == null) {
            vectors.put(newVector.finishNodeId(), newVector);
            optimalVectors.add(newVector);
            return;
        }
        // Если новый путь оптимальнее, то обновляем значение
        if (newVector.weight() < vector.weight()) {
            optimalVectors.remove(vector);
            vectors.put(newVector.finishNodeId(), newVector);
            optimalVectors.add(newVector);
        }
    }

    public PathVector getOptimalVector() {
        return optimalVectors.poll();
    }

    public String printPathToNode(int finishNodeId) {
        if (!vectors.containsKey(finishNodeId)) {
            throw new RuntimeException("Path not exist!");
        }

        Stack<String> nodes = new Stack<>();
        while (finishNodeId != 0) {
            nodes.push(String.valueOf(finishNodeId));
            PathVector pathVector = vectors.get(finishNodeId);
            finishNodeId = pathVector.startNodeId();
        }
        return nodes.toString();
    }
}
