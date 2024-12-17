import drivers.IO;
import usecases.Solutions;

public class Main {
    public static void main(String[] args){
        int[][] hikingPathMap = null;

        try {
            hikingPathMap = IO.readInputFile("Day10/src/main/resources/input.txt");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }
        //System.out.println(Arrays.deepToString(hikingPathMap));

        //solution1: go through the map, for each 0 found start a search. a search goes through all possible roads and puts the found 9ns in a map based on its cordinates.
        Solutions.solution1(hikingPathMap);

        //solution2: go through the whole matrix 9 times, and keep count of from which field which 9 in accessable (first 9from8 then 8from7 then 7from6 and so on... and at the end calculate the number of avaiable 9s from 0s)
        //Solutions.solution2(hikingPathMap);
    }
}