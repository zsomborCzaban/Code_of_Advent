package drivers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IO {

    public static List<List<Integer>> readTwoColumns(String path) throws Exception{
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] columnsString = line.split(" {3}");

                firstList.add(Integer.parseInt(columnsString[0]));
                secondList.add(Integer.parseInt(columnsString[1]));
            }

        } catch (Exception exception){
            throw new Exception("reading input file failed: " + exception);
        }

        return Arrays.asList(firstList, secondList);

    }

    public static void writeSolution(int totalDistance, int similarityScore, String destination) throws Exception{
        StringBuilder sb = new StringBuilder();
        sb.append("Solution for Code of Advent Day1\ncheck out the task here: https://adventofcode.com/2024/day/1\n\n");

        sb.append("Part 1\ntotal distance: ");
        sb.append(totalDistance);
        sb.append("\n\n");

        sb.append("Part 2\nsimilarity score: ");
        sb.append(similarityScore);
        sb.append("\n\n");

        try (FileWriter writer = new FileWriter(destination)) {
            writer.write(sb.toString());
        } catch (IOException exception){
            throw new Exception("writing solution failed: " + exception);
        }

    }
}
