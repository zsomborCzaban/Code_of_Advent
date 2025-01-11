package usecases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solutions {
    public static int Part1(List<Integer> firstColumn, List<Integer> secondColumn){
        int totalDistance = 0;

        firstColumn.sort(Integer::compareTo);
        secondColumn.sort(Integer::compareTo);

        for(int i = 0; i < firstColumn.size(); i++){
            totalDistance += Math.abs(firstColumn.get(i) - secondColumn.get(i));
        }

        return totalDistance;
    }

    public static int Part2(List<Integer> firstColumn, List<Integer> secondColumn){
        int similarityScore = 0;

        Map<Integer, Integer> occuranceMap = new HashMap<>();
        for(Integer number : secondColumn){
            int occurances = occuranceMap.getOrDefault(number, 0);
            occurances += 1;
            occuranceMap.put(number, occurances);
        }

        for(Integer number : firstColumn){
            similarityScore += number * occuranceMap.getOrDefault(number,0);
        }

        return similarityScore;
    }
}
