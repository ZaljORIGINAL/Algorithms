package ru.zalj.algorithms.search.dijkstra;

public record PathVector(int startNodeId, int finishNodeId, double weight) implements Comparable<PathVector> {

    public static PathVector buildModifyVector(PathVector optimal, Edge edge) {
        return new PathVector(
                optimal.finishNodeId,
                edge.finishId(),
                optimal.weight() + edge.weight()
        );
    }

    public static PathVector buildStart(Node node) {
        return new PathVector(0, node.id(), 0);
    }

    @Override
    public int compareTo(PathVector o) {
        return Double.compare(weight, o.weight);
    }
}
