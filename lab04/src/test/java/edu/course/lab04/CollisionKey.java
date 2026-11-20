package edu.course.lab04;

import java.util.Objects;

final class CollisionKey {
    private final String name;
    CollisionKey(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(name, ((CollisionKey) o).name);
    }

    @Override
    public int hashCode() { return 42; }
}
