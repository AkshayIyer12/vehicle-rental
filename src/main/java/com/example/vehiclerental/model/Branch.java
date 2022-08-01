package com.example.vehiclerental.model;

import com.example.vehiclerental.enums.Type;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String name;
    private List<Type> types = new ArrayList<>();

    public Branch(String name, List<Type> types) {
        this.name = name;
        this.types.addAll(types);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types.clear();
        this.types.addAll(types);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                ", types=" + types +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Branch branch = (Branch) o;

        if (!name.equals(branch.name)) return false;
        return types.equals(branch.types);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + types.hashCode();
        return result;
    }
}
