package domains;

import java.util.Objects;

public class CustomPair {
    private final int first;
    private final int second;

    public CustomPair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CustomPair other = (CustomPair) obj;
        return this.first == other.first && this.second == other.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
