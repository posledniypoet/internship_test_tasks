package qodana.code.metrics.engine.main;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CodeAnalyzer {
    private final String directoryPath;
    private final List<String> javaConditionalStatements = List.of("if", "else", "for", "while", "switch", "case");


    public CodeAnalyzer(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void checkFiles() {
        List<File> kotlinFiles = new ArrayList<>();
        List<File> javaFiles = new ArrayList<>();
        getFiles(javaFiles, directoryPath, ".java");
        getFiles(kotlinFiles, directoryPath, ".kt");
        for (File file : javaFiles) {
            String fileString = readFile(file);
            double camelCasePercentile = checkCamelCase(fileString);
            HashMap<String, Integer> methodComplexities = checkComplexity(fileString);
        }
    }

    private HashMap<String, Integer> checkComplexity(String fileString) {
        HashMap<String, Integer> result = new HashMap<>();
        int linesToSkip = 0;
        String[] splittedLines = fileString.split(System.lineSeparator();
        for (int i = 0; i < splittedLines.length; i++) {
            if(linesToSkip > 0){
                linesToSkip--;
                continue;
            }
            if (splittedLines[i].contains("void") || (splittedLines[i].contains("{") && splittedLines[i].contains("(") && !splittedLines[i].contains("class") && !splittedLines[i].contains("try") && !splittedLines[i].contains("catch")) && checkConditionalStatements(splittedLines[i])) {
                String methodName = getMethodName(splittedLines[i]);
                Pair temp = countConditionalStatements(splittedLines, i);
                linesToSkip = temp.linesSkipped;
                int methodsNumber = temp.methodsNumber;
                result.put(methodName, methodsNumber);
            }
        }
    }

    private Pair countConditionalStatements(String[] lines, int numberOfLine) {
        int countConds = 0;
        int linesToSkip = 0;
        for (int i = numberOfLine + 1; i < lines.length; i++){

        }

    }

    private double checkCamelCase(String fileString) {
        int badMethods = 0;
        int allMethods = 0;
        for (String line : fileString.split(System.lineSeparator())) {
            if (line.contains("void") || (line.contains("{") && line.contains("(") && !line.contains("class") && !line.contains("try") && !line.contains("catch")) && checkConditionalStatements(line)) {
                allMethods++;
                String methodName = getMethodName(line);
                String camelCasePattern = "([a-z]+[A-Z]+\\w+)+";
                if (!(methodName.matches(camelCasePattern))) {
                    badMethods++;
                }
            }
        }
        return (double) badMethods / allMethods * 100;
    }

    private String getMethodName(String str) {
        String[] splitFirst = str.split("\\(");
        String[] splitSecond = splitFirst[0].split(" ");
        return splitSecond[splitSecond.length - 1];
    }

    private boolean checkConditionalStatements(String str) {
        for (String statement : javaConditionalStatements) {
            if (str.contains(statement)) {
                return true;
            }
        }
        return false;
    }


    private String readFile(File file) {
        StringBuilder fileContents = new StringBuilder((int) file.length());
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine()).append(System.lineSeparator());
            }
        } catch (Exception ex) {
            System.out.println("Problem with reading file: " + file.getName());
        }
        return fileContents.toString();
    }


    private static void getFiles(List<File> files, String directoryPath, String extension) {
        if (directoryPath == null || directoryPath.isEmpty()) {
            throw new IllegalArgumentException("Directory path cannot be null or empty");
        }
        File directory = new File(directoryPath);
        File[] fList = directory.listFiles();
        if (fList != null) {
            for (File file : fList) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    getFiles(files, file.getAbsolutePath(), extension);
                }
            }
        }
    }

    final class Pair {
        private final int methodsNumber;
        private final int linesSkipped;

        public Pair(int methodsNumber, int linesSkipped) {
            this.methodsNumber = methodsNumber;
            this.linesSkipped = linesSkipped;
        }

        public int getMethodsNumber() {
            return methodsNumber;
        }

        public int getLinesSkipped() {
            return linesSkipped;
        }
    }
}
