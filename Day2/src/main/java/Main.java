import Drivers.IO;
import Usecases.Solutions;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<List<Integer>> reports = null;

        try {
            reports = IO.readReports("Day2/src/main/resources/input.txt");
        } catch (Exception e) {
            System.out.println("Reading the input failed: " + e);
            System.exit(1);
        }

        int safeReports = Solutions.countSafeReports(reports);
        int safeReportsWithDampener = Solutions.countSafeReportsWithDampener(reports);

        System.out.println("Safe reports in part 1: " + safeReports);
        System.out.println("Safe reports in part 2: " + safeReportsWithDampener);
    }
}