package ru.zalj.algorithms.search.dijkstra;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraSearchTest {

    @Test
    public void test1() throws IOException {
        Path graphSource = Paths.get(
                DijkstraSearchTest.class.getResource("/ru/zalj/algorithms/search/graph_weight.txt").getFile()
        );
        List<String> objects = Files.readAllLines(graphSource);
        int splitIndex = objects.indexOf("SPLIT");
        List<String> nodes = objects.subList(0, splitIndex);
        List<String> edges = objects.subList(splitIndex + 1, objects.size());
        DijkstraSearch dijkstraSearch = DijkstraSearch.getInstance(nodes, edges);
        String path = dijkstraSearch.search(5, 20);
        assertEquals("[20, 18, 12, 6, 5]", path);
    }
}