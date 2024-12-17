package domains;

public class RaindeerState implements  Comparable<RaindeerState>{
    //on second tought creating an object for every state would be really ineffective, because of the overhead of an object

    //but I'll leave this class here because in other languages where an object (or struct) doesn't have a big overhead it would be a good practice to create a state class/struct
    private final int[] coord;
    private final Direction direction;
    private final int score;

    //for part 2
    private RaindeerState discoveredFrom;
    //

    public RaindeerState(int[] coord, Direction direction, int score, RaindeerState discoveredFrom){
        this.coord = coord;
        this.direction = direction;
        this.score = score;
        this.discoveredFrom = discoveredFrom;
    }

    public int[] getCoord() {
        return coord;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getScore() {
        return score;
    }

    public RaindeerState getDiscoveredFrom(){
        return discoveredFrom;
    }

    public int getX() {return coord[1];}

    public int getY() {return coord[0];}

    @Override
    public int compareTo(RaindeerState o) {
        return Integer.compare(score, o.score);
    }
}
