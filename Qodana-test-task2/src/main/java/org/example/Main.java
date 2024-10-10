package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Problem;
import org.example.model.ProblemList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String stringPath1 = in.nextLine();
        String stringPath2 = in.nextLine();
        Path path = Paths.get(stringPath1);
        Path path2 = Paths.get(stringPath2);
        String firstAnalysisLines = Files.readString(path);
        String secondAnalysisLines = Files.readString(path2);
        String firstOnlyOutputFile = in.nextLine();
        String secondOnlyOutputFile = in.nextLine();
        String unionOutputFile = in.nextLine();

        ObjectMapper objectMapper = new ObjectMapper();
        ProblemList problemList1 = objectMapper.readValue(firstAnalysisLines, ProblemList.class);
        ProblemList problemList2 = objectMapper.readValue(secondAnalysisLines, ProblemList.class);
        ArrayList<Problem> problemsUnion = new ArrayList<>();

        for (Problem problem1 : problemList1.problems) {
            String hashProblem1 = problem1.getHash();
            Set<String> dataProblem1 = problem1.getData();
            for (Problem problem2 : problemList2.problems) {
                String hashProblem2 = problem2.getHash();
                Set<String> dataProblem2 = problem2.getData();
                if (Objects.equals(hashProblem2, hashProblem1) && dataProblem2.size() == dataProblem1.size() && dataProblem2.containsAll(dataProblem1)) {
                    if(!problemsUnion.contains(problem1))
                        problemsUnion.add(problem1);
                }
            }
        }
        problemList1.getProblems().removeAll(problemsUnion);
        problemList2.getProblems().removeAll(problemsUnion);
        objectMapper.writeValue(new File(firstOnlyOutputFile), problemList1);
        objectMapper.writeValue(new File(secondOnlyOutputFile), problemList2);
        objectMapper.writeValue(new File(unionOutputFile), new ProblemList(problemsUnion));
    }

}