package edu.course.lab04;

import java.util.Objects;

final class MutableKey {
    private String name;
    MutableKey(String name) { this.name = name; }
    void setName(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(name, ((MutableKey) o).name);
    }

    @Override
    public int hashCode() { return Objects.hash(name); }
}
