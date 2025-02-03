package Usecases;

import java.util.List;

public class Solutions {

    public static int countSafeReports(List<List<Integer>> reports){
        int safeReports = 0;

        for(List<Integer> report : reports){
            if(report.size() < 2){      //With correct input this should never be true
                safeReports += 1;
                continue;
            }

            boolean isAscending = report.get(0) < report.get(1);
            if(isSafeReport(report, isAscending)){
                safeReports += 1;
            }
        }

        return safeReports;
    }


    public static int countSafeReportsWithDampener(List<List<Integer>> reports){
        List<List<Integer>> reportsToUse = reports.stream().toList(); //just in case to avoid accidentally modifying the original list.
        int safeReports = 0;

        for(List<Integer> report : reportsToUse){
            if(isSafeReportWithDampener(report, true) || isSafeReportWithDampener(report, false)){
                safeReports += 1;
            }
        }

        return safeReports;
    }

    private static boolean isSafeReportWithDampener(List<Integer> report, boolean isAscending){
        for(int i = 0; i <= report.size() - 2; i++){    //todo: refactor with while loop?
            if(Utils.isValidNeighbours(report.get(i), report.get(i+1), isAscending)){
                continue;
            }
            //we get here only if the neighbours are not valid

            //if i+2 is out of bounds, then i+1 is the last level, so we have a safe level if we remove i+1, therefore we can break from the loop since we know it's a safe level
            if(i+2 >= report.size()){
                return true;
            }


            //todo: refactor this to a more readable form
            boolean isValidReport = Utils.isValidNeighbours(report.get(i), report.get(i+2), isAscending) && isSafeReport(report.subList(i+2, report.size()), isAscending);

            if(i >= 1){
                isValidReport = isValidReport || (Utils.isValidNeighbours(report.get(i-1), report.get(i+1), isAscending) && isSafeReport(report.subList(i+1, report.size()), isAscending));
            } else {
                isValidReport = isValidReport || isSafeReport(report.subList(i+1, report.size()), isAscending);
            }

            return isValidReport;
        }

        return true;
    }

    private static boolean isSafeReport(List<Integer> report, boolean isAscending){
        for(int i = 0; i < report.size() - 1; i++){
            if(!Utils.isValidNeighbours(report.get(i), report.get(i+1), isAscending)){
                return false;
            }
        }

        return true;
    }
}
