package drivers;

import domains.MazeMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class IO {
    public static MazeMap readInputFile(String path) throws Exception {
        List<int[]> rows = new ArrayList<>(); //int[][] where 0 = road, 1 = wall, 2 = start, 3 = end
        int[] startCoord = null;
        int[] endCoord =  null;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            int j = -1;

            while ((line = reader.readLine()) != null) {
                j++;
                int[] row = new int[line.length()];

                for (int i = 0; i < line.length(); i++) {
                    if(line.charAt(i) == '.'){
                        row[i] = 0;
                        continue;
                    }
                    if(line.charAt(i) == '#'){
                        row[i] = 1;
                        continue;
                    }
                    if(line.charAt(i) == 'S'){
                        if(startCoord != null) throw new Exception("Invalid input format in input file");
                        startCoord = new int[]{j, i};
                        row[i] = 2;
                        continue;
                    }
                    if(line.charAt(i) == 'E'){
                        if(endCoord != null) throw new Exception("Invalid input format in input file");
                        endCoord = new int[]{j, i};
                        row[i] = 3;
                        continue;
                    }

                    throw new Exception("Invalid input format in input file");
                }
                rows.add(row);

            }

        } catch (Exception exception){
            throw exception;
        }

        return new MazeMap(rows.toArray(new int[0][]), startCoord, endCoord);
    }
}
