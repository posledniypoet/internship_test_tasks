package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        String firstAnalysisFile = args[0];
        String secondAnalysisFile = args[1];
        String firstOnlyOutputFile = args[2];
        String secondOnlyOutputFile = args[3];
        String bothOutputFile = args[4];

        List<String> firstAnalysisLines = Files.readAllLines(Paths.get(firstAnalysisFile));
        List<String> secondAnalysisLines = Files.readAllLines(Paths.get(secondAnalysisFile));

        Set<String> firstAnalysisSet = new HashSet<>();
        Set<String> secondAnalysisSet = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        for (String line : firstAnalysisLines) {
            ObjectNode problemNode = objectMapper.readValue(line, ObjectNode.class);
            String hash = problemNode.get("hash").asText();
            String data = objectMapper.writeValueAsString(problemNode.get("data"));
            String combined = hash + ":" + data;
            firstAnalysisSet.add(combined);
        }

        for (String line : secondAnalysisLines) {
            ObjectNode problemNode = objectMapper.readValue(line, ObjectNode.class);
            String hash = problemNode.get("hash").asText();
            String data = objectMapper.writeValueAsString(problemNode.get("data"));
            String combined = hash + ":" + data;
            secondAnalysisSet.add(combined);
        }

        Set<String> firstOnlySet = new HashSet<>(firstAnalysisSet);
        firstOnlySet.removeAll(secondAnalysisSet);

        Set<String> secondOnlySet = new HashSet<>(secondAnalysisSet);
        secondOnlySet.removeAll(firstAnalysisSet);

        Set<String> bothSet = new HashSet<>(firstAnalysisSet);
        bothSet.retainAll(secondAnalysisSet);

        writeJsonOutput(firstOnlySet, firstOnlyOutputFile);
        writeJsonOutput(secondOnlySet, secondOnlyOutputFile);
        writeJsonOutput(bothSet, bothOutputFile);
    }

    private static void writeJsonOutput(Set<String> problemSet, String outputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        ObjectNode rootNode = objectMapper.createObjectNode();
        ArrayNode problemsNode = rootNode.putArray("problems");

        for (String problem : problemSet) {
            String[] parts = problem.split(":");
            ObjectNode problemNode = objectMapper.createObjectNode();
            problemNode.put("hash", parts[0]);
            problemNode.set("data", objectMapper.readTree(parts[1]));
            problemsNode.add(problemNode);
        }

        objectMapper.writeValue(new File(outputFile), rootNode);
    }
}