package ru.zalj.algorithms.search;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {

    @Test
    void search1() throws IOException {
        Path graphSource = Paths.get(
                DepthFirstSearchTest.class.getResource("/ru/zalj/algorithms/search/graph_simple.txt").getFile()
        );
        List<String> edges = Files.readAllLines(graphSource);
        DepthFirstSearch depthFirstSearch = DepthFirstSearch.getInstance(edges);
        String result = depthFirstSearch.contains(8);
        assertEquals("0-2-4-8", result);
    }
}