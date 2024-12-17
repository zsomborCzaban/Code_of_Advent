package drivers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class IO {
    public static int[][] readInputFile(String path) throws Exception {
        List<int[]> rows = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int[] row = new int[line.length()];
                for (int i = 0; i < line.length(); i++) {
                    if(!Character.isDigit(line.charAt(i))) throw new Exception("Invalid input format in input file");
                    row[i] = Character.getNumericValue(line.charAt(i));
                }
                rows.add(row);

            }

        } catch (Exception exception){
            throw exception;
        }

        return rows.toArray(new int[0][]);
    }
}
