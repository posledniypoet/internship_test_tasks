package org.example.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Problem {

    public Problem(){

    }
    private String hash;
    private Set<String> data;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Set<String> getData() {
        return data;
    }

    public void setData(Set<String> data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash, data);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Problem) {
            Problem arg = (Problem) obj;
            return Objects.equals(arg.getHash(), hash) && arg.getData().size() == data.size() && arg.getData().containsAll(data);

        }
        return false;
    }
}