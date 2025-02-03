package Drivers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class IO {

    public static List<List<Integer>> readReports(String path) throws Exception{
        List<List<Integer>> reports = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                List<Integer> report = new ArrayList<>();
                String[] reportString = line.split(" ");

                for(String level : reportString){
                    report.add(Integer.parseInt(level));
                }

                reports.add(report);
            }

        } catch (Exception exception){
            throw new Exception("reading input file failed: " + exception);
        }

        return reports;

    }

}
