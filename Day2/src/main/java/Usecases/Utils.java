package Usecases;

public class Utils {
    public static boolean isValidNeighbours(int leftNeighbour, int rightNeighbour, boolean isAscending){
        int difference = leftNeighbour - rightNeighbour;

        if(isAscending && difference > -4 && difference < 0) {
            return true;
        }

        if(!isAscending && difference < 4 && difference > 0){
            return true;
        }

        return false;
    }
}
