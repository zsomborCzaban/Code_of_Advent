package domains;

import java.util.Arrays;

public class MazeMap {
    private final int[][] mazeMap; // 0 = road, 1 = wall, 2 = start, 3 = end
    private final int[] startCoord;
    private final int[] endCoord;

    public MazeMap(int[][] map, int[] startCoord, int[] endCoord) {
        this.mazeMap = map;
        this.startCoord = startCoord;
        this.endCoord = endCoord;
    }

    public int[][] getMap() {
        return mazeMap;
    }

    public int[] getStartCoord() {
        return startCoord;
    }

    public int[] getEndCoord() {
        return endCoord;
    }

    public boolean isValidCoord(int[] coord){
        if(coord == null) return false;
        if(coord.length != 2) return false;
        if(coord[0] < 0 || coord[1] < 0) return false;
        if(coord[0] > mazeMap.length -1 || coord[1] > mazeMap[coord[0]].length -1) return false;

        return true;
    }

    public boolean isValidCoord(int x, int y){
        if(x < 0 || y < 0) return false;
        if(y > mazeMap.length -1 || x > mazeMap[y].length -1) return false;

        return true;
    }

    private int getCoordValue(int[] coord){
        if(!isValidCoord(coord)) return -1; //we could throw an error here
        return mazeMap[coord[0]][coord[1]];
    }

    public boolean isRoad(int[] coord){
        return getCoordValue(coord) == 0;
    }

    public boolean isWall(int[] coord){
        return getCoordValue(coord) == 1;
    }

    public boolean isEnd(int[] coord){
        return getCoordValue(coord) == 3;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Start coord: ").append(Arrays.toString(startCoord)).append('\n');
        sb.append("End coord: ").append(Arrays.toString(endCoord)).append('\n');
        sb.append("Maze map:");
//        sb.append("Maze map:\n").append(Arrays.deepToString(mazeMap)); this also works but a bit unreadable

        for(int i = 0; i < mazeMap.length; i++){
            sb.append('\n');
            for(int j = 0; j < mazeMap[i].length; j++){
                sb.append(mazeMap[i][j]);
            }
        }

        return sb.toString();
    }


}
