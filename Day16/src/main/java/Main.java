import drivers.IO;
import domains.MazeMap;
import usecases.Solutions;

public class Main {
    public static void main(String[] args) {
        MazeMap mazeMap = null;

        try {
            mazeMap = IO.readInputFile("Day16/src/main/resources/input.txt");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(1);
        }

        System.out.println(mazeMap.toString());

        Solutions.solution1(mazeMap);
    }
}