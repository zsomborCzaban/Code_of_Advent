package usecases;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solutions {

    //solution1: go through the map, for each 0 found start a search. a search goes through all possible roads and puts the found 9ns in a map based on its cordinates.
    public static void solution1(int[][] hikingPathMap){
        int trailheadScore = 0;
        int trailheadRating = 0;

        for(int i = 0; i < hikingPathMap.length; i++){
            for(int j = 0; j < hikingPathMap[i].length; j++){
                //probably passed by value, will cause performance issues
                if(hikingPathMap[i][j] == 0) trailheadScore += findTrailingHeadScores(hikingPathMap, i, j);
                if(hikingPathMap[i][j] == 0) trailheadRating += findTrailingHeadRatings(hikingPathMap, i, j);
            }
        }

        System.out.println("sum of trailhead score on the map: " + trailheadScore);
        System.out.println("sum of trailhead rating on the map: " + trailheadRating);
    }

    //solution2: go through the whole matrix 9 times, and keep count of from which field which 9 in accessable (first 9from8 then 8from7 then 7from6 and so on... and at the end calculate the number of avaiable 9s from 0s)
    public static void solution2(int[][] hikingPathMap){
//        todo: Implement me!
    }




    public static int findTrailingHeadScores(int[][] hikingPathMap, int coordX, int coordY){
        if(hikingPathMap[coordX][coordY] != 0) return 0;

        record MapCoord(int coordX, int coordY){} //records are compared by value and not address

        HashSet<MapCoord> foundTrailEnds = new HashSet<>();
        Queue<MapCoord> coordsToCheck = new LinkedList<>();  //could use a set instead of a queue, bc the order of checking of the coords doesn't matter. But we would have to implement a pop() method on the set which removes any element and returns it.
        coordsToCheck.add(new MapCoord(coordX, coordY));

        while(!coordsToCheck.isEmpty()){
            MapCoord currentCoord = coordsToCheck.remove();

            if(currentCoord.coordX - 1 >= 0){
                if(hikingPathMap[currentCoord.coordX - 1][currentCoord.coordY] - 1 == hikingPathMap[currentCoord.coordX][currentCoord.coordY]){
                    MapCoord validNextStep = new MapCoord(currentCoord.coordX - 1, currentCoord.coordY);

                    if(hikingPathMap[validNextStep.coordX][validNextStep.coordY] == 9){
                        foundTrailEnds.add(validNextStep);
                    } else {
                        coordsToCheck.add(validNextStep);

                    }
                }
            }

            if(currentCoord.coordX + 1 < hikingPathMap.length){
                if(hikingPathMap[currentCoord.coordX + 1][currentCoord.coordY] - 1 == hikingPathMap[currentCoord.coordX][currentCoord.coordY]){
                    MapCoord validNextStep = new MapCoord(currentCoord.coordX + 1, currentCoord.coordY);

                    if(hikingPathMap[validNextStep.coordX][validNextStep.coordY] == 9){
                        foundTrailEnds.add(validNextStep);
                    } else {
                        coordsToCheck.add(validNextStep);

                    }
                }
            }

            if(currentCoord.coordY - 1 >= 0){
                if(hikingPathMap[currentCoord.coordX][currentCoord.coordY - 1] - 1 == hikingPathMap[currentCoord.coordX][currentCoord.coordY]){
                    MapCoord validNextStep = new MapCoord(currentCoord.coordX, currentCoord.coordY - 1);

                    if(hikingPathMap[validNextStep.coordX][validNextStep.coordY] == 9){
                        foundTrailEnds.add(validNextStep);
                    } else {
                        coordsToCheck.add(validNextStep);

                    }
                }
            }

            if(currentCoord.coordY + 1 < hikingPathMap[coordX].length){
                if(hikingPathMap[currentCoord.coordX][currentCoord.coordY + 1] - 1 == hikingPathMap[currentCoord.coordX][currentCoord.coordY]){
                    MapCoord validNextStep = new MapCoord(currentCoord.coordX, currentCoord.coordY + 1);

                    if(hikingPathMap[validNextStep.coordX][validNextStep.coordY] == 9){
                        foundTrailEnds.add(validNextStep);
                    } else {
                        coordsToCheck.add(validNextStep);

                    }
                }
            }


        }

        return foundTrailEnds.size();
    }

    //its the same as the other one, but we dont need to keep track of the 9s, we can just increment a sum everytime we get to a 9 instead
    public static int findTrailingHeadRatings(int[][] hikingPathMap, int coordX, int coordY){
        if(hikingPathMap[coordX][coordY] != 0) return 0;

        record MapCoord(int coordX, int coordY){} //records are compared by value and not address

        int foundTrailEnds = 0;
        Queue<MapCoord> coordsToCheck = new LinkedList<>();  //could use a set instead of a queue, bc the order of checking of the coords doesn't matter. But we would have to implement a pop() method on the set which removes any element and returns it.
        coordsToCheck.add(new MapCoord(coordX, coordY));

        while(!coordsToCheck.isEmpty()){
            MapCoord currentCoord = coordsToCheck.remove();

            if(currentCoord.coordX - 1 >= 0){
                if(hikingPathMap[currentCoord.coordX - 1][currentCoord.coordY] - 1 == hikingPathMap[currentCoord.coordX][currentCoord.coordY]){
                    MapCoord validNextStep = new MapCoord(currentCoord.coordX - 1, currentCoord.coordY);

                    if(hikingPathMap[validNextStep.coordX][validNextStep.coordY] == 9){
                        foundTrailEnds += 1;
                    } else {
                        coordsToCheck.add(validNextStep);

                    }
                }
            }

            if(currentCoord.coordX + 1 < hikingPathMap.length){
                if(hikingPathMap[currentCoord.coordX + 1][currentCoord.coordY] - 1 == hikingPathMap[currentCoord.coordX][currentCoord.coordY]){
                    MapCoord validNextStep = new MapCoord(currentCoord.coordX + 1, currentCoord.coordY);

                    if(hikingPathMap[validNextStep.coordX][validNextStep.coordY] == 9){
                        foundTrailEnds += 1;
                    } else {
                        coordsToCheck.add(validNextStep);

                    }
                }
            }

            if(currentCoord.coordY - 1 >= 0){
                if(hikingPathMap[currentCoord.coordX][currentCoord.coordY - 1] - 1 == hikingPathMap[currentCoord.coordX][currentCoord.coordY]){
                    MapCoord validNextStep = new MapCoord(currentCoord.coordX, currentCoord.coordY - 1);

                    if(hikingPathMap[validNextStep.coordX][validNextStep.coordY] == 9){
                        foundTrailEnds += 1;
                    } else {
                        coordsToCheck.add(validNextStep);

                    }
                }
            }

            if(currentCoord.coordY + 1 < hikingPathMap[coordX].length){
                if(hikingPathMap[currentCoord.coordX][currentCoord.coordY + 1] - 1 == hikingPathMap[currentCoord.coordX][currentCoord.coordY]){
                    MapCoord validNextStep = new MapCoord(currentCoord.coordX, currentCoord.coordY + 1);

                    if(hikingPathMap[validNextStep.coordX][validNextStep.coordY] == 9){
                        foundTrailEnds += 1;
                    } else {
                        coordsToCheck.add(validNextStep);

                    }
                }
            }


        }

        return foundTrailEnds;
    }
}
