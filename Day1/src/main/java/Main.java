import drivers.IO;
import usecases.Solutions;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> columns = null;

        try {
            columns = IO.readTwoColumns("Day1/src/main/resources/input.txt");
        } catch (Exception e) {
            System.out.println("Reading the input failed: " + e);
            System.exit(1);
        }

        int totalDistance = Solutions.Part1(columns.get(0), columns.get(1));
        int similarityScore = Solutions.Part2(columns.get(0), columns.get(1));

        System.out.println("total distance: " + totalDistance);
        System.out.println("similarity score: " + similarityScore);

        try {
            IO.writeSolution(totalDistance, similarityScore, "Day1/src/main/resources/output.txt");
        } catch (Exception e) {
            System.out.println("Writing solution to file failed: " + e);
        }
    }
}