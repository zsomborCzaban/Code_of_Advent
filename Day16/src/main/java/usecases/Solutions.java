package usecases;

import domains.CustomPair;
import domains.Direction;
import domains.MazeMap;
import domains.RaindeerState;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Solutions {

    public static void solution1(MazeMap mazeMap){
        if(!mazeMap.isValidCoord(mazeMap.getStartCoord())){
            System.out.println("invalid starting position provided in the map!");
            return;
        }

        int[][][] visitedRoads = new int[mazeMap.getMap().length][mazeMap.getMap()[0].length][4];
        RaindeerState startState = new RaindeerState(mazeMap.getStartCoord(), Direction.EAST, 0, null);
        //part 1
        //        RaindeerState minimalState = null;
        //part2
        ArrayList<RaindeerState> minimalEndStates = new ArrayList<>();

        PriorityQueue<RaindeerState> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(startState);

        while(!priorityQueue.isEmpty()){
            RaindeerState currentState = priorityQueue.remove();
//            part1
//                        if(mazeMap.isEnd(currentState.getCoord())){
//                minimalState = currentState;
//                break;
//            }
//            part1 end

//            part2
            if(!minimalEndStates.isEmpty() && minimalEndStates.get(0).getScore() < currentState.getScore()){
                break; //since we have a priority queue, its not possible to find anymore minimal solutions. (given we dont have negative edges in our graph)
            }

            if(mazeMap.isEnd(currentState.getCoord())){
                minimalEndStates.add(currentState);
            }
//            part2 end

            if(visitedRoads[currentState.getX()][currentState.getY()][currentState.getDirection().getValue()] < currentState.getScore() && visitedRoads[currentState.getX()][currentState.getY()][currentState.getDirection().getValue()] != 0) continue;
            visitedRoads[currentState.getX()][currentState.getY()][currentState.getDirection().getValue()] = currentState.getScore();

            int[] coordAhead = Utils.getCoordAhead(currentState.getCoord(), currentState.getDirection());
            if(mazeMap.isRoad(coordAhead) || mazeMap.isEnd(coordAhead)){
                priorityQueue.add(new RaindeerState(coordAhead, currentState.getDirection(), currentState.getScore() + 1, currentState));
            }

            int[] coordToLeft = Utils.getCoordOnLeft(currentState.getCoord(), currentState.getDirection());
            if(mazeMap.isRoad(coordToLeft) || mazeMap.isEnd(coordToLeft)){
                priorityQueue.add(new RaindeerState(currentState.getCoord(), currentState.getDirection().turnLeft(), currentState.getScore() + 1000, currentState));
            }

            int[] coordToRight = Utils.getCoordOnRight(currentState.getCoord(), currentState.getDirection());
            if(mazeMap.isRoad(coordToRight) || mazeMap.isEnd(coordToRight)){
                priorityQueue.add(new RaindeerState(currentState.getCoord(), currentState.getDirection().turnRight(), currentState.getScore() + 1000, currentState));
            }
        }

        if(minimalEndStates.isEmpty()){
            System.out.println("Theres no path from start to end");
            return;
        }

        System.out.println("Minimal score to end: " + minimalEndStates.get(0).getScore());

        HashSet<CustomPair> minimalPathRoads = new HashSet<>();
        for(RaindeerState raindeerState : minimalEndStates){
            RaindeerState currentState = raindeerState;

            while(currentState != null){
                minimalPathRoads.add(new CustomPair(currentState.getX(), currentState.getY()));
                currentState = currentState.getDiscoveredFrom();
            }
        }

        System.out.println("Roads party of minimal paths: " + minimalPathRoads.size());
        System.out.println("number of optimal paths: " + minimalEndStates.size());



    }

}
