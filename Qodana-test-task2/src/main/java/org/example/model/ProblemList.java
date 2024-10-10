package org.example.model;

import java.util.List;

public class ProblemList {
    public List<Problem> problems;

    public ProblemList(){
    }

    public ProblemList(List<Problem> problems) {
        this.problems = problems;
    }
    public List<Problem> getProblems() {
        return problems;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }
}
