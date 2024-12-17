package usecases;

import domains.Direction;

public class Utils {

    public static int[] getCoordAhead(int[] currentCoord, Direction currentDirection){
        if(currentCoord.length != 2) return null;

        if(currentDirection == Direction.NORTH) return new int[]{currentCoord[0] - 1, currentCoord[1]};
        if(currentDirection == Direction.WEST) return new int[]{currentCoord[0], currentCoord[1] - 1};
        if(currentDirection == Direction.SOUTH) return new int[]{currentCoord[0] + 1, currentCoord[1]};
        if(currentDirection == Direction.EAST) return new int[]{currentCoord[0], currentCoord[1] + 1};

        return null;
    }

    public static int[] getCoordOnLeft(int[] currentCoord, Direction currentDirection){
        if(currentCoord.length != 2) return null;

        if(currentDirection == Direction.NORTH) return new int[]{currentCoord[0], currentCoord[1] - 1};
        if(currentDirection == Direction.WEST) return new int[]{currentCoord[0] + 1, currentCoord[1]};
        if(currentDirection == Direction.SOUTH) return new int[]{currentCoord[0], currentCoord[1] + 1};
        if(currentDirection == Direction.EAST) return new int[]{currentCoord[0] - 1, currentCoord[1]};

        return null;
    }

    public static int[] getCoordOnRight(int[] currentCoord, Direction currentDirection){
        if(currentCoord.length != 2) return null;

        if(currentDirection == Direction.NORTH) return new int[]{currentCoord[0], currentCoord[1] + 1};
        if(currentDirection == Direction.WEST) return new int[]{currentCoord[0] - 1, currentCoord[1]};
        if(currentDirection == Direction.SOUTH) return new int[]{currentCoord[0], currentCoord[1] - 1};
        if(currentDirection == Direction.EAST) return new int[]{currentCoord[0] + 1, currentCoord[1]};

        return null;
    }
}
